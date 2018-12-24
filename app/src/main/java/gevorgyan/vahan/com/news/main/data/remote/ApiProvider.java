package gevorgyan.vahan.com.news.main.data.remote;

import com.facebook.stetho.okhttp3.StethoInterceptor;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiProvider {

    public static Retrofit getClient() {

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        Interceptor newsInterceptor = new NewsInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
        //Adding request interceptors
        OkHttpClient client = new OkHttpClient.Builder().addNetworkInterceptor(new StethoInterceptor()).
                addInterceptor(loggingInterceptor).addInterceptor(newsInterceptor).build();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://newsapi.org/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .callFactory(client)
                .client(client)
                .build();
        return retrofit;
    }
}
