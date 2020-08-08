package com.example.restaurantapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class signup extends AppCompatActivity {

    SQLiteOpenHelper openHelper ;
    SQLiteDatabase db;
    Button b1, login2;
    EditText e1, e2, e3, e4, e5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        openHelper= new DatabaseHelper1(this);
        b1=(Button)findViewById(R.id.regbutton);
        e1=(EditText)findViewById(R.id.textfname);
        e2=(EditText)findViewById(R.id.textlname);
        e3=(EditText)findViewById(R.id.pass);
        e4=(EditText)findViewById(R.id.email);
        e5=(EditText)findViewById(R.id.phone);
        login2=(Button) findViewById(R.id.login2);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db=openHelper.getWritableDatabase();
                String fname=e1.getText().toString();
                String lname=e2.getText().toString();
                String password=e3.getText().toString();
                String email=e4.getText().toString();
                String phone=e5.getText().toString();

                if ((e1.length()<=0) && (e2.length()<=0) && (e3.length()<=0) && (e4.length()<=0) && (e5.length()<=0))
                {
                    Toast.makeText(getApplicationContext(), " Fields should not be empty", Toast.LENGTH_LONG).show();
                    return;
                }
                else if((e1.length()<=0))
                {
                    Toast.makeText(getApplicationContext(), " Enter First Name", Toast.LENGTH_LONG).show();
                    return;
                }
                else if((e2.length()<=0))
                {
                    Toast.makeText(getApplicationContext(), " Enter Last Name", Toast.LENGTH_LONG).show();
                    return;
                }
                else if((e3.length()<=0) )
                {
                    Toast.makeText(getApplicationContext(), " Enter password", Toast.LENGTH_LONG).show();
                    return;
                }
                else if((e3.length()<=5))
                {
                    Toast.makeText(getApplicationContext(), "Password is too weak", Toast.LENGTH_LONG).show();
                    return;
                }
                else if((e4.length()<=0))
                {
                    Toast.makeText(getApplicationContext(), " Enter email", Toast.LENGTH_LONG).show();
                    return;
                }
                else if((e5.length()<=0))
                {
                    Toast.makeText(getApplicationContext(), " Enter phone number", Toast.LENGTH_LONG).show();
                    return;
                }



                insertdata(fname,lname,password,email,phone);
                Toast.makeText(getApplicationContext(),"Register Successfully", Toast.LENGTH_LONG).show();
            }
        });

        login2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(signup.this, MainActivity.class );
                startActivity(intent);

            }
        });
    }

    public void insertdata(String fname,String lname, String password, String email, String phone)
    {
        ContentValues ContentValues= new ContentValues();
        ContentValues.put(DatabaseHelper1.COL_2, fname);
        ContentValues.put(DatabaseHelper1.COL_3, lname);
        ContentValues.put(DatabaseHelper1.COL_4, password);
        ContentValues.put(DatabaseHelper1.COL_5, email);
        ContentValues.put(DatabaseHelper1.COL_6, phone);

        long id=db.insert(DatabaseHelper1.TABLE_NAME,null,ContentValues);
    }
}
