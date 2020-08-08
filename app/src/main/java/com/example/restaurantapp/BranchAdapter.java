package com.example.restaurantapp;


import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BranchAdapter extends RecyclerView.Adapter<BranchAdapter.ViewGroup>{
    private Context mContext;
    ArrayList<String> branchDetailset;
    ArrayList<String> branchNameset;
    String branchCity;

    public BranchAdapter(Context mContext, ArrayList<String> branchDetailset, ArrayList<String> branchNameset, String branchCity) {
        this.mContext = mContext;
        this.branchDetailset = branchDetailset;
        this.branchNameset = branchNameset;
        this.branchCity=branchCity;
        Log.d("Mytag",branchDetailset.toString());
        Log.d("Mytag",branchNameset.toString());
    }

    public class ViewGroup extends RecyclerView.ViewHolder {

        private TextView branchname,branchdetail;
        LinearLayout linearLayout;


        public ViewGroup(@NonNull View itemView) {
            super(itemView);

            branchname=itemView.findViewById(R.id.branchName);
            branchdetail=itemView.findViewById(R.id.branchDetail);
            linearLayout=itemView.findViewById(R.id.linearlayout);




        }
    }

    @NonNull
    @Override
    public ViewGroup onCreateViewHolder(@NonNull android.view.ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.row_view, parent, false);
        return new BranchAdapter.ViewGroup(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BranchAdapter.ViewGroup holder, int position) {
        Log.d("Mytag",branchDetailset.get(position));
        Log.d("Mytag",branchNameset.get(position));
        holder.branchdetail.setText(branchDetailset.get(position));
        holder.branchname.setText(branchNameset.get(position));
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent  intent=new Intent(mContext,MainMenu.class);
              //  Toast.makeText(this, branchDetailset, Toast.LENGTH_SHORT).show();
                intent.putExtra("branchname",branchCity);
                mContext.startActivity(intent);
            }
            //  mContext.startActivity(new Intent(mContext,Main3Activity.class));

        });
    }

    @Override
    public int getItemCount() {
        return branchNameset.size();
    }
}