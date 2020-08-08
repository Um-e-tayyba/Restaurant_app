package com.example.restaurantapp;

import android.provider.BaseColumns;

public class DatabaseContract {
    public DatabaseContract() {}

    /* Inner class that defines the table contents */
    public static abstract class Users implements BaseColumns {
        public static final String newTABLE11 = "MENUupdated";
        public static final String COL_foodname = "Foodname";
        public static final String COL_fooddescription = "Fooddescription";
        public static final String COL_foodprice = "FoodPrice";  //minimum price
        public static final String COL_foodimage = "FoodImage";
        public static final String COL_foodtype = "FoodType";
        public static final String COL_pizzaprice = "PizzaPrice";


    }
}
