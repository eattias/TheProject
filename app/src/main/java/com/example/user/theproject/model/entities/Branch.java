package com.example.user.theproject.model.entities;

/**
 * Created by user on 09/11/2017.
 */

public class Branch
{
    private String address; // city, street, number
    private int parkingNums; //num of parking places
    private int branchNum;

    //constructors

    public Branch(String address, int parkingNums, int branchNum) {
        this.address = address;
        this.parkingNums = parkingNums;
        this.branchNum = branchNum;
    }

    public Branch(Branch branch) {
        this.address = branch.address;
        this.parkingNums = branch.parkingNums;
        this.branchNum = branch.branchNum;
    }

    //Getters and setters

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getParkingNums() {
        return parkingNums;
    }

    public void setParkingNums(int parkingNums) {
        this.parkingNums = parkingNums;
    }

    public int getBranchNum() {
        return branchNum;
    }

    public void setBranchNum(int branchNum) {
        this.branchNum = branchNum;
    }

    @Override
    public String toString() {
        return "Branch{" +
                "address='" + address + '\'' +
                ", parkingNums=" + parkingNums +
                ", branchNum=" + branchNum +
                '}';
    }
}
