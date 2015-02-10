package com.codefaction.suggestme11;

/**
 * Created by Sebastian on 01/02/2015.
 */

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.message.BasicLineFormatter;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Intent;
import android.os.StrictMode;
import android.provider.ContactsContract;
import android.util.Log;
import android.widget.Toast;

import org.apache.http.NameValuePair;

class Connector {

    public static String connect(String URL, List<NameValuePair> params)
    {
        try
        {
            String result = makeHttpRequest(URL,params);
            return result;
        } catch (Exception e)
        {
            return Tags.TAG_FAILURE;
        }
    }
    private static String makeHttpRequest(String URL, List<NameValuePair> params)
    {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            try
            {
                HttpClient httpClient = HttpClientBuilder.create().build();
                HttpPost httpPost = new HttpPost(URL);
                httpPost.setEntity(new UrlEncodedFormEntity(params));
                // Execute the POST request and store the response locally.
                HttpResponse httpResponse = httpClient.execute(httpPost);
                // Extract data from the response.

                String response = EntityUtils.toString(httpResponse.getEntity());
                return response;
            }
            catch(Exception e)
            {
                return Tags.TAG_FAILURE;
            }
    }
}