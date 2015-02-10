package com.codefaction.suggestme11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Locale;

import org.apache.http.Header;
import org.apache.http.HeaderIterator;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.ProtocolVersion;
import org.apache.http.StatusLine;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.ProgressDialog;
import android.os.StrictMode;
import android.util.Log;

public class JSONParser {

    private InputStream is;
    private JSONObject jObj;
    private String json;
    private ProgressDialog progressDialog;

    // constructor
    public JSONParser(ProgressDialog pDialog) {
        this.progressDialog = pDialog;
    }


    public JSONObject getJSONFromUrl(final String url) {

        // Making HTTP request
        try {
            // Construct the client and the HTTP request.
            HttpClient httpClient = HttpClientBuilder.create().build();
            HttpPost httpPost = new HttpPost(url);

            // Execute the POST request and store the response locally.
            HttpResponse httpResponse = httpClient.execute(httpPost);
            // Extract data from the response.

            String response = EntityUtils.toString(httpResponse.getEntity());
            Log.v("Login response", response);
            HttpEntity httpEntity = httpResponse.getEntity();
            // Open an inputStream with the data content.
            is = httpEntity.getContent();

        } catch (UnsupportedEncodingException e) {
            progressDialog.setMessage("ERROR");
        } catch (ClientProtocolException e) {
            progressDialog.setMessage("ERROR");
        } catch (IOException e) {
            progressDialog.setMessage("ERROR");
        }


        try {
            // Create a BufferedReader to parse through the inputStream.
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    is, "iso-8859-1"), 8);
            // Declare a string builder to help with the parsing.
            StringBuilder sb = new StringBuilder();
            // Declare a string to store the JSON object data in string form.
            String line = null;

            // Build the string until null.
            while ((line = reader.readLine()) != null)
            {
                sb.append(line + "\n");
            }
            // Close the input stream.
            reader.close();
            is.close();
            // Convert the string builder data to an actual string.
            json = sb.toString();
        }
        catch (Exception e)
        {
            progressDialog.setMessage("ERROR");
        }

        // Try to parse the string to a JSON object
        try {
            jObj = new JSONObject(json);
        } catch (Exception e) {
            progressDialog.setMessage("ERROR");
            jObj = new JSONObject();
        }

        // Return the JSON Object.
        return jObj;

    }
    // function get json from url
    // by making HTTP POST or GET mehtod
    public String makeHttpRequest(String url, String method,
                                      List<NameValuePair> params)
    {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        // Making HTTP request
        try {

            // check for request method
            if(method.equals("POST")){
                // request method is POST
                // defaultHttpClient

                String response = "";
                HttpClient httpClient = HttpClientBuilder.create().build();
                Log.w("HHHClient", response);
                HttpPost httpPost = new HttpPost(url);
                Log.w("HHHPost", response);
                httpPost.setEntity(new UrlEncodedFormEntity(params));
                Log.w("HHHParams", response);
                HttpResponse httpResponse= httpClient.execute(httpPost);
                Log.w("HHHExecute", response);
                HttpEntity httpEntity = httpResponse.getEntity();
                response = EntityUtils.toString(httpEntity);

                Log.w("HHHResponse", response);
                Log.w("HHHLogin response", response);
                /*JSONObject jObj = new JSONObject(response);
                int p = jObj.getInt("success");
                Log.v("HHH" + String.valueOf(p),response); */
                return response;





            }else if(method.equals("GET")){
                // request method is GET
                DefaultHttpClient httpClient = new DefaultHttpClient();
                String paramString = URLEncodedUtils.format(params, "utf-8");
                url += "?" + paramString;
                HttpGet httpGet = new HttpGet(url);

                HttpResponse httpResponse = httpClient.execute(httpGet);
                HttpEntity httpEntity = httpResponse.getEntity();
                is = httpEntity.getContent();
            }

        } catch (Exception e)
        {
            e.printStackTrace();
            Log.v("HHHExcetion","Yep...");
        }
        // try parse the string to a JSON object

        // return JSON String
        return "";
    }
}