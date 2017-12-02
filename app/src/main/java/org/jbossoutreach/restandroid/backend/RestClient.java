package org.jbossoutreach.restandroid.backend;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by murad on 11/11/17.
 */

public class RestClient {

    private static ResponseService mRestService = null;

    public static ResponseService getClient() {
        if(mRestService == null) {
            final OkHttpClient client = new OkHttpClient().newBuilder().addInterceptor(new FakeInterceptor()).build();

            Gson gson = new GsonBuilder().setLenient()
                    .create();

            final Retrofit retrofit = new Retrofit.Builder()
                    // Using custom Jackson Converter to parse JSON
                    // Add dependencies:
                    // com.squareup.retrofit:converter-jackson:2.0.0-beta2
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    // Endpoint
                    .baseUrl(ResponseService.ENDPOINT)
                    .client(client)
                    .build();

            mRestService = retrofit.create(ResponseService.class);
        }
        return mRestService;
    }

//    public ResponseService getResponseService() {
//        return mResponseService;
//    }
}
