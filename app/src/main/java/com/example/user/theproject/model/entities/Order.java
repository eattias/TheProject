package com.example.user.theproject.model.entities;

import java.util.Date;

/**
 * Created by user on 09/11/2017.
 */

public class Order {
    private int clientNum;
    private TypeOfOrder type;
    private int carNumber;
    private Date rentalBeg; //The beginning of the rental
    private Date rentalEnd; //The end of the rental
    private float kmStartValue; //Kilometer start value
    private float kmEndValue; //Kilometer end value
    private boolean fuelFilled; //Was fuel filled?
    private int amountFuel; //If fuel is filled then it should be noted how many liters have been filled.
    private double cost; //Final amount for billing
    private int orderNum;

    //Constructors

    public Order(int clientNum, TypeOfOrder type,int carNumber, Date rentalBeg,
                 Date rentalEnd, float kmStartValue, float kmEndValue, boolean fuelFilled, int amountFuel, double cost, int orderNum) {
        this.clientNum = clientNum;
        this.type = type;
        this.carNumber=carNumber;
        this.rentalBeg = rentalBeg;
        this.rentalEnd = rentalEnd;
        this.kmStartValue = kmStartValue;
        this.kmEndValue = kmEndValue;
        this.fuelFilled = fuelFilled;
        this.amountFuel = amountFuel;
        this.cost = cost;
        this.orderNum = orderNum;
    }

    public Order(Order order) {
        this.clientNum = order.clientNum;
        this.type = order.type;
        this.carNumber=order.carNumber;
        this.rentalBeg = order.rentalBeg;
        this.rentalEnd = order.rentalEnd;
        this.kmStartValue = order.kmStartValue;
        this.kmEndValue = order.kmEndValue;
        this.fuelFilled = order.fuelFilled;
        this.amountFuel = order.amountFuel;
        this.cost = order.cost;
        this.orderNum = order.orderNum;
    }

    //Getters ans setters

    public int getClientNum() {
        return clientNum;
    }

    public void setClientNum(int clientNum) {
        this.clientNum = clientNum;
    }

    public TypeOfOrder getType() {
        return type;
    }

    public void setType(TypeOfOrder type) {
        this.type = type;
    }

    public int getCarNumber() { return carNumber; }

    public void setCarNumber(int carNumber) { this.carNumber = carNumber;}

    public Date getRentalBeg() {
        return rentalBeg;
    }

    public void setRentalBeg(Date rentalBeg) {
        this.rentalBeg = rentalBeg;
    }

    public Date getRentalEnd() {
        return rentalEnd;
    }

    public void setRentalEnd(Date rentalEnd) {
        this.rentalEnd = rentalEnd;
    }

    public float getKmStartValue() {
        return kmStartValue;
    }

    public void setKmStartValue(float kmStartValue) {
        this.kmStartValue = kmStartValue;
    }

    public float getKmEndValue() {
        return kmEndValue;
    }

    public void setKmEndValue(float kmEndValue) {
        this.kmEndValue = kmEndValue;
    }

    public boolean isFuelFilled() {
        return fuelFilled;
    }

    public void setFuelFilled(boolean fuelFilled) {
        this.fuelFilled = fuelFilled;
    }

    public int getAmountFuel() {
        return amountFuel;
    }

    public void setAmountFuel(int amountFuel) {
        this.amountFuel = amountFuel;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }

    @Override
    public String toString() {
        return "Order{" +
                "clientNum=" + clientNum +
                ", type=" + type +
                ", carNumber=" + carNumber +
                ", rentalBeg=" + rentalBeg +
                ", rentalEnd=" + rentalEnd +
                ", kmStartValue=" + kmStartValue +
                ", kmEndValue=" + kmEndValue +
                ", fuelFilled=" + fuelFilled +
                ", amountFuel=" + amountFuel +
                ", cost=" + cost +
                ", orderNum=" + orderNum +
                '}';
    }
}
