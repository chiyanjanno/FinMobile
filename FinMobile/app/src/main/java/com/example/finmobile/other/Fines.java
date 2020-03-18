package com.example.finmobile.other;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

public class Fines extends Fragment {
    View view;
    private List<Fin> fines;
    private RecyclerView rv4;
    private FineAdapter adapter3;
    final Calendar myCalendar = Calendar.getInstance();

    private static String fin_url = "http://192.168.1.6/Getfines.php";
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        view =  inflater.inflate(R.layout.fragment_fines, container, false);
        rv4 = (RecyclerView) view.findViewById(R.id.recyclerview4);
        rv4.setHasFixedSize(true);
        rv4.setLayoutManager(new LinearLayoutManager(getActivity()));

        fines= new ArrayList<>();




        Loadfines();
        return view;
    }

    public void Loadfines(){
        StringRequest stringRequest = new StringRequest(Request.Method.GET, fin_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray array = new JSONArray(response);

                    //traversing through all the object
                    for (int i = 0; i < array.length(); i++) {

                        //getting product object from json array
                        JSONObject memberObject = array.getJSONObject(i);

                        //adding the data to cont
                        String fine_amount = memberObject.getString("fine_amount");
                        String fine_month= memberObject.getString("fine_month");
                        String fine_date= memberObject.getString("fine_date");
                        String fine_description= memberObject.getString("fine_description");
                        String fine_mode= memberObject.getString("fine_mode");

                        Fin member = new Fin(fine_amount, fine_month, fine_date,fine_description, fine_mode);
                        fines.add(member);




                    }


                       /* //adding the data to cont
                        String Monthly_contribution = memberObject.getString("Monthly_contribution");
                        String Month= memberObject.getString("Month");
                        String Paid_through= memberObject.getString("Paid_through");
                        String date_of_payment= memberObject.getString("date_of_payment");

                        Cont member = new Cont(Monthly_contribution, Month, Paid_through, date_of_payment);
                        cont.add(member);

                        */

                    adapter3 = new FineAdapter(fines, getContext());
                    rv4.setAdapter(adapter3);

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
