package org.jbossoutreach.restandroid.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.jbossoutreach.restandroid.R;
import org.jbossoutreach.restandroid.backend.RestClient;
import org.jbossoutreach.restandroid.model.GitRepo;

import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;

public class MainActivity extends AppCompatActivity{

    private Button getTeacher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getTeacher = (Button) findViewById(R.id.get_teacher_by_id);

        ButterKnife.bind(this);

//        Example usage of RestClient
//        Call<Response> getRequest = new RestClient().getResponseService().getCall("the url", "Body if the request has one");
//        getRequest.enqueue(new Callback<Response>() {
//            @Override
//            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
//
//            }
//
//            @Override
//            public void onFailure(Call<Response> call, Throwable t) {
//
//            }
//        });
        getTeacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getTeacher(view);
            }
        });
    }



    public void getTeacher(View view){
        Call<GitRepo> repoCall = RestClient.getClient()
                .getRepoByTitle("GCI");

        repoCall.enqueue(new Callback<GitRepo>() {
            @Override
            public void onResponse(Call<GitRepo> call, retrofit2.Response<GitRepo> response) {
                GitRepo gitRepo = response.body();
                Log.d("Teacher Response",gitRepo.toString());
            }

            @Override
            public void onFailure(Call<GitRepo> call, Throwable t) {
                Log.d("Teacher Failure", "Failure " + t.getMessage());
            }
        });


    }

}
