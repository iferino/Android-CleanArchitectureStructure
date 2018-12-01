package com.iferino.data.network;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    protected static final int DEFAULT_API_TIMEOUT = 30;

    private Retrofit.Builder retrofitBuilder;
    private Retrofit retrofit;
    private OkHttpClient.Builder httpClient;


    public ApiClient() {
        buildRetrofit();
    }

    private void buildtHttpClient() {
        httpClient = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request().newBuilder()
                                .header("Content-Type", "application/json")
                                .build();

                        return chain.proceed(request);
                    }
                });

        httpClient.readTimeout(DEFAULT_API_TIMEOUT, TimeUnit.SECONDS)
                .connectTimeout(DEFAULT_API_TIMEOUT, TimeUnit.SECONDS);

    }

    private void buildRetrofitBuilder(String url) {
        retrofitBuilder = new Retrofit.Builder()
                .baseUrl(url)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build());
    }

    private void buildRetrofit() {
        buildtHttpClient();
        buildRetrofitBuilder(Const.BASE_URL);
        retrofit = retrofitBuilder.build();
    }

    public <S> S createService(
            Class<S> serviceClass) {
        return retrofit.create(serviceClass);
    }

}
