package gevorgyan.vahan.com.news.main.data.repository;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import androidx.lifecycle.MutableLiveData;
import gevorgyan.vahan.com.news.main.data.db.dao.ArticleDao;
import gevorgyan.vahan.com.news.main.domain.model.Article;
import gevorgyan.vahan.com.news.main.data.remote.ApiClient;

public final class ArticlesRepository {
    private ArticlesRepository() {
    }

    public static void storeArticle(Article article) {
        ArticleDao.insert(article);
    }

    public static MutableLiveData<List<Article>> getArticles() {
        return ApiClient.getArticles();
    }

    public static MutableLiveData<List<Article>> getSavedArticles() {
        final MutableLiveData<List<Article>> savedArticlesLiveData = new MutableLiveData<>();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                savedArticlesLiveData.postValue(ArticleDao.getArticles());
            }
        });
        return savedArticlesLiveData;
    }


}
