package com.jigar.practicaldemo.network.retrofit;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class AuthenticationInterceptor implements Interceptor {

    private String authToken;

    AuthenticationInterceptor(String authToken) {
        this.authToken = authToken;
    }

    @NotNull
    @Override
    public Response intercept(@NotNull Interceptor.Chain chain) throws IOException {

        Request original = chain.request();

        Request.Builder builder = original.newBuilder().header("Authorization", authToken);

        Request request = builder.build();

        return chain.proceed(request);
    }

}
