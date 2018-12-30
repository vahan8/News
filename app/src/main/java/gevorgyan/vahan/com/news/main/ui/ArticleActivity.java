package gevorgyan.vahan.com.news.main.ui;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import gevorgyan.vahan.com.news.R;
import gevorgyan.vahan.com.news.main.data.remote.glide.ImageLoader;
import gevorgyan.vahan.com.news.main.data.repository.ArticlesRepository;
import gevorgyan.vahan.com.news.main.domain.model.Article;

public class ArticleActivity extends AppCompatActivity {

    public static final String KEY_ARTICLE = "KEY_ARTICLE";

    private Article article;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);

        //Get Article from bundle
        Bundle bundle = getIntent().getExtras();
        article = (Article) bundle.getSerializable(KEY_ARTICLE);

        setTitle(article.getSource().getName());

        // Handle Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView textViewContent = findViewById(R.id.textview_content);
        String content = article.getContent() == null ? article.getDescription() : article.getContent();
        textViewContent.setText(content);
        ImageView imageViewImage = findViewById(R.id.imageview_image);
        ImageLoader.load(this, imageViewImage, article.getUrlToImage());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_article, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            case R.id.menu_save:
                save();
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void save() {
        ArticlesRepository.storeArticle(article);
    }

}
