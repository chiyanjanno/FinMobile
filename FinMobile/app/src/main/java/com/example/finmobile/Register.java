package com.example.finmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
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


public class Register extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Button btn5, btn6;
    EditText group_name, number_of_members, cycle_start_date, cycle_end_date, Full_name, current_home_address, email, password,phone_number,
            group_type;

    Spinner spin;

   // private static String API_URL = "http://192.168.1.6:81/api/auth/register";
   //private static String API_URL = "http://192.168.1.6/register.php";
    private static String API_URL = "http://192.168.43.125/register.php";
    String[] Grouptypename = {"Villagebank/Banki Nkhonde", "Usury/chipelegano"};
    final Calendar myCalendar = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        group_name = (EditText) findViewById(R.id.group_name);
        number_of_members = (EditText) findViewById(R.id.number_of_members);
        cycle_start_date = (EditText) findViewById(R.id.cycle_start_date);
        cycle_end_date = (EditText) findViewById(R.id.cycle_end_date);
        Full_name = (EditText) findViewById(R.id.Full_name);
        current_home_address = (EditText) findViewById(R.id.current_home_address);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        phone_number = (EditText)findViewById(R.id.phone_number);
        group_type = findViewById(R.id.group_type);



        btn5 = findViewById(R.id.button2);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(Register.this, Login.class));
                //calling method to register user below
                Reg();
          }
        });

        btn6 = findViewById(R.id.button3);
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Register.this, Login.class));
            }
        });

        //date picker for cycle start and end dates
        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }

        };


        cycle_start_date.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(Register.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });


        cycle_end_date.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(Register.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });



/*

//Getting the instance of Spinner and applying OnItemSelectedListener on it
        spin = (Spinner) findViewById(R.id.simpleSpinner);
        spin.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.type_array, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adapter);

*/
    }

    private void updateLabel(){
        String myFormat = "yyyy-MM-dd"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        cycle_start_date.setText(sdf.format(myCalendar.getTime()));
        cycle_end_date.setText(sdf.format(myCalendar.getTime()));
    }


//Making volley Requests
    private void Reg(){

       btn5.setVisibility(View.GONE);

        final String group_name = this.group_name.getText().toString().trim();
        final String number_of_members = this.number_of_members.getText().toString().trim();
        final String cycle_start_date= this.cycle_start_date.getText().toString().trim();
        final String cycle_end_date = this. cycle_end_date.getText().toString().trim();
        final String Full_name = this.Full_name.getText().toString().trim();
        final String current_home_address = this.current_home_address.getText().toString().trim();
        final String email = this.email.getText().toString().trim();
        final String password = this.password.getText().toString().trim();
        final String phone_number = this.phone_number.getText().toString().trim();
        final String group_type =this.group_type.getText().toString().trim();
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
                        Toast.makeText(Register.this,response,Toast.LENGTH_LONG).show();
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
                        Toast.makeText(Register.this, "Registration error"+ error.toString(), Toast.LENGTH_LONG).show();
                        btn5.setVisibility(View.VISIBLE);
                    }
                }) {
              @Override
               protected Map<String, String> getParams() throws AuthFailureError {
                   Map<String, String> params = new HashMap<>();
                   params.put("group_name", group_name);
                  // params.put("spin", GroupType);
                   params.put("number_of_members",number_of_members);
                   params.put("cycle_start_date",cycle_start_date);
                   params.put("cycle_end_date", cycle_end_date);
                   params.put("email", email);
                   params.put("phone_number", phone_number);
                   params.put("Full_name", Full_name);
                   params.put("password", password);
                   params.put("current_home_address", current_home_address);
                   params.put("group_type",group_type);
                   return params;
               }
           };
         /*

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("Groupname", groupname.getText().toString());
                // params.put("spin", GroupType);
                params.put("number_of_members", members.getText().toString());
                params.put("cycle_start_date",cyclestart.getText().toString());
                params.put("cycle_end_date",cycleend.getText().toString());
                params.put("Full_name",fullname.getText().toString());
                params.put(" current_home_address", address.getText().toString());
                params.put("Email", email.getText().toString());
                params.put("Password",password.getText().toString());
                params.put("Phone", phone.getText().toString());
                params.put("type",gtype.getText().toString());
                return params;

            }
        };

             */
            RequestQueue requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(stringRequest);

    }
//Performing action onItemSelected and onNothing selected

    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
        Toast.makeText(getApplicationContext(), Grouptypename[position], Toast.LENGTH_LONG).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
// TODO Auto-generated method stub

    }
}