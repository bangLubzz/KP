package com.example.banglubzzz.salesmonitor.network;







import com.example.banglubzzz.salesmonitor.constant.PrefCons;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestClient {
    private ApiService apiService;
    private static RestClient instance = null;

    public static RestClient getInstance() {
        if (instance == null)
            instance = new RestClient();

        return instance;
    }


    private RestClient() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        final OkHttpClient httpClient = new OkHttpClient.Builder()
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
                .build();
//        OkHttpClient.Builder httpClient = new OkHttpClient.Builder()
//                .readTimeout(60, TimeUnit.SECONDS)
//                .connectTimeout(60, TimeUnit.SECONDS)
//                .build();
        httpClient.newBuilder().addInterceptor(logging);  // <-- this is the important line!

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(PrefCons.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.newBuilder().build())
                .build();

        apiService = retrofit.create(ApiService.class);
    }

    public ApiService getApiService() {
        return apiService;
    }
}
