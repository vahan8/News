package gevorgyan.vahan.com.news.main.data.repository;

import java.util.List;

import androidx.lifecycle.MutableLiveData;
import gevorgyan.vahan.com.news.main.data.db.dao.ArticleDao;
import gevorgyan.vahan.com.news.main.data.remote.ApiClient;
import gevorgyan.vahan.com.news.main.domain.model.Article;

public final class ArticlesRepository {
    private ArticlesRepository() {
    }

    public static void storeArticle(Article article) {
        ArticleDao.insert(article);
    }

    public static void removeArticleFromSaved(Article article) {
        ArticleDao.delete(article.getTitle());
    }

    public static MutableLiveData<List<Article>> getArticles() {
        return ApiClient.getArticles();
    }

    public static List<Article> getSavedArticles() {
        return ArticleDao.getArticles();
    }

}
