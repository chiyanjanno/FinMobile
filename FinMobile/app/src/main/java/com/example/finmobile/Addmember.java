package com.example.finmobile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;




public class Addmember extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Button submit;
    EditText Full_name, current_home_address, email, password,phone_number,
            group_post,last_name,group_name2;

    //private static String API_URL = "http://192.168.1.4/register.php";
    private static String API_URL = "http://192.168.1.6/register.php";
    //String[] Grouptypename = {"Villagebank/Banki Nkhonde", "Usury/chipelegano"};
    final Calendar myCalendar = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addmember);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Full_name = (EditText) findViewById(R.id.Full_name);
        current_home_address = (EditText) findViewById(R.id.current_home_address);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        phone_number = (EditText)findViewById(R.id.phone_number);
        group_post = (EditText)findViewById(R.id.group_post);
        group_name2 = (EditText)findViewById(R.id.group_name2);

        submit=findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Add();
                startActivity(new Intent(Addmember.this, Login.class));

            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id== android.R.id.home){
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private void Add(){

        //btn5.setVisibility(View.GONE);

        final String group_name2 = this.group_name2.getText().toString().trim();
        final String Full_name = this.Full_name.getText().toString().trim();
        final String current_home_address = this.current_home_address.getText().toString().trim();
        final String email = this.email.getText().toString().trim();
        final String password = this.password.getText().toString().trim();
        final String phone_number = this.phone_number.getText().toString().trim();
        final String group_post =this.group_post.getText().toString().trim();
        //  final String GroupType = spin.getSelectedItem().toString().trim();

     /*   if (TextUtils.isEmpty(Full_name)) {
            Full_name.setError("Please enter Full name");
            Full_name.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(email)) {
            email.setError("Please enter your email");
            email.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            email.setError("Enter a valid email");
            email.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            password.setError("Enter a password");
            password.requestFocus();
            return;
        }
*/
        StringRequest stringRequest= new StringRequest(Request.Method.POST, API_URL ,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(Addmember.this,response,Toast.LENGTH_LONG).show();
                        // btn5.setVisibility(View.GONE);
                    }
                   /* try{
                        JSONObject jsonObject= new JSONObject(response);
                        String success =jsonObject.getString("");


                      //  if(success.equals("1")){
                        //    Toast.makeText(Register.this, "Registration done", Toast.LENGTH_LONG).show();
                       // }
                    } catch (Exception e) {
                        e.printStackTrace();
                        Toast.makeText(Register.this, "Registration error"+e.toString(), Toast.LENGTH_LONG).show();
                        btn5.setVisibility(View.GONE);
                    }
                    }*/

                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Addmember.this, "Registration error"+ error.toString(), Toast.LENGTH_LONG).show();
                        submit.setVisibility(View.VISIBLE);
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("group_name2", group_name2);
                params.put("email", email);
                params.put("phone_number", phone_number);
                params.put("Full_name", Full_name);
                params.put("password", password);
                params.put("current_home_address", current_home_address);
                params.put("group_post",group_post);
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
