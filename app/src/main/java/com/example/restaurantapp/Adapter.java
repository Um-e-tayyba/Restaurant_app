package com.example.restaurantapp;
public class Adapter {
    String branchName;
    String branchDetails;
    public  Adapter(){}
    public Adapter(String branchName, String branchDetails) {
        this.branchName = branchName;
        this.branchDetails = branchDetails;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getBranchDetails() {
        return branchDetails;
    }

    public void setBranchDetails(String branchDetails) {
        this.branchDetails = branchDetails;
    }
}
