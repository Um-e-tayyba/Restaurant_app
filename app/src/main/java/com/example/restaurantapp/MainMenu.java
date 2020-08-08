package com.example.restaurantapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainMenu extends AppCompatActivity {
String mainmenu[]={"Chicken Flavours","Beef Flavours","Veggies","Sides","Desserts","Drinks","Dips"};
String selected;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        final Intent intent=getIntent();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mainmenu);
        ListView listview = (ListView) findViewById(R.id.list);
        listview.setAdapter(adapter);
       final Intent intent3=new Intent(this,Main2Activity.class);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selected=mainmenu[position];
              //  Toast.makeText(getApplicationContext(), selected, Toast.LENGTH_SHORT).show();
                intent3.putExtra("x",selected);
startActivity(intent3);


            }
        });
    }
}
