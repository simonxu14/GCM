package com.http.simon.yiihttpapp;

import android.content.Context;
import android.util.Log;

/**
 * Created by Simon on 6/2/16.
 */
public class HttpPostRetreiver {

    public static String retriver(String Url, String input, Context context) {
        Log.d("TESTING", "URL->>" + Url);
        String responseString = null;
        StringEntity stringEntity;
        HttpPost postRequest = new HttpPost(Url);
        try {

            Log.e("string is", input + "\n" + Url);
            stringEntity = new StringEntity(input, "UTF-8");
            stringEntity.setContentType("application/atom+xml");

            postRequest.setEntity(stringEntity);
            //postRequest.a
            Log.v("Post", "Posted");

            HttpClient httpclient = new DefaultHttpClient();
            HttpResponse response = httpclient.execute(postRequest);
            HttpEntity getResponseEntity = response.getEntity();

            responseString = EntityUtils.toString(getResponseEntity);

        } catch (Exception e) {
            postRequest.abort();
            Log.w("HttpPostRetreiver", "Error for URL " + Url, e);
        }

        return responseString;

    }

}
