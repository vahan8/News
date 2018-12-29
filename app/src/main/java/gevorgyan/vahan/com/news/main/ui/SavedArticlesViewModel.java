package gevorgyan.vahan.com.news.main.ui;

import java.util.List;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import gevorgyan.vahan.com.news.main.data.repository.ArticlesRepository;
import gevorgyan.vahan.com.news.main.domain.model.Article;

public class SavedArticlesViewModel extends ViewModel {
    private MutableLiveData<List<Article>> savedArticlesLiveData;

    public SavedArticlesViewModel() {
        savedArticlesLiveData = ArticlesRepository.getSavedArticles();
    }

    public MutableLiveData<List<Article>> getSavedArticlesObservable() {
        return savedArticlesLiveData;
    }
}
