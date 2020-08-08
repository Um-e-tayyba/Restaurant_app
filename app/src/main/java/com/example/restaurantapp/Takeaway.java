package com.example.restaurantapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;

public class Takeaway extends AppCompatActivity {
    Spinner branchName;
    RecyclerView recyclerView;
    String searchBranched ="";
    BranchAdapter branchAdapter;
    ArrayList<String> branchDetailset,branchNameset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_takeaway);
        Intent f = getIntent();
        setupID();
        setupValues();
    }
    private void setupID() {
        branchName=findViewById(R.id.branchName);
        recyclerView=findViewById(R.id.listview);
        LinearLayoutManager layoutManager= new LinearLayoutManager(this);
        layoutManager.setStackFromEnd(true);
        layoutManager.setReverseLayout(true);
        recyclerView.setLayoutManager(layoutManager);
    }
    private void setupValues() {
        branchName.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                searchBranched =adapterView.getItemAtPosition(i).toString();
                if(!searchBranched.isEmpty()){
                    searchBranch(searchBranched);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
    private void searchBranch(String searchBranched) {
        switch (searchBranched){
            case "Rawalpindi":
                branchNameset= new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.rwp_branch_name)));
                branchDetailset= new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.rwp_branch_detail)));
                branchAdapter=new BranchAdapter(this,branchDetailset,branchNameset,searchBranched);
                recyclerView.setAdapter(branchAdapter);
                break;


            case "Karachi":
                branchNameset= new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.karachi_branch_name)));
                branchDetailset= new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.kcr_branch_detail)));
                branchAdapter=new BranchAdapter(this,branchDetailset,branchNameset,searchBranched);
                recyclerView.setAdapter(branchAdapter);
                break;
            case "Lahore":

                branchNameset= new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.lhr_branch_name)));
                branchDetailset= new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.lhr_branch_detail)));
                branchAdapter=new BranchAdapter(this,branchDetailset,branchNameset,searchBranched);
                recyclerView.setAdapter(branchAdapter);
                break;


        }
    }


}