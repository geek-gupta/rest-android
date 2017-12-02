package org.jbossoutreach.restandroid.backend;

import android.net.Uri;
import android.util.Log;

import org.jbossoutreach.restandroid.BuildConfig;

import java.io.IOException;
import java.net.URI;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * Created by gaurav on 2/12/17.
 */

public class FakeInterceptor implements Interceptor {
    private final static String TAG = FakeInterceptor.class.getSimpleName();

    // FAKE RESPONSES.
    private final static String TEACHER_ID_1 = "{\"repoTitle\":\"GCI\",\"issueCount\":29,\"prCount\":12}";
    private final static String TEACHER_ID_2 = "{\"repoTitle\":\"rest-android\",\"issueCount\":10,\"prCount\":4}";

    @Override
    public Response intercept(Chain chain) throws IOException {
        Response response = null;


        Log.d(TAG, "----                FAKE SERVER RESPONSES                ----");
        String responseString;
        // Get Request URI.
        final URI uri = chain.request().url().uri();
        // Get Query String.
        final String query = uri.getQuery();
        // Parse the Query String.
        final String[] parsedQuery = query.split("=");
        if (parsedQuery[0].equalsIgnoreCase("repoTitle") && parsedQuery[1].equalsIgnoreCase("GCI")) {
            responseString = TEACHER_ID_1;
        } else if (parsedQuery[0].equalsIgnoreCase("repoTitle") && parsedQuery[1].equalsIgnoreCase("rest-android")) {
            responseString = TEACHER_ID_2;
        } else {
            responseString = "";
        }

        response = new Response.Builder()
                .code(200)
                .message(responseString)
                .request(chain.request())
                .protocol(Protocol.HTTP_1_0)
                .body(ResponseBody.create(MediaType.parse("application/json"), responseString.getBytes()))
                .addHeader("content-type", "application/json")
                .build();



        return response;
    }
}