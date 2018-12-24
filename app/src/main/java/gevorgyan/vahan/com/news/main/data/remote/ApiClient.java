package gevorgyan.vahan.com.news.main.data.remote;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import gevorgyan.vahan.com.news.main.domain.model.Article;
import gevorgyan.vahan.com.news.main.domain.model.QueryResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public final class ApiClient {

    private ApiClient() {
    }

    public static MutableLiveData<List<Article>> getArticles() {
        final MutableLiveData<List<Article>> articlesLiveData = new MutableLiveData<>();

        Call<QueryResponse> call = ApiProvider.getClient().create(ApiInterface.class).getArticles();
        call.enqueue(new Callback<QueryResponse>() {
            @Override
            public void onResponse(@NonNull Call<QueryResponse> call, @NonNull Response<QueryResponse> response) {
                QueryResponse queryResponse = response.body();
                if (queryResponse != null) {
                    articlesLiveData.postValue(queryResponse.getArticles());
                }
            }

            @Override
            public void onFailure(Call<QueryResponse> call, Throwable t) {
            }
        });

        return articlesLiveData;
    }

}
