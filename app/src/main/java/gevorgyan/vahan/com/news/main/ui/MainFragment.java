package gevorgyan.vahan.com.news.main.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import gevorgyan.vahan.com.news.R;
import gevorgyan.vahan.com.news.main.domain.model.Article;

public class MainFragment extends Fragment {

    private MainViewModel articlesViewModel;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        final TextView tvMessage = getView().findViewById(R.id.textview_message);

        articlesViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        articlesViewModel.getArticlesObservable().observe(this, new Observer<List<Article>>() {
            @Override
            public void onChanged(List<Article> articles) {
                // This is for testing api
                tvMessage.setText("articles count is " + articles.size());
            }
        });

    }

}
