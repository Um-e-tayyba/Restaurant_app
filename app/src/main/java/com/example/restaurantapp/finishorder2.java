package com.example.restaurantapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class finishorder2 extends AppCompatActivity {

    TextView name;
    TextView last;
    TextView phone;
    TextView email;
    TextView address;
    Button placeorder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finishorder2);
        name = (TextView)    findViewById(R.id.name);
        last = (TextView)    findViewById(R.id.last);
        phone = (TextView)    findViewById(R.id.phone);
        address =(TextView)     findViewById(R.id.address);
        email = (TextView)   findViewById(R.id.email);
        placeorder= (Button) findViewById(R.id.placeorder);

        placeorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tn= new Intent(finishorder2.this,placeorder.class);
                startActivity(tn);

            }
        });

        Intent intent=getIntent();
        String n1=intent.getStringExtra("firstname1");
        String l1=intent.getStringExtra("lastname1");
        String p1=intent.getStringExtra("phone1");
        String a1=intent.getStringExtra("address1");
        String e1=intent.getStringExtra("Email1");

        name.setText(n1);
        last.setText(l1);
        phone.setText(p1);
        address.setText(a1);
        email.setText(e1);
    }

}
