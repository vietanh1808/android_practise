package com.example.volleypractise;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonArrayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_array);

        String url = "http://192.168.1.5:3000/";
        RequestQueue requestQueue = Volley.newRequestQueue(JsonArrayActivity.this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        for (int i=0; i<response.length(); i++) {
                            try {
                                JSONObject jsonObject = response.getJSONObject(i);
                                Toast.makeText(JsonArrayActivity.this, ""+jsonObject.getInt("id"), Toast.LENGTH_SHORT).show();
                                Toast.makeText(JsonArrayActivity.this, ""+jsonObject.getString("hoten"), Toast.LENGTH_SHORT).show();
                                Toast.makeText(JsonArrayActivity.this, ""+jsonObject.getString("ngaysinh"), Toast.LENGTH_SHORT).show();
                                Toast.makeText(JsonArrayActivity.this, ""+jsonObject.getString("diachi"), Toast.LENGTH_SHORT).show();
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
        requestQueue.add(jsonArrayRequest);
    }
}