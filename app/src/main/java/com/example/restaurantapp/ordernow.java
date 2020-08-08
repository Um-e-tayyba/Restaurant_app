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
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.restaurantapp.DatabaseContract.Users.COL_foodname;
import static com.example.restaurantapp.DatabaseContract.Users.COL_foodtype;
import static com.example.restaurantapp.DatabaseContract.Users.newTABLE11;
import static com.example.restaurantapp.DatabaseContract.Users.newTABLE11;

public class ordernow extends AppCompatActivity {
ImageView orderitemimg;
TextView orderitem;
TextView orderdescription;
TextView crust;
TextView size;
TextView price;
int a,b,z,d,e;
int l,m,n;
int y,k,t,u,v;
    int toppingcount;
    Double temp=0.0;
    Double temp1=0.0;
Button buttonOrder;
CheckBox Cb1, Cb2,Cb3,Cb4,Cb5,Cb6,Cb7,Cb8,Cb9,Cb10;
String[] checkedboxes=new String[3];

String order_name;
String order_image;
    String fooddescriptio;
    Double foodpricee;
  //  String foodtyp;

int count;
    DatabaseHelper dbHelper;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ordernow);
toppingcount=0;
            crust = (TextView) findViewById(R.id.crust);
            price = (TextView) findViewById(R.id.price);
            dbHelper = new DatabaseHelper(this);
            count = 0;
            a=0;b=0;z=0;d=0;e=0;
            l=0;m=0;n=0;
            y=0;k=0;t=0;u=0;v=0;
            //foodpricee=0.0;
            orderitemimg = (ImageView) findViewById(R.id.orderimage);
            orderitem = (TextView) findViewById(R.id.ordername);
            orderdescription = (TextView) findViewById(R.id.orderdescription);
            size = (TextView) findViewById(R.id.size);

            Intent intent4 = getIntent();
            order_name = intent4.getStringExtra("ordername");
            Bundle bundle = this.getIntent().getBundleExtra("orderimg");
            order_image = bundle.getString("orderimg");

            orderitem.setText(order_name + " ");


            int j = getResources().getIdentifier(order_image, "drawable", getPackageName());
            orderitemimg.setImageResource(j);


            db = dbHelper.getWritableDatabase();
            String query = "select * from " + newTABLE11 + " where " + COL_foodname + " like '" + order_name + "%'";
            Cursor c;
            c = db.rawQuery(query, null);


            while (c.moveToNext()) {

                fooddescriptio = c.getString(2);
                foodpricee = c.getDouble(6);

                count++;

            }
            //String o=fooddescription[count];
            orderdescription.setText(fooddescriptio + " ");

            c.close();
            db.close();




            size.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    PopupMenu popupMenu = new PopupMenu(ordernow.this, size);
                    popupMenu.getMenuInflater().inflate(R.menu.popupmenu1, popupMenu.getMenu());
                    popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {

                         //   Toast.makeText(ordernow.this, "" + item.getTitle(), Toast.LENGTH_SHORT).show();

                            size.setText(item.getTitle() + "");
                            if ((item.getTitle()).equals("Small"))
                            {
                                if(l==1)
                                {
                                    foodpricee-=299.0;
                                    l=0;
                                }
                              if(m==1)
                              {
                               foodpricee-=399.0;
                               m=0;
                              }
                              if(n==1)
                              {
                                  foodpricee-=499;
                                  n=0;
                              }
                                l=1;
                              // foodprice=0.0;
                                foodpricee +=  299.0;
                                price.setText(foodpricee + "");}



                            else if ((item.getTitle()).equals("Medium"))
                            {
                                if(m==1)
                                { foodpricee-=399.0;
                                    m=0;
                                }
if(l==1)
{ foodpricee-=299.0;
l=0;
}
if(n==1)
{foodpricee-=499;
n=0;
}
                                m=1;
                                    // foodprice=0.0;
                                foodpricee +=  399.0;

                                price.setText(foodpricee + "");}


                            else if ((item.getTitle()).equals("Large"))
                            { if(n==1)
                            {
                                foodpricee-=499.0;
                                n=0;
                            }

                                if(l==1)
                                {
                                    foodpricee-=299.0;
                                    l=0;
                                }
                                if(m==1)
                                {
                                    foodpricee-=399;
                                    m=0;}
                                n=1;
                                foodpricee +=   499.0;
                                price.setText(foodpricee + "");}


                            return true;
                        }
                    });
                    popupMenu.show();
                }
            });
        crust.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(ordernow.this, crust);
                popupMenu.getMenuInflater().inflate(R.menu.popupmenu, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {

                        Toast.makeText(ordernow.this, "" + item.getTitle(), Toast.LENGTH_SHORT).show();


                        crust.setText(item.getTitle() + "");
                        if ((item.getTitle()).equals("hand tossed")) {
                            if(a==1)
                            {
                                foodpricee-=200.0;
                                a=0;
                            }

                              if(b==1)
                               {
                                   foodpricee-=205.0;
                                   b=0;
                               }
                               if(z==1)
                               {
                                   foodpricee-=275.0;
                                   z=0;
                               }
                               if(d==1)
                               {
                                   foodpricee-=225.0;
                                   d=0;
                               }
                               if(e==1)
                               {
                                   foodpricee-=250.0;
                                   e=0;
                               }

                            a=1;
                            foodpricee+= 200.0;
                                price.setText(foodpricee + "");}

                           // price.setText(foodpricee + "");
                        else if ((item.getTitle()).equals("pan")) {

                            if(b==1)
                            {
                                foodpricee-=205.0;
                                b=0;
                            }

                       if(a==1)
                            {
                                foodpricee-=200.0;
                                a=0;
                            }
                            if(z==1)
                            {
                                foodpricee-=275.0;
                                z=0;
                            }
                            if(d==1)
                            {
                                foodpricee-=225.0;
                                d=0;
                            }
                            if(e==1)
                            {
                                foodpricee-=250.0;
                                e=0;
                            }
                            b=1;
                            foodpricee+= 205.0;
                                price.setText(foodpricee + "");}

                          //  price.setText(foodpricee + "");
                         else if ((item.getTitle()).equals("Italian thin")) {

                            if(z==1)
                            {
                                foodpricee-=275.0;
                                z=0;
                            }


                            if(b==1)
                            {
                                foodpricee-=205.0;
                                b=0;
                            }
                            if(a==1)
                            {
                                foodpricee-=200.0;
                                a=0;
                            }
                            if(d==1)
                            {
                                foodpricee-=225.0;
                                d=0;
                            }
                            if(e==1)
                            {
                                foodpricee-=250.0;
                                e=0;
                            }
                            z=1;
                            foodpricee += 275.0;
                                price.setText(foodpricee + "");}
                            //price.setText(foodpricee + "");

                        else if ((item.getTitle()).equals("Crunchy thin")) {

                            if(d==1)
                            {
                                foodpricee-=225.0;
                                d=0;
                            }
                           if(b==1)
                            {
                                foodpricee-=205.0;
                                b=0;
                            }
                            if(z==1)
                            {
                                foodpricee-=275.0;
                                z=0;
                            }
                            if(a==1)
                            {
                                foodpricee-=200.0;
                                a=0;
                            }
                            if(e==1)
                            {
                                foodpricee-=250.0;
                                e=0;
                            }
                            d=1;

                            foodpricee+= 225.0;
                                price.setText(foodpricee + "");}

                            //price.setText(foodpricee + "");
                         else if ((item.getTitle()).equals("Double melt")) {


                            if(e==1)
                            {
                                foodpricee-=250.0;
                                e=0;
                            }

                            if(b==1)
                            {
                                foodpricee-=205.0;
                                b=0;
                            }
                            if(z==1)
                            {
                                foodpricee-=275.0;
                                z=0;
                            }
                            if(d==1)
                            {
                                foodpricee-=225.0;
                                d=0;
                            }
                            if(a==1)
                            {
                                foodpricee-=200.0;
                                a=0;
                            }
                            e=1;
                            foodpricee += 250.0;
                                price.setText(foodpricee + "");}



                        return true;
                    }
                });
                popupMenu.show();
            }
        });

//}
            // public void addListenerOnButtonClick(){
            //Getting instance of CheckBoxes and Button from the activty_main.xml file
            Cb1 = (CheckBox) findViewById(R.id.cb1);
            Cb2 = (CheckBox) findViewById(R.id.cb2);
            Cb3 = (CheckBox) findViewById(R.id.cb3);
            Cb4 = (CheckBox) findViewById(R.id.cb4);
            Cb5 = (CheckBox) findViewById(R.id.cb5);
            Cb6 = (CheckBox) findViewById(R.id.cb6);
            Cb7 = (CheckBox) findViewById(R.id.cb7);
            Cb8 = (CheckBox) findViewById(R.id.cb8);
            Cb9 = (CheckBox) findViewById(R.id.cb9);
            Cb10 = (CheckBox) findViewById(R.id.cb10);

            //buttonOrder = (Button) findViewById(R.id.button);





            Cb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    u=1;

                       if (buttonView.isChecked()) {

                           foodpricee += 80.0;
                           price.setText(foodpricee + "");
                           toppingcount++;
                         //  Toast.makeText(ordernow.this, "arrived" + toppingcount,
                           //        Toast.LENGTH_LONG).show();
                           if(toppingcount>3)
                           {
                               display_alertbox();
                               Cb1.setChecked(false);
                               foodpricee -= 80.0;
                               toppingcount--;
                           }
                           price.setText(foodpricee + "");

                       } else {
                           // not checked
                           foodpricee -= 80.0;
                           price.setText(foodpricee + "");
                           toppingcount--;
                        //   Toast.makeText(ordernow.this, "arrived" + toppingcount,
                          //         Toast.LENGTH_LONG).show();
                       }

                   }


            });

        Cb2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {


                if (buttonView.isChecked()) {

                    toppingcount++;
                   // Toast.makeText(ordernow.this, "arrived" + toppingcount,
                     //       Toast.LENGTH_LONG).show();
                    if(toppingcount>3)
                    {display_alertbox();
                        Cb2.setChecked(false);
                        toppingcount--;
                    }
                }
                else
                {
                    toppingcount--;
                    //Toast.makeText(ordernow.this, "arrived" + toppingcount,
                      //      Toast.LENGTH_LONG).show();
                }

            }


        });

        Cb3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {


                if (buttonView.isChecked()) {

                    toppingcount++;
                  //  Toast.makeText(ordernow.this, "arrived" + toppingcount,
                    //        Toast.LENGTH_LONG).show();
                    if(toppingcount>3)
                    {
                        display_alertbox();
                        Cb3.setChecked(false);
                        toppingcount--;
                    }
                }
                else
                {
                    toppingcount--;
                  //  Toast.makeText(ordernow.this, "arrived" + toppingcount,
                    //        Toast.LENGTH_LONG).show();
                }

            }


        });

        Cb4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {


                if (buttonView.isChecked()) {

                    toppingcount++;
                  //  Toast.makeText(ordernow.this, "arrived" + toppingcount,
                    //        Toast.LENGTH_LONG).show();
                    if(toppingcount>3)
                    {
                        display_alertbox();
                        Cb4.setChecked(false);
                        toppingcount--;
                    }
                }
                else
                {
                    toppingcount--;
                  //  Toast.makeText(ordernow.this, "arrived" + toppingcount,
                    //        Toast.LENGTH_LONG).show();
                }

            }


        });

        Cb5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {


                if (buttonView.isChecked()) {

                    toppingcount++;
                  //  Toast.makeText(ordernow.this, "arrived" + toppingcount,
                    //        Toast.LENGTH_LONG).show();
                    if(toppingcount>3)
                    {
                        display_alertbox();
                        Cb5.setChecked(false);
                        toppingcount--;
                    }

                }
                else
                {
                    toppingcount--;
                  //  Toast.makeText(ordernow.this, "arrived" + toppingcount,
                    //        Toast.LENGTH_LONG).show();
                }

            }


        });

        Cb6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {


                if (buttonView.isChecked()) {

                    toppingcount++;
                    if(toppingcount>3)
                    {
                        display_alertbox();
                        Cb6.setChecked(false);
                        toppingcount--;
                    }
                }
                else
                {
                    toppingcount--;
                }
            }


        });
        Cb7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                v=1;

                { if (buttonView.isChecked()) {
                  //  Toast.makeText(ordernow.this,"arrived" + "are selected",
                    //        Toast.LENGTH_LONG).show();
                    foodpricee += 85.0;

                    toppingcount++;

                  //  Toast.makeText(ordernow.this, "arrived" + toppingcount,
                    //        Toast.LENGTH_LONG).show();
                    if(toppingcount>3)
                    {
                        display_alertbox();
                        foodpricee -= 85.0;
                        Cb7.setChecked(false);
                        toppingcount--;
                    }
                    price.setText(foodpricee +"");

                } else {
                    // not checked
                    foodpricee -= 85.0;
                    price.setText(foodpricee + "");

                   toppingcount--;
                }
            }
               }


        });
        Cb8.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                y=1;

                 if (buttonView.isChecked()) {
                   // Toast.makeText(ordernow.this, "arrived" + "are selected",
                     //       Toast.LENGTH_LONG).show();
                    foodpricee += 105.0;

                    toppingcount++;
                     if(toppingcount>3)
                     {
                         display_alertbox();
                         foodpricee -= 105.0;
                         Cb8.setChecked(false);
                         toppingcount--;
                     }
                     price.setText(foodpricee + "");
                } else {
                    // not checked
                    foodpricee -= 105.0;
                    price.setText(foodpricee + "");
                    toppingcount--;
                }

               }


        });
        Cb9.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                k=1;
                 if (buttonView.isChecked()) {
                   // Toast.makeText(ordernow.this, "arrived" + "are selected",
                     //       Toast.LENGTH_LONG).show();
                    foodpricee += 135.0;

                  toppingcount++;
                     if(toppingcount>3)
                     {
                         display_alertbox();
                         foodpricee -= 135.0;
                         Cb9.setChecked(false);
                         toppingcount--;
                     }
                     price.setText(foodpricee + "");
                } else {
                    // not checked
                    foodpricee -= 135.0;
                    price.setText(foodpricee + "");
                   toppingcount--;
                }
            }


        });
        Cb10.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                t = 1;

                    if (buttonView.isChecked()) {
                      //  Toast.makeText(ordernow.this, "arrived" + Cb10.getText().toString(),
                        //        Toast.LENGTH_LONG).show();
                        foodpricee += 150.0;

                        toppingcount++;
                        if(toppingcount>3)
                        {
                           display_alertbox();
                            foodpricee -= 150.0;
                            Cb10.setChecked(false);
                            toppingcount--;
                        }
                        price.setText(foodpricee + "");
                    } else {
                        // not checked
                        foodpricee -= 150.0;
                        price.setText(foodpricee + "");
                        toppingcount--;
                    }


            }


        });
        final   Intent z=new Intent(this,cart.class);
orderitem.getText().toString();
        buttonOrder=(Button) findViewById(R.id.button);
        buttonOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String p=crust.getText().toString();         //getting crust
                String q=size.getText().toString();          //getting size
String r=price.getText().toString();
z.putExtra("orderitem",orderitem.getText().toString());
                z.putExtra("crust",p);
                z.putExtra("size",q);
                z.putExtra("price",r);

             //   Toast.makeText(ordernow.this, "arrived" + p,
               //         Toast.LENGTH_LONG).show();
//int a1,a2,a3,a4,a5,a6,a7,a8,a9,a10;
//a1=0;a2=0;a3=0;a4=0;a5=0;a6=0;a7=0;a8=0;a9=0;a10=0;
                StringBuilder sb = new StringBuilder("");
               // sb.append(userId);
                //sb.append(PROFILE_PICTURE_URL_EXTENSION);

                String profilePictureUrl = sb.toString();
                int count=0;
                if(Cb1.isChecked())
                {
                    sb.append('+');
                    sb.append(Cb1.getText());
                   // Toast.makeText(ordernow.this, "arrived" + sb.toString(),
                     //   Toast.LENGTH_LONG).show();

              //  count++;

               // z.putExtra("cb1",Cb1.getText().toString());
                }

                if(Cb2.isChecked())
                {
                    sb.append('+');
                    sb.append(Cb2.getText());
                  //  Toast.makeText(ordernow.this, "arrived" + sb.toString(),
                    //    Toast.LENGTH_LONG).show();
                    //z.putExtra("cb2",Cb2.getText().toString());
                }

                if(Cb3.isChecked())
                {
                    sb.append('+');
                    sb.append(Cb3.getText());
                  //  Toast.makeText(ordernow.this, "arrived" + sb.toString(),
                    //    Toast.LENGTH_LONG).show();
                   // z.putExtra("cb3",Cb3.getText().toString());
                }

                if(Cb4.isChecked())
                {
                    sb.append('+');
                    sb.append(Cb4.getText());
                  //  Toast.makeText(ordernow.this, "arrived" + sb.toString(),
                    //    Toast.LENGTH_LONG).show();
                    //z.putExtra("cb4",Cb4.getText().toString());
                }

                if(Cb5.isChecked())
                {
                    sb.append('+');
                    sb.append(Cb5.getText());
                   // Toast.makeText(ordernow.this, "arrived" +sb.toString(),
                     //   Toast.LENGTH_LONG).show();
                   // z.putExtra("cb5",Cb5.getText().toString());
                }

                if(Cb6.isChecked())
                { sb.append('+');
                    sb.append(Cb6.getText());
                   // Toast.makeText(ordernow.this, "arrived" +sb.toString(),
                     //   Toast.LENGTH_LONG).show();
                   // z.putExtra("cb6",Cb6.getText().toString());
                }

                if(Cb7.isChecked())
                {
                    sb.append('+');
                    sb.append(Cb7.getText());
                   // Toast.makeText(ordernow.this, "arrived" + sb.toString(),
                     //   Toast.LENGTH_LONG).show();
                   // z.putExtra("cb7",Cb7.getText().toString());
                }

                if(Cb8.isChecked())
                { sb.append('+');
                    sb.append(Cb8.getText());
                   // Toast.makeText(ordernow.this, "arrived" + sb.toString(),
                     //   Toast.LENGTH_LONG).show();
                   // z.putExtra("cb8",Cb8.getText().toString());
                }

                if(Cb9.isChecked())
                { sb.append('+');
                    sb.append(Cb9.getText());
                   // Toast.makeText(ordernow.this, "arrived" +sb.toString(),
                     //   Toast.LENGTH_LONG).show();
                   // z.putExtra("cb9",Cb9.getText().toString());
                }
                if(Cb10.isChecked())
                { sb.append('+');
                    sb.append(Cb10.getText());
                   // Toast.makeText(ordernow.this, "arrived" + sb.toString(),
                     //   Toast.LENGTH_LONG).show();
                    //z.putExtra("cb10",Cb10.getText().toString());
                }


                if ((crust.getText().toString().isEmpty())||(size.getText().toString().isEmpty()))
                {
                    if (crust.getText().toString().isEmpty())
                    {
                        AlertDialog alertDialog = new AlertDialog.Builder(ordernow.this).create();
                        alertDialog.setTitle("Alert");
                        alertDialog.setMessage("Please select CRUST");
                        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                });
                        alertDialog.show();
                    }
                if (size.getText().toString().isEmpty())
                {
                    AlertDialog alertDialog = new AlertDialog.Builder(ordernow.this).create();
                    alertDialog.setTitle("Alert");
                    alertDialog.setMessage("Please select size");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();
                }}
                else
                {
                  //  z.putExtra("fooditem",)
                    z.putExtra("toppings",sb.toString());
startActivity(z);}

            }
        });




    }
    void display_alertbox()
    {
        AlertDialog alertDialog = new AlertDialog.Builder(ordernow.this).create();
        alertDialog.setTitle("Alert");
        alertDialog.setMessage("Max allowed toppings are 3");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();

    }
}






