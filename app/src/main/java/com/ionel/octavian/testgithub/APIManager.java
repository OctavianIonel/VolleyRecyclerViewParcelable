package com.ionel.octavian.testgithub;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by octavian on 1/29/17.
 */

public class APIManager {

    private static APIManager mInstance;
    private Context mContext;
    private RequestQueue mRequestQueue;


    private APIManager() {
    }

    public synchronized  static APIManager getInstance() {
        if (mInstance == null) {
            mInstance = new APIManager();
        }
        return mInstance;
    }

    public void initialize(Context context) {
        deinitialize();
        mContext = context.getApplicationContext();
        mRequestQueue = Volley.newRequestQueue(mContext);
        mRequestQueue.start();
    }

    public void deinitialize() {
        if (mRequestQueue != null) {
            mRequestQueue.stop();
            mRequestQueue = null;
        }
    }

    private Context getContext() {
        return mContext;
    }

    private void sendRequest(Request request) {
        request.setRetryPolicy(new DefaultRetryPolicy(10000, 1, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        mRequestQueue.add(request);
    }


    /**according to the documentation, the user agent is required: https://developer.github.com/v3/
     "All API requests MUST include a valid User-Agent header. Requests with no User-Agent header will be rejected.
     We request that you use your GitHub username, or the name of your application, for the User-Agent header value.
     This allows us to contact you if there are problems."
     //example: GET https://api.github.com/repositories
    */
     public void getGithubRepositories(Response.Listener<JSONArray> successListener, Response.ErrorListener errorListener) {

        JsonArrayRequest request = new JsonArrayRequest(Utils.URL, successListener, errorListener) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> headers = new HashMap<>();
                headers.put("user-agent", "testgithub");
                return headers;
            }
        };
        sendRequest(request);
    }

    //example: GET https://api.github.com/repos/mojombo/grit
    public void getMoreFromGithubUser(final String url, Response.Listener<JSONObject> successListener, Response.ErrorListener errorListener) {

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, successListener, errorListener) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> headers = new HashMap<>();
                headers.put("user-agent", "testgithub");
                return headers;
            }
        };
        sendRequest(request);
    }


}
