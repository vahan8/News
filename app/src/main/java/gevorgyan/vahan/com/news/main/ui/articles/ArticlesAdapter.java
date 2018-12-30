package gevorgyan.vahan.com.news.main.ui.articles;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import gevorgyan.vahan.com.news.R;
import gevorgyan.vahan.com.news.main.data.remote.glide.ImageLoader;
import gevorgyan.vahan.com.news.main.domain.model.Article;
import gevorgyan.vahan.com.news.main.util.DateUtils;

public class ArticlesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private LayoutInflater inflater;
    private List<Article> articles;

    private ItemsClickListener itemClickListener;

    public interface ItemsClickListener {
        void onClick(Article article);
    }

    public ArticlesAdapter(Context context, List<Article> articles) {
        this.inflater = LayoutInflater.from(context);
        this.articles = articles;

    }

    public void setItemClickListener(ItemsClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public void swap(List<Article> articles) {
        this.articles.clear();
        this.articles.addAll(articles);
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.list_item_articles, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewHolder) ((ViewHolder) holder).bindData(position);
    }

    @Override
    public int getItemCount() {
        return articles == null ? 0 : articles.size();
    }


    private class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView textViewTitle;
        private TextView textViewCaption;
        private TextView textViewPublishedDate;
        private ImageView imageViewImage;

        ViewHolder(View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.textview_title);
            textViewCaption = itemView.findViewById(R.id.textview_caption);
            textViewPublishedDate = itemView.findViewById(R.id.textview_published_date);
            imageViewImage = itemView.findViewById(R.id.imageview_image);

            itemView.setOnClickListener(this);
        }


        void bindData(int position) {
            Article article = articles.get(position);

            textViewCaption.setText(article.getSource().getName());
            textViewPublishedDate.setText(DateUtils.getFormattedDate(article.getPublishedAt()));
            textViewTitle.setText(article.getTitle());

            //Download image with Glide
            ImageLoader.load(itemView.getContext(), imageViewImage, article.getUrlToImage());
        }

        @Override
        public void onClick(View v) {
            Article article = articles.get(getLayoutPosition());
            itemClickListener.onClick(article);
        }
    }

}
