package com.example.restaurantapp;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import static com.example.restaurantapp.DatabaseContract.Users.COL_foodtype;
import static com.example.restaurantapp.DatabaseContract.Users.newTABLE11;
import static com.example.restaurantapp.DatabaseContract.Users.newTABLE11;

public class Main2Activity extends AppCompatActivity {
    ListView list;
    MyListAdapter adapter;
    DatabaseHelper dbHelper;
    SQLiteDatabase db;
    int count;

/*
    String[] chickenpizzas = {
            "Peri Peri", "Pakistani hot", "Tandori hot", "Legend bbq", "Bbq Chicken",
            "Cheese crisp chicken", "Chicken Tikka", "Golden Delight", "Hot and Spicy", "Legend-ranch",
            "Mirch masala", "Spicy chicken", "Tex max"
    };

    String[] beefpizzas = {"Cheese burger", "Hawaiian", "Pepperoni hot", "Smoked sausage"};

    String[] sides = {"Bread sticks", "Cheesy bread", "Chicken kickers", "Chicken wings", "Chicken wings peri peri",
            "Potato wedges", "Twisted dough"};
    String[] veggies = {"cheese"};
    String[] desserts = {"Choclate lava cake", "Cinnastix", "Choco bread"}; done
    String[] drinks = {"Pepsi", "Mirinda", "7Up", "Mountain Dew", "Aquafina"};
    String[] dips = {"Chilli hot sause", "Classic ranch-sause", "Marinara sause", "3dips"}; done
    Integer[] chickenpizzaimgs = {
            R.drawable.periperi, R.drawable.pakistanihot, R.drawable.tandoorihot, R.drawable.legendbbq,
            R.drawable.bbqchicken, R.drawable.cheeseburgercrispychicken, R.drawable.chickentikka,
            R.drawable.goldendelight, R.drawable.hotandspicy, R.drawable.legendranch, R.drawable.mirchmasala,
            R.drawable.spicychicken, R.drawable.texmax
    };
    Integer[] beefpizzaimgs = {R.drawable.cheeseburger, R.drawable.hawaiian, R.drawable.pepperonihot,
            R.drawable.smokedsausage};
    Integer[] sidesimgs = {
            R.drawable.breadsticks, R.drawable.cheesybread, R.drawable.chickenkickers, R.drawable.chickenwings,
            R.drawable.chickenwingsperiperi, R.drawable.potatowedges, R.drawable.twisteddough};
    Integer[] veggiesimgs = {
            R.drawable.cheese};
    Integer[] dessertsimgs = {
            R.drawable.choclatelavacake, R.drawable.cinnastix, R.drawable.chocobread};
    Integer[] drinksimgs = {
            R.drawable.pepsi, R.drawable.mirinda, R.drawable.sevenup, R.drawable.dew, R.drawable.aquafina};
    Integer[] dipsimgs = {
            R.drawable.chillihotsause, R.drawable.classicranchsause, R.drawable.marinarasause, R.drawable.threedips};*/




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        dbHelper = new DatabaseHelper(this);
        count=0;
        Intent intent3 = getIntent();
        String selected_menutype = intent3.getStringExtra("x");
        Toast.makeText(getApplicationContext(), selected_menutype, Toast.LENGTH_SHORT).show();




        final List<String> usersList = new ArrayList();
        db = dbHelper.getWritableDatabase();
        String query="select * from "+newTABLE11+ " where " +COL_foodtype+ " like '"+ selected_menutype+ "%'";
        Cursor c;
        c = db.rawQuery(query,null);

        String[] foodname = new String[c.getCount()];
        String[] fooddescription = new String[c.getCount()];
        Double[] foodprice = new Double[c.getCount()];
        String[] foodimage = new String[c.getCount()];
        String[] foodtype = new String[c.getCount()];
Double[] pizzaprice=new Double[c.getCount()];
        while (c.moveToNext()) {

            Long id = c.getLong(0);
            String foodnam = c.getString(1);
            foodname[count]=foodnam;
           String fooddescriptio = c.getString(2);
           fooddescription[count]=fooddescriptio;
            Double foodpric = c.getDouble(3);
            foodprice[count]=foodpric;
            String foodimag = c.getString(4);
            foodimage[count]=foodimag;
            String foodtyp = c.getString(5);
            foodtype[count]=foodtyp;
Double pizzapr=c.getDouble(6);
pizzaprice[count]=pizzapr;

            count++;

        }

        adapter = new MyListAdapter(this,foodname,foodprice,foodimage,foodtype);
       // Toast.makeText(getApplicationContext(), "count"+count, Toast.LENGTH_SHORT).show();
        c.close();
        db.close();

        list = (ListView) findViewById(R.id.list);
        list.setAdapter(adapter);



    }

}