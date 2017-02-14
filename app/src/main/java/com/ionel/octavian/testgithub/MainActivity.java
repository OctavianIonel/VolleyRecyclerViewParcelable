package com.ionel.octavian.testgithub;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import com.android.volley.Response;
import com.android.volley.VolleyError;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<MyModel> myData;
    private MyModel myModel;
    private RecyclerView mRecyclerView;
    private String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView)findViewById(R.id.recycler_view);

        APIManager.getInstance().initialize(getApplicationContext());

        myData = new ArrayList<>();
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        RVAdapter rvAdapter = new RVAdapter(this, myData);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(rvAdapter);

        APIManager.getInstance().getGithubRepositories(new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                if (response.length() > 0) {
                    JSONObject eachJsonObject;
                    try {
                        for (int i = 0; i < 20; i++) {
                            myModel = new MyModel();
                            eachJsonObject = response.getJSONObject(i);
                            String name = eachJsonObject.getString("name");
                            String repositoryName = eachJsonObject.getString("full_name");
                            JSONObject owner = (JSONObject) eachJsonObject.get("owner");
                            String photo = owner.getString("avatar_url");
                            url = eachJsonObject.getString("url");
                            String description = eachJsonObject.getString("description");
                            String shortDescription = truncateDescription(description);
                            myModel.setName(name);
                            myModel.setRepositoryName(repositoryName);
                            myModel.setDescription(shortDescription);
                            myModel.setPhoto(photo);
                            myModel.setUrl(url);
                            getUserStargazersForksWatchersOpenIssues(myModel);
                            myData.add(myModel);
                        }
                        mRecyclerView.getAdapter().notifyDataSetChanged();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("MainActivity", "Error connection");
            }
        });
    }


    public static String truncateDescription(String description) {
        StringBuilder result = new StringBuilder();
        String[] words = description.split("\\s+");
        for (int i = 0; i < words.length; i++) {
            if (i == 15) {
                break;
            }
            result.append(words[i] + " ");
        }
        return result.toString();
    }


    public void getUserStargazersForksWatchersOpenIssues(final MyModel myModel) {
        APIManager.getInstance().getMoreFromGithubUser(myModel.getUrl(), new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                if (response.length() > 0) {
                    try {
                        String stargazers = response.getString("stargazers_count");
                        String forks = response.getString("forks_count");
                        String watchers = response.getString("watchers");
                        String openIssues = response.getString("open_issues");
                        myModel.setStargazers(stargazers);
                        myModel.setForks(forks);
                        myModel.setWatchers(watchers);
                        myModel.setOpenIssues(openIssues);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("MainActivity::user", "Error connection");
            }
        });
    }

}
