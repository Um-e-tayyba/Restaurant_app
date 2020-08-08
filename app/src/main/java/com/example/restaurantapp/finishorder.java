package com.example.restaurantapp;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class finishorder extends AppCompatActivity {
    TextView b1;
    TextView b2;
    TextView b3;
    TextView b4;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finishorder);

        b1 = (TextView) findViewById(R.id.fofirstButton);
        b2 = (TextView) findViewById(R.id.fosecondButton);
        b3 = (TextView) findViewById(R.id.fothirddButton);
        b4 = (TextView) findViewById(R.id.fofourthButton);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent t= new Intent(finishorder.this,delivery.class);
                startActivity(t);

            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent t= new Intent(finishorder.this,delivery.class);
                startActivity(t);

            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent t= new Intent(finishorder.this,delivery.class);
                startActivity(t);

            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent t= new Intent(finishorder.this,delivery.class);
                startActivity(t);

            }
        });


    }
}
