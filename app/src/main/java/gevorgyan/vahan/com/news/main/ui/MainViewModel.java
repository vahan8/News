package gevorgyan.vahan.com.news.main.ui;

import java.util.List;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import gevorgyan.vahan.com.news.main.data.repository.ArticlesRepository;
import gevorgyan.vahan.com.news.main.domain.model.Article;

public class MainViewModel extends ViewModel {
    private MutableLiveData<List<Article>> articlesLiveData;

    public MainViewModel() {
        articlesLiveData = ArticlesRepository.getArticles();
    }

    public MutableLiveData<List<Article>> getArticlesObservable() {
        return articlesLiveData;
    }
}
