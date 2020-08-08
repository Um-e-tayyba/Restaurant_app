package com.example.restaurantapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.restaurantapp.DatabaseContract.Users.newTABLE11;
import static com.example.restaurantapp.DatabaseContract.Users.newTABLE11;


public class insertmenu extends AppCompatActivity {
    EditText e1, e2, e3, e4,e5,e6;
    DatabaseHelper dbHelper;





    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertmenu);
        dbHelper = new DatabaseHelper(this);

       // Intent intent=getIntent();

    }
    public void Insert(View v) {
        db = dbHelper.getWritableDatabase();

        e1=(EditText) findViewById(R.id.ed1);
        e2=(EditText) findViewById(R.id.ed2);
        e3=(EditText) findViewById(R.id.ed3);
        e4=(EditText) findViewById(R.id.ed4);
        e5=(EditText) findViewById(R.id.ed5);
        e6=(EditText) findViewById(R.id.ed6);

        String val1 = e1.getText().toString();
        String val2 = e2.getText().toString();
        String val3 = e3.getText().toString();
        String val4 = e4.getText().toString();
        String val5 = e5.getText().toString();
        String val6 = e6.getText().toString();

        ContentValues values = new ContentValues();
        values.put(DatabaseContract.Users.COL_foodname, val1);
        values.put(DatabaseContract.Users.COL_fooddescription, val2);
        values.put(DatabaseContract.Users.COL_foodprice, val3);
        values.put(DatabaseContract.Users.COL_foodimage, val4);
        values.put(DatabaseContract.Users.COL_foodtype, val5);
        values.put(DatabaseContract.Users.COL_pizzaprice, val6);

        Toast.makeText(this, "food name " + val1, Toast.LENGTH_SHORT).show();
        long newRowId = db.insert(newTABLE11, null, values);
        if (newRowId > 0) {
            Toast.makeText(this, "New Record Inserted: " + newRowId, Toast.LENGTH_SHORT).show();
            Toast.makeText(this, "food name " + val1, Toast.LENGTH_SHORT).show();
            Toast.makeText(this, "pizza price " + val6, Toast.LENGTH_SHORT).show();
        }

        db.close();

    }

  /*  public void Search(View v)
    {
        db = dbHelper.getWritableDatabase();

        e1 = (EditText) findViewById(R.id.ed1);
        e2 = (EditText) findViewById(R.id.ed2);
        String val1 = e1.getText().toString();
        String[] columns={DatabaseContract.Users._ID, DatabaseContract.Users.COL_foodname, DatabaseContract.Users.COL_foodprice};
        Cursor cursor = db.query(newTABLE11, columns, DatabaseContract.Users.COL_foodname + "=?",
                new String[] { val1}, null, null, null, null);
        if (cursor.getCount()>0) {
            cursor.moveToFirst();
            String email = cursor.getString(2);
            e2.setText(email);
        }
        else
            e2.setText("No record found");

        db.close();

    }*/
    public void Delete(View v)
    {
        db = dbHelper.getWritableDatabase();

        e1 = (EditText) findViewById(R.id.ed1);
        String val1 = e1.getText().toString();
        Integer i1= db.delete(newTABLE11, "Foodname= ?",new String[] {val1});
        if (i1 > 0) {
            Toast.makeText(this, i1+"  Records deleted: " , Toast.LENGTH_SHORT).show();
        }
        db.close();

    }
    public void Logout(View v)
    {
        Intent il = new Intent(this, MainActivity.class);
        startActivity(il);
        finish();
    }

}


