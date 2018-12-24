package gevorgyan.vahan.com.news.main.data.remote;

import gevorgyan.vahan.com.news.main.domain.model.QueryResponse;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("top-headlines")
    Call<QueryResponse> getArticles();
}


