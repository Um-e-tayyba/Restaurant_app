package com.example.restaurantapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class delivery extends AppCompatActivity {
    //TextView txtfname1, txtlname1, txtemail1;
    EditText txtfname1, txtlname1, txtemail1, etadd, etphone;

    Button nextbtn;
    Spinner spinner2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery);
        spinner2=(Spinner)findViewById(R.id.city);
        nextbtn=(Button)findViewById(R.id.btnnext);
        txtfname1=(EditText) findViewById(R.id.fname1);
        txtlname1=(EditText) findViewById(R.id.lname1);
        txtemail1=(EditText) findViewById(R.id.email1);
        etadd=(EditText) findViewById(R.id.address1);
        etphone=(EditText) findViewById(R.id.phone1);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.cities, R.layout.support_simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter);

        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //    txtfname1.setText("amina maroof");



                if ((txtfname1.length()<=0) && (txtlname1.length()<=0) &&(etphone.length()<=0) && (etadd.length()<=0) && (txtemail1.length()<=0) )
                {
                    Toast.makeText(getApplicationContext(), " Fields should not be empty", Toast.LENGTH_LONG).show();
                    return;
                }
                else if((txtfname1.length()<=0))
                {
                    Toast.makeText(getApplicationContext(), " You must enter your First Name", Toast.LENGTH_LONG).show();
                    return;
                }
                else if((txtlname1.length()<=0))
                {
                    Toast.makeText(getApplicationContext(), " You must enter your Last Name", Toast.LENGTH_LONG).show();
                    return;
                }
                else if((etadd.length()<=0))
                {
                    Toast.makeText(getApplicationContext(), " You must enter your Address", Toast.LENGTH_LONG).show();
                    return;
                }

                else if((etphone.length()<=0))
                {
                    Toast.makeText(getApplicationContext(), " You must enter phone number", Toast.LENGTH_LONG).show();
                    return;
                }
                else if((txtemail1.length()<=0))
                {
                    Toast.makeText(getApplicationContext(), " You must enter your email address", Toast.LENGTH_LONG).show();
                    return;
                }




                Intent intent=new Intent(delivery.this, finishorder2.class); //new
                String phoneno=etphone.getText().toString();
                String firstname=txtfname1.getText().toString();
                String lastname=txtlname1.getText().toString();
                String address1=etadd.getText().toString();
                String email=txtemail1.getText().toString();

                intent.putExtra("phone1",phoneno);
                intent.putExtra("firstname1", firstname);
                intent.putExtra("lastname1", lastname);
                intent.putExtra("address1", address1);
                intent.putExtra("Email1", email);
                startActivity(intent);
            }
        });

    }
}