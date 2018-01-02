package com.example.user.theproject.model.entities;

/**
 * Created by user on 09/11/2017.
 */

public class Car {
    private int associetedBranch; //The number of the branch where the car is parked regularly
    private  int modelCode;
    private int kilometers;
    private int carNumber;

    //constructors

    public Car(int associetedBranch, int modelCode,
               int kilometers, int carNumber) {
        this.associetedBranch = associetedBranch;
        this.modelCode = modelCode;
        this.kilometers = kilometers;
        this.carNumber = carNumber;
    }
    public Car( Car car) {
        this.associetedBranch = car.associetedBranch;
        this.modelCode = car.modelCode;
        this.kilometers = car.kilometers;
        this.carNumber = car.carNumber;
    }

    // Getters and setters

    public int getAssocietedBranch() {
        return associetedBranch;
    }

    public void setAssocietedBranch(int associetedBranch) {
        this.associetedBranch = associetedBranch;
    }

    public int getModelCode() {
        return modelCode;
    }

    public void setModelCode(int modelCode) {
        this.modelCode = modelCode;
    }

    public float getKilometers() {
        return kilometers;
    }

    public void setKilometers(int kilometers) {
        this.kilometers = kilometers;
    }

    public int getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(int carNumber) {
        this.carNumber = carNumber;
    }

    @Override
    public String toString() {
        return "Car{" +
                "associetedBranch=" + associetedBranch +
                ", modelCode=" + modelCode +
                ", kilometers=" + kilometers +
                ", carNumber=" + carNumber +
                '}';
    }
}
