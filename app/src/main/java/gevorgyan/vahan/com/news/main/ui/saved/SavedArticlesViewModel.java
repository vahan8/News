package gevorgyan.vahan.com.news.main.ui.saved;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import gevorgyan.vahan.com.news.main.data.repository.ArticlesRepository;
import gevorgyan.vahan.com.news.main.domain.model.Article;

public class SavedArticlesViewModel extends ViewModel {
    private MutableLiveData<List<Article>> savedArticlesLiveData;
    private ExecutorService executorService;

    public SavedArticlesViewModel() {
        savedArticlesLiveData = new MutableLiveData<>();
        executorService = Executors.newSingleThreadExecutor();
    }

    public MutableLiveData<List<Article>> getSavedArticlesObservable() {
        return savedArticlesLiveData;
    }

    public void delete(final Article article) {
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                ArticlesRepository.removeArticleFromSaved(article);
                savedArticlesLiveData.postValue(ArticlesRepository.getSavedArticles());
            }
        });
    }

    public void loadData() {
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                savedArticlesLiveData.postValue(ArticlesRepository.getSavedArticles());
            }
        });
    }
}
