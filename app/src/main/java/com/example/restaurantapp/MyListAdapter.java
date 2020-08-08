package com.example.restaurantapp;


import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import static java.lang.String.copyValueOf;


public class MyListAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] maintitle; // private final String[] subtitle;
    private final Double[] price;
    private final String[] imgid;
    private  final  String[] foodtype;
    int j;
    String p;

   // menu array[] = new menu[4];


                           public MyListAdapter(Activity context, String[] maintitle, Double[] price, String[] imgid,String[] foodtype) {
        super(context, R.layout.activity_my_list_adapter, maintitle);
        // TODO Auto-generated constructor stub


        this.context=context;
        this.maintitle=maintitle;
         this.price=price;
        this.imgid=imgid;
        this.foodtype=foodtype;


                           }

    public View getView(int position, final View view, ViewGroup parent) {

        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.activity_my_list_adapter, null,true);
        Button button=(Button)rowView.findViewById(R.id.button);
        TextView titleText = (TextView) rowView.findViewById(R.id.title);
        TextView priceText = (TextView) rowView.findViewById(R.id.price);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
        //TextView subtitleText = (TextView) rowView.findViewById(R.id.subtitle);


        final Intent intent4 = new Intent(context, ordernow.class);
        final Intent intent5= new Intent(context, ordernow1.class);
        final Intent intent6= new Intent(context, ordernow2.class);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View parentRow=(View) v.getParent();
                ListView listView=(ListView) parentRow.getParent();
                final int pos=listView.getPositionForView(parentRow);
              //  Toast.makeText(getContext(),"button clicked"+pos,Toast.LENGTH_SHORT).show();

           String h=maintitle[pos];
              //  Toast.makeText(getContext(),"mil gaya"+h,Toast.LENGTH_SHORT).show();


              //  intent4.putExtra("position", pos);
                if((foodtype[pos].equals("Chicken Flavours"))||(foodtype[pos].equals("Beef Flavours"))||(foodtype[pos].equals("Veggies")))
                {
                    intent4.putExtra("ordername",maintitle[pos]);
                    Bundle bundle = new Bundle();
                    bundle.putString("orderimg",imgid[pos] );

                    intent4.putExtra("orderimg", bundle);
                    context.startActivity(intent4);}
                else if((foodtype[pos].equals("Desserts"))||(foodtype[pos].equals("Sides"))||(foodtype[pos].equals("Dips")))
                {
                    Toast.makeText(getContext(),"Not a chicken flavour "+foodtype[pos],Toast.LENGTH_SHORT).show();
                    intent5.putExtra("ordername",maintitle[pos]);
                    Bundle bundle = new Bundle();
                    bundle.putString("orderimg",imgid[pos] );

                    intent5.putExtra("orderimg", bundle);
                    context.startActivity(intent5);
                }
                else if((foodtype[pos].equals("Drinks")))
                {
                   // Toast.makeText(getContext(),"Not a chicken flavour "+foodtype[pos],Toast.LENGTH_SHORT).show();
                    intent6.putExtra("ordername",maintitle[pos]);
                    Bundle bundle = new Bundle();
                    bundle.putString("orderimg",imgid[pos] );

                    intent6.putExtra("orderimg", bundle);
                    context.startActivity(intent6);
                }

            }
        });
        titleText.setText(maintitle[position]);
        String a=String.valueOf(price[position]);
        priceText.setText(a+"");
       // imageView.setImageResource((imgid[position]));

        int j=context.getResources().getIdentifier(imgid[position],"drawable",context.getPackageName());
        imageView.setImageResource(j);

        return rowView;

    };

}

