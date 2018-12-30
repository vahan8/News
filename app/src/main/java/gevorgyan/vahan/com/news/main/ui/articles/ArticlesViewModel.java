package gevorgyan.vahan.com.news.main.ui.articles;

import java.util.List;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import gevorgyan.vahan.com.news.main.data.repository.ArticlesRepository;
import gevorgyan.vahan.com.news.main.domain.model.Article;

public class ArticlesViewModel extends ViewModel {
    private MutableLiveData<List<Article>> articlesLiveData;

    public ArticlesViewModel() {
        articlesLiveData = ArticlesRepository.getArticles();
    }

    public MutableLiveData<List<Article>> getArticlesObservable() {
        return articlesLiveData;
    }
}
