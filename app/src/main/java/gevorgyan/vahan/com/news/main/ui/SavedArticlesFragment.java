package gevorgyan.vahan.com.news.main.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import gevorgyan.vahan.com.news.R;
import gevorgyan.vahan.com.news.main.domain.model.Article;

public class SavedArticlesFragment extends Fragment {

    private RecyclerView articlesRecyclerView;
    private SavedArticlesAdapter articlesAdapter;

    private SavedArticlesViewModel articlesViewModel;

    public static SavedArticlesFragment newInstance() {
        return new SavedArticlesFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_saved_articles, container, false);
        articlesRecyclerView = view.findViewById(R.id.recyclerview_saved_articles);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // ViewModel initialization
        articlesViewModel = ViewModelProviders.of(this).get(SavedArticlesViewModel.class);
        articlesViewModel.loadData();
        articlesViewModel.getSavedArticlesObservable().observe(this, new Observer<List<Article>>() {
            @Override
            public void onChanged(List<Article> articles) {
                // Refresh data
                articlesAdapter.swap(articles);
            }
        });

        // RecyclerView initialization
        RecyclerView.ItemAnimator itemAnimator = new DefaultItemAnimator();
        articlesRecyclerView.setItemAnimator(itemAnimator);
        articlesRecyclerView.setLayoutManager(new LinearLayoutManager(requireActivity()));
        articlesAdapter = new SavedArticlesAdapter(requireActivity(), new ArrayList<Article>());
        articlesAdapter.setItemClickListener(new SavedArticlesAdapter.ItemsClickListener() {
            @Override
            public void onClick(Article article) {
                openArticle(article);
            }

            @Override
            public void onDeleteClick(Article article) {
                articlesViewModel.delete(article);
            }
        });

        articlesRecyclerView.setAdapter(articlesAdapter);
    }

    private void openArticle(Article article) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(ArticleActivity.KEY_ARTICLE, article);
        Intent intent = new Intent(requireActivity(), ArticleActivity.class);
        intent.putExtras(bundle);

        startActivity(intent);
    }


}
