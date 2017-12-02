package org.jbossoutreach.restandroid.backend;

import org.jbossoutreach.restandroid.model.GitRepo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by murad on 11/11/17.
 */

public interface ResponseService {

    String ENDPOINT = "http://www.student.com/";

    @GET("/")
    Call<GitRepo> getRepoByTitle(@Query("repoTitle") final String repoTitle);
//
//    @DELETE
//    Call<Response> deleteCall(@Url String url,
//                              @Nullable @Body RequestBody requestBody);
//
//    @POST
//    Call<Response> postCall(@Url String url,
//                            @Nullable @Body RequestBody requestBody);
//
//    @PUT
//    Call<Response> putCall(@Url String url,
//                           @Nullable @Body RequestBody requestBody);
}
