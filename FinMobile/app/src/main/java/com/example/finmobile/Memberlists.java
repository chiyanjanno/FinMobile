package com.example.finmobile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.finmobile.other.List_Data;
import com.example.finmobile.other.List_DataAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Memberlists extends AppCompatActivity {
    Button delete,update;

   private static String member_url = "http://192.168.1.6/getMemberlists.php";
  //  private static String member_url = "http://192.168.43.125/getMemberlists.php";
    List<List_Data> list_data;
    RecyclerView rv;
    List_DataAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memberlists);

        setTitle("group member list");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        rv=(RecyclerView)findViewById(R.id.recyclerview);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));
        list_data=new ArrayList<>();
      //  adapter=new MemberAdapter(Memberlists.this, list_data);

        getMemberData();


    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id== android.R.id.home){
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private void getMemberData() {

        StringRequest stringRequest=new StringRequest(Request.Method.GET, member_url , new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONArray members = new JSONArray(response);

                    for(int i=0; i<members.length(); i++){
                        JSONObject memberObject=members.getJSONObject(i);

                        String Full_name = memberObject.getString("Full_name");

                        List_Data member = new List_Data(Full_name) ;

                        list_data.add(member);

                        }
                     adapter = new List_DataAdapter(Memberlists.this, list_data);
                    rv.setAdapter(adapter);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
              /* try {
                    JSONObject jsonObject=new JSONObject(response);
                    JSONArray array=jsonObject.getJSONArray("emparray");

                    for (int i=0; i<array.length(); i++ ){
                        JSONObject listdata=array.getJSONObject(i);
                       // list_data list_Data=new List_Data(listdata.getString("Full_name"));
                      //  list_data.add(List_Data);
                        list_data.add(new List_Data(
                                listdata.getString("Full_name")
                        ));
                    }

                    MemberAdapter adapter = new MemberAdapter(Memberlists.this, list_data);
                    rv.setAdapter(adapter);

                } catch (JSONException e) {
                    e.printStackTrace();
                }*/

            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Memberlists.this, error.getMessage()+ error.toString(), Toast.LENGTH_LONG).show();


            }

        });

        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}