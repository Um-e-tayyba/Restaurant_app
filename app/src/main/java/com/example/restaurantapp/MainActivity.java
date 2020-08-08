package com.example.restaurantapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;


    EditText txtuser, textpass;
    Button loginbtn, login3;
    Spinner spinner1;

    Cursor cursor;
String e;
String p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        openHelper = new DatabaseHelper1(this);
        db = openHelper.getReadableDatabase();

        txtuser = (EditText) findViewById(R.id.emailid);
        textpass = (EditText) findViewById(R.id.pass1);
        loginbtn = (Button) findViewById(R.id.loginbutton);
        spinner1 = (Spinner) findViewById(R.id.spinner);
        login3=(Button) findViewById(R.id.login3) ;
//Intent intent=getIntent();
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.usertype, R.layout.support_simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if ((txtuser.getText().toString().length()<=0) &&(textpass.getText().toString().length()<=0) )
                {
                    Toast.makeText(getApplicationContext(), " Fields should not be empty", Toast.LENGTH_LONG).show();
                    return;
                }
                else if((txtuser.getText().toString().length()<=0))
                {
                    Toast.makeText(getApplicationContext(), " username is empty", Toast.LENGTH_LONG).show();
                    return;
                }
                else if((textpass.getText().toString().length()<=0) )
                {
                    Toast.makeText(getApplicationContext(), " password is empty", Toast.LENGTH_LONG).show();
                    return;
                }

                String email = txtuser.getText().toString();
                String password = textpass.getText().toString();

                String item = spinner1.getSelectedItem().toString();

                if(item.equals("admin")) {
                    if (txtuser.getText().toString().equals("amina3433@gmail.com") && textpass.getText().toString().equals("3433") && item.equals("admin")
                            || txtuser.getText().toString().equals("monima3441@gmail.com") && textpass.getText().toString().equals("3441") && item.equals("admin")
                            || txtuser.getText().toString().equals("aqsa3431@gmail.com") && textpass.getText().toString().equals("3431") && item.equals("admin")
                            || txtuser.getText().toString().equals("tayyba3437@gmail.com") && textpass.getText().toString().equals("3437") && item.equals("admin")

                    ) {
                        Intent intent1 = new Intent(MainActivity.this, insertmenu.class);
                        startActivity(intent1);
                    }

                    else { Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();

                    }
                }

                else if (item.equals("user"))
                {
                    cursor = db.rawQuery("SELECT*FROM register WHERE Email=? AND Password=?", new String[]{email, password});

                    if (cursor != null) {

                        if (cursor.getCount() > 0) {
                            cursor.moveToNext();
                            e=email;
                            p=password;
                            Toast.makeText(getApplicationContext(), "Login Successfully"+e, Toast.LENGTH_LONG).show();
                            Toast.makeText(getApplicationContext(), "Login Successfully"+p, Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(MainActivity.this, mainpage.class);
                            intent.putExtra("email",e);
                            intent.putExtra("password",p);
                            startActivity(intent);
                        } else {
                            Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                        }
                    }


                }
                else{
                    Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                }
            }
        });

        login3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this,signup.class);
                startActivity(intent);

            }
        });

    }
}



