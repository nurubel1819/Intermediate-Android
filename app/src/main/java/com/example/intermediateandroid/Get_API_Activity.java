package com.example.intermediateandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Get_API_Activity extends AppCompatActivity {

    ArrayList<String> arrayList_name = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_api);

        ListView listView = findViewById(R.id.list_view);

        //coder for json file
        String link = "https://jsonplaceholder.typicode.com/users";


        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, link, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                //
                try {

                    for(int i=0;i<response.length();i++)
                    {
                        JSONObject object = response.getJSONObject(i);
                        String name = object.getString("name");
                        String id = object.getString("id");
                        arrayList_name.add("ID = "+id+", name = "+name);
                    }
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(Get_API_Activity.this,
                            android.R.layout.simple_list_item_1,arrayList_name);
                    listView.setAdapter(adapter);
                } catch (JSONException e) {
                    Toast.makeText(Get_API_Activity.this,"NO internet connection",Toast.LENGTH_SHORT);
                    throw new RuntimeException(e);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //
            }
        });
        Volley.newRequestQueue(Get_API_Activity.this).add(request);

    }
}