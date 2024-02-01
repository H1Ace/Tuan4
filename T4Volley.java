package com.example.myapplication.Tuan4;

import android.content.Context;
import android.view.PixelCopy;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class T4Volley {
    String strJSON="";
    public void getJsonArrayOfObjec(Context context, TextView textview)
    {
        RequestQueue queue= Volley.newRequestQueue(context);
        String url="https://api.jikan.moe/v4/anime?q=one%20piece&sfw";
        JsonArrayRequest request=new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        for (int i=0;i<response.length();i++){
                            try {
                                JSONObject person = response.getJSONObject(i);
                                String trailer = person.getString("trailer");
                                String data = person.getString("data");
                                String webp = person.getString("webp");

                                strJSON+="A40239 "+trailer+"\n";
                                strJSON+="data: "+data+"\n";
                                strJSON+="webp: "+webp+"\n";
                            } catch (JSONException e) {
                                throw new RuntimeException(e);
                            }
                            textview.setText(strJSON);
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                textview.setText(error.getMessage());
            }
        });
        queue.add(request);
    }

}
