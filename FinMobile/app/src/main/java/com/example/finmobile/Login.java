package com.example.finmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Base64;
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

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Login extends AppCompatActivity {
    Button btn2, btn3, btn4;
    private EditText email, password2;
    //private static String login_url = "http://192.168.1.6/login.php";
    private static String login_url = "http://192.168.43.125/login.php";
   // private static String login_url = "http://192.168.1.6:81/api/auth/login";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email= (EditText) findViewById(R.id.email);
        password2=(EditText) findViewById(R.id.password2);

        btn2 = findViewById(R.id.register);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this, Register.class));
            }
        });
        btn3 = findViewById(R.id.forgot);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this, Forgot.class));
            }

        });

        btn4 = findViewById(R.id.login);

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = email.getText().toString().trim();
                String pass = password2.getText().toString().trim();

                if (!user.isEmpty()|| !pass.isEmpty()){
                    Log(user,pass);
                  //  startActivity(new Intent(Login.this, Dashboard.class));



                }
                else{
                    email.setError("please insert username");
                    password2.setError("please insert passowrd");
                }

                // startActivity(new Intent(Login.this, Dashboard.class));

            }
        });


    }

    private void Log(final String email, final String password2) {




        StringRequest stringRequest = new StringRequest(Request.Method.POST, login_url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject object=new JSONObject(response);
                            if (!object.getBoolean("success")){
                                final String Full_name=object.getString("Full_name");
                                final String email=object.getString("email");
                                Intent intent=new Intent(Login.this,Dashboard.class);
                                intent.putExtra("Full_name",Full_name);
                                intent.putExtra("email",email);
                                Toast.makeText(getApplicationContext(),"Login SuccessFull", Toast.LENGTH_LONG).show();
                                startActivity(intent);
                            }else {
                                Toast.makeText(getApplicationContext(),"User Login UnSuccessesFull", Toast.LENGTH_LONG).show();
                            }
                        } catch (JSONException e) {
                            

                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            protected Map<String, String> getParams()  {
                Map<String,String>params=new HashMap<String, String>();
                params.put("email",email);
                params.put("password",password2);
                return params;
            }
        };
        RequestQueue requestQueue= Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(stringRequest);
    }
}