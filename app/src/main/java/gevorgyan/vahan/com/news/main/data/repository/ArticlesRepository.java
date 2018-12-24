package gevorgyan.vahan.com.news.main.data.repository;

import java.util.List;

import androidx.lifecycle.MutableLiveData;
import gevorgyan.vahan.com.news.main.domain.model.Article;
import gevorgyan.vahan.com.news.main.data.remote.ApiClient;

public final class ArticlesRepository {
    private ArticlesRepository() {
    }

    public static MutableLiveData<List<Article>> getArticles(){
        return ApiClient.getArticles();
    }

}
