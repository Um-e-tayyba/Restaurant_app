package com.example.restaurantapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.restaurantapp.DatabaseContract.Users.COL_foodname;
import static com.example.restaurantapp.DatabaseContract.Users.newTABLE11;

public class ordernow2 extends AppCompatActivity {
    DatabaseHelper dbHelper;
    SQLiteDatabase db;
    ImageView orderitemimg;
    TextView orderitem;
    TextView orderdescription;
    TextView price;
    TextView size;
    Button buttonOrder;
    String order_name;
    String order_image;
    int count;
    String fooddescriptio;
    String foodprice;
    int l,m;
    Double foodpricee;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ordernow2);
        dbHelper = new DatabaseHelper(this);
        orderitemimg = (ImageView) findViewById(R.id.orderimage);
        orderitem = (TextView) findViewById(R.id.ordername);
        orderdescription = (TextView) findViewById(R.id.orderdescription);
        price = (TextView) findViewById(R.id.price);
        size = (TextView) findViewById(R.id.size);
l=0;m=0;foodpricee=0.0;
        count=0;
        Intent intent6 = getIntent();
        order_name = intent6.getStringExtra("ordername");
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
        //price.setText(foodprice+"");
        c.close();
        db.close();
        size.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(ordernow2.this, size);
                popupMenu.getMenuInflater().inflate(R.menu.popupmenu2, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {

                       // Toast.makeText(ordernow2.this, "" + item.getTitle(), Toast.LENGTH_SHORT).show();

                        size.setText(item.getTitle() + "");
                        if ((item.getTitle()).equals("345ml"))
                        { if(l==1)
                        {
                            foodpricee-=89.0;
                            l=0;
                        }

                            if(m==1)
                            {
                                foodpricee-=299.0;
                                m=0;
                            }

                            // foodprice=0.0;
                            l=1;
                            foodpricee +=  89.0;
                            price.setText(foodpricee + "");}



                        else if ((item.getTitle()).equals("1.5 Liter"))
                        {
                            if(m==1)
                            { foodpricee-=299.0;
                                m=0;
                            }
                            if(l==1)
                            { foodpricee-=89.0;
                                l=0;
                            }

                            m=1;
                            // foodprice=0.0;
                            foodpricee +=  299.0;

                            price.setText(foodpricee + "");}





                        return true;
                    }
                });
                popupMenu.show();
            }
        });
        final   Intent m=new Intent(this,cart.class);
        buttonOrder=(Button) findViewById(R.id.button);
        buttonOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                if (size.getText().toString().isEmpty())
                {
                    AlertDialog alertDialog = new AlertDialog.Builder(ordernow2.this).create();
                    alertDialog.setTitle("Alert");
                    alertDialog.setMessage("Please select drink size");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();
                }

                      //getting crust
                else
                { String q=size.getText().toString();          //getting size
                String r=price.getText().toString();
                String h=orderitem.getText().toString();
                m.putExtra("size",q);
                m.putExtra("price",r);
                m.putExtra("orderitem",h);

                startActivity(m);}
            }
        });
    }
}
