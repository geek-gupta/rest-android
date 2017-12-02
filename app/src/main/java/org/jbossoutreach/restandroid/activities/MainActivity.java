package org.jbossoutreach.restandroid.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.jbossoutreach.restandroid.R;
import org.jbossoutreach.restandroid.backend.RestClient;
import org.jbossoutreach.restandroid.model.GitRepo;

import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;

public class MainActivity extends AppCompatActivity{

    private Button getRepo;
    private TextView titleTextView,prTextView,issueTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getRepo = (Button) findViewById(R.id.get_repo_by_title);
        titleTextView = (TextView) findViewById(R.id.repo_title);
        issueTextView = (TextView) findViewById(R.id.issue_count);
        prTextView = (TextView) findViewById(R.id.pr_count);

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
    }


   @OnClick(R.id.get_repo_by_title)
    public void getGitRepo(View view){
        Call<GitRepo> repoCall = RestClient.getClient()
                .getRepoByTitle("GCI");

        repoCall.enqueue(new Callback<GitRepo>() {
            @Override
            public void onResponse(Call<GitRepo> call, retrofit2.Response<GitRepo> response) {
                GitRepo gitRepo = response.body();
                titleTextView.setText("Title : "+gitRepo.getRepoTitle());
                issueTextView.setText("Issue Count : "+gitRepo.getIssueCount());
                prTextView.setText("PR Count : "+gitRepo.getPrCount());
                Log.d("GitRepo Response",gitRepo.toString());
            }

            @Override
            public void onFailure(Call<GitRepo> call, Throwable t) {
                Log.d("GitRepo Failure", "Failure " + t.getMessage());
            }
        });


    }

}
