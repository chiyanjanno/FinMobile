package com.example.finmobile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class LoanRequest extends AppCompatActivity {
    Button button5;
    EditText Amount,Loan_period;
   private static String API_URL = "http://192.168.1.6/apply.php";
  //  private static String API_URL = "http://192.168.1.4/apply.php";
   // private static String API_URL = "http://192.168.1.3/apply.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan_request);
        Amount=(EditText)findViewById(R.id.Amount);
        Loan_period=(EditText)findViewById(R.id.Loan_period);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        button5=findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Loanrequest();

            }
        });

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    private void Loanrequest(){

        final String Amount = this.Amount.getText().toString().trim();
        final String Loan_period = this.Loan_period.getText().toString().trim();

        StringRequest stringRequest= new StringRequest(Request.Method.POST, API_URL,
                new Response.Listener<String>() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(LoanRequest.this,response,Toast.LENGTH_LONG).show();
                        button5.setText("Pending");
                    }


                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(LoanRequest.this, "loan application error"+ error.toString(), Toast.LENGTH_LONG).show();
                        button5.setVisibility(View.VISIBLE);
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("Amount", Amount);
             //   params.put("email", email);
                params.put("Loan_period",Loan_period);
                return params;
            }
        };


        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }

}
