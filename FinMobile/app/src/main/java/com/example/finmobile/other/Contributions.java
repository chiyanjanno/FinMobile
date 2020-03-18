package com.example.finmobile.other;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
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
import com.example.finmobile.Register;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class Contributions extends Fragment {
    EditText datepaid;
    View view;
    private List<Cont> cont;
    private RecyclerView rv2;
    private ContAdapter adapter1;
    final Calendar myCalendar = Calendar.getInstance();

    private static String cont_url = "http://192.168.1.6/Getcontributions.php";
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        view =  inflater.inflate(R.layout.fragment_contributions, container, false);
        rv2 = (RecyclerView) view.findViewById(R.id.recyclerview2);
        rv2.setHasFixedSize(true);
        rv2.setLayoutManager(new LinearLayoutManager(getActivity()));

        cont= new ArrayList<>();




        Loadcontributions();
        return view;
    }

    public void Loadcontributions(){
        StringRequest stringRequest = new StringRequest(Request.Method.GET, cont_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray array = new JSONArray(response);

                    //traversing through all the object
                    for (int i = 0; i < array.length(); i++) {

                        //getting product object from json array
                        JSONObject memberObject = array.getJSONObject(i);

                        //adding the data to cont
                        String Monthly_contribution = memberObject.getString("Monthly_contribution");
                        String Month= memberObject.getString("Month");
                        String Paid_through= memberObject.getString("Paid_through");
                        String date_of_payment= memberObject.getString("date_of_payment");

                        Cont member = new Cont(Monthly_contribution, Month, Paid_through, date_of_payment);
                        cont.add(member);


                    }


                       /* //adding the data to cont
                        String Monthly_contribution = memberObject.getString("Monthly_contribution");
                        String Month= memberObject.getString("Month");
                        String Paid_through= memberObject.getString("Paid_through");
                        String date_of_payment= memberObject.getString("date_of_payment");

                        Cont member = new Cont(Monthly_contribution, Month, Paid_through, date_of_payment);
                        cont.add(member);

                        */

                    adapter1 = new ContAdapter(cont, getContext());
                    rv2.setAdapter(adapter1);

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

