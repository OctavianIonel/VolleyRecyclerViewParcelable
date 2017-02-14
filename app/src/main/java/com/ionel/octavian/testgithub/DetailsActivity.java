package com.ionel.octavian.testgithub;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by octavian on 1/29/17.
 */

public class DetailsActivity extends AppCompatActivity {

    private ImageView photoIv;
    private TextView nameTv;
    private TextView repositoryNameTv;
    private TextView shortDescriptionTv;
    private TextView stargazersTv;
    private TextView forksTv;
    private TextView watchersTv;
    private TextView openIssuesTv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.element);

        photoIv = (ImageView)findViewById(R.id.photo);
        nameTv = (TextView)findViewById(R.id.name);
        repositoryNameTv = (TextView)findViewById(R.id.repository_name);
        shortDescriptionTv = (TextView)findViewById(R.id.short_description);
        stargazersTv = (TextView)findViewById(R.id.stargazersTv);
        forksTv = (TextView)findViewById(R.id.forksTv);
        watchersTv = (TextView)findViewById(R.id.watchersTv);
        openIssuesTv = (TextView)findViewById(R.id.openIssuesTv);

        stargazersTv.setVisibility(View.VISIBLE);
        forksTv.setVisibility(View.VISIBLE);
        watchersTv.setVisibility(View.VISIBLE);
        openIssuesTv.setVisibility(View.VISIBLE);


        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        MyModel myModel = (MyModel)bundle.getParcelable(Utils.MY_MODEL);

        String photo = myModel.getPhoto();
        String name = myModel.getName();
        String repositoryName = myModel.getRepositoryName();
        String description = myModel.getDescription();
        String url = myModel.getUrl();
        String stargazers = myModel.getStargazers();
        String forks = myModel.getForks();
        String watchers = myModel.getWatchers();
        String openIssues = myModel.getOpenIssues();



        Utils.setImage(this, photoIv, photo);

        nameTv.setText("Name: " + name);
        repositoryNameTv.setText("Repository: " + repositoryName);
        shortDescriptionTv.setText("Short description (max 15 words): " + description);

        stargazersTv.setText("The nr of stargers is: " + stargazers);
        forksTv.setText("The nr of forks is: " + forks);
        watchersTv.setText("The nr of watchers is: " + watchers);
        openIssuesTv.setText("The nr of open issues is: " + openIssues);




    }
}
