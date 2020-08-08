package com.example.restaurantapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.restaurantapp.fragment2;

import java.lang.reflect.Array;

public class cart extends AppCompatActivity {

    Button firstFragment;
    EditText ed1;
    EditText ed2;
    EditText ed3;
    EditText ed4;
    EditText ed5;
    EditText ed6;
    TextView b1;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String id[]=new String[10];

        setContentView(R.layout.activity_cart);
        Intent z=getIntent();
        String crust=z.getStringExtra("crust");
        String size=z.getStringExtra("size");
        String price=z.getStringExtra("price");
        String toppings=z.getStringExtra("toppings");
String orderitem=z.getStringExtra("orderitem");




        int count=0;

        Intent m=getIntent();
        Intent l=getIntent();





        ed1=(EditText) findViewById(R.id.f2) ;
        ed2=(EditText) findViewById(R.id.f3) ;
        ed3=(EditText) findViewById(R.id.f4) ;
        ed4=(EditText) findViewById(R.id.f5) ;
        ed5=(EditText) findViewById(R.id.f6) ;
        //ed6=(EditText) findViewById(R.id.f7) ;




        ed2.setText("CRUST ="+crust);
        ed3.setText("SIZE ="+size);
        ed4.setText("PRICE ="+price);
ed5.setText("TOPPINGS="+toppings);
ed1.setText("Order="+orderitem);
        b1 = (TextView) findViewById(R.id.FButton);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent t= new Intent(cart.this,finishorder.class);
                startActivity(t);

            }
        });

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        DisplayMetrics displayMetrics = this.getResources().getDisplayMetrics();
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;
        if(width
                >height) {

            fragment2 f2 = new fragment2();
            fragmentTransaction.replace(android.R.id.content, f2);
        }

    }

}


