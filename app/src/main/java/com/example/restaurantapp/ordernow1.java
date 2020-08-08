package com.example.restaurantapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.restaurantapp.DatabaseContract.Users.COL_foodname;
import static com.example.restaurantapp.DatabaseContract.Users.newTABLE11;
import static com.example.restaurantapp.DatabaseContract.Users.newTABLE11;

public class ordernow1 extends AppCompatActivity {
    DatabaseHelper dbHelper;
    SQLiteDatabase db;
    ImageView orderitemimg;
    TextView orderitem;
    TextView orderdescription;
    TextView price;
    Button buttonOrder;
    String order_name;
    String order_image;
    int count;
    String fooddescriptio;
    String foodprice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ordernow1);
        dbHelper = new DatabaseHelper(this);
        orderitemimg = (ImageView) findViewById(R.id.orderimage);
        orderitem = (TextView) findViewById(R.id.ordername);
        orderdescription = (TextView) findViewById(R.id.orderdescription);
        price = (TextView) findViewById(R.id.price);
count=0;
        Intent intent5 = getIntent();
        order_name = intent5.getStringExtra("ordername");
        Bundle bundle = this.getIntent().getBundleExtra("orderimg");
        order_image = bundle.getString("orderimg");
//order_description=intent4.getStringExtra("position");
        orderitem.setText(order_name + " ");
        //orderitemimg.setImageResource(order_image);

        int j = getResources().getIdentifier(order_image, "drawable", getPackageName());
        orderitemimg.setImageResource(j);

        db = dbHelper.getWritableDatabase();
        String query = "select * from " + newTABLE11 + " where " + COL_foodname + " like '" + order_name + "%'";
        Cursor c;
        c = db.rawQuery(query, null);

        while (c.moveToNext()) {

            fooddescriptio = c.getString(2);
            foodprice = c.getString(3);

            count++;

        }

        orderdescription.setText(fooddescriptio + " ");
        price.setText(foodprice+"");
        final   Intent l=new Intent(this,cart.class);
        buttonOrder=(Button) findViewById(R.id.button);
        buttonOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String h1=orderitem.getText().toString();
             //   Toast.makeText(ordernow1.this, "arrived",
               //         Toast.LENGTH_LONG).show();
                String r=price.getText().toString();

                l.putExtra("price",r);
                l.putExtra("orderitem",h1);
                startActivity(l);

            }
        });





        c.close();
        db.close();

    }
}
