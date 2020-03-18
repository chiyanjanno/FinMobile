package com.example.finmobile.other;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.finmobile.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Welfare extends Fragment {
    EditText datepaid;
    View view;
    private List<Wel> welfare;
    private RecyclerView rv3;
    private WelfareAdapter adapter2;
    final Calendar myCalendar = Calendar.getInstance();

    private static String wel_url = "http://192.168.1.6/Getwelfare.php";
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        view =  inflater.inflate(R.layout.fragment_welfare, container, false);
        rv3 = (RecyclerView) view.findViewById(R.id.recyclerview3);
        rv3.setHasFixedSize(true);
        rv3.setLayoutManager(new LinearLayoutManager(getActivity()));

        welfare= new ArrayList<>();




        Loadwelfarecontributions();
        return view;
    }

    public void Loadwelfarecontributions(){
        StringRequest stringRequest = new StringRequest(Request.Method.GET, wel_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray array = new JSONArray(response);

                    //traversing through all the object
                    for (int i = 0; i < array.length(); i++) {

                        //getting product object from json array
                        JSONObject memberObject = array.getJSONObject(i);

                        //adding the data to cont
                        String welfare_contribution = memberObject.getString("welfare_contribution");
                        String welfare_month= memberObject.getString("welfare_month");
                        String welfare_mode= memberObject.getString("welfare_mode");
                        String welfare_date= memberObject.getString("welfare_date");

                        Wel member = new Wel(welfare_contribution, welfare_month, welfare_mode, welfare_date);
                        welfare.add(member);




                    }


                       /* //adding the data to cont
                        String Monthly_contribution = memberObject.getString("Monthly_contribution");
                        String Month= memberObject.getString("Month");
                        String Paid_through= memberObject.getString("Paid_through");
                        String date_of_payment= memberObject.getString("date_of_payment");

                        Cont member = new Cont(Monthly_contribution, Month, Paid_through, date_of_payment);
                        cont.add(member);

                        */

                    adapter2 = new WelfareAdapter(welfare, getContext());
                    rv3.setAdapter(adapter2);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }

        });
        RequestQueue queue = Volley.newRequestQueue(getActivity().getApplicationContext());
        queue.add(stringRequest);
    }
}
