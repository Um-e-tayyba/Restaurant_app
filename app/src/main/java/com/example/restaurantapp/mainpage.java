package com.example.restaurantapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class mainpage extends AppCompatActivity {
String e,p;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainpage);
        Intent intent=getIntent();

    //   e=  intent.getStringExtra("email");
      //  p= intent.getStringExtra("password");
        Toast.makeText(getApplicationContext(), "email"+e, Toast.LENGTH_SHORT).show();
        Toast.makeText(getApplicationContext(), "password" +p ,Toast.LENGTH_SHORT).show();

        ImageButton b1=(ImageButton) findViewById(R.id.imageButton1);
        ImageButton b2=(ImageButton) findViewById(R.id.imageButton2);
        final   Intent f=new Intent(this,Takeaway.class);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(f);
            }
        });

        final   Intent g=new Intent(this,MainMenu.class);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(), "email"+e, Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(), "password" +p ,Toast.LENGTH_SHORT).show();
                startActivity(g);
            }
        });

    }
    @Override

    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.ourmenu:
            { Toast.makeText(getApplicationContext(), "login " , Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(this,MainMenu.class);
                startActivity(intent);
                return true;}

            case R.id.logout: {
                Intent il = new Intent(this, MainActivity.class);
                startActivity(il);
                finish();
            }
            case R.id.call: {
                Intent intent=new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:03335216983"));
                startActivity(intent);
            }

            default:
            {  return super.onOptionsItemSelected(item);}
        }

    }


}

