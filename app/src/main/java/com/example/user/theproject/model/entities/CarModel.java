package com.example.user.theproject.model.entities;

/**
 * Created by user on 09/11/2017.
 */

public class CarModel {
    private int modelCode;
    private String companyName;
    private String modelName;
    private float engineCapacity; // volume du moteur
    private GearBox gearBox; // boite a vitesse
    private int seatsNum;

    // Constructors

    public CarModel(int modelCode, String companyName, String modelName,
                    float engineCapacity, GearBox gearBox, int seatsNum) {
        this.modelCode = modelCode;
        this.companyName = companyName;
        this.modelName = modelName;
        this.engineCapacity = engineCapacity;
        this.gearBox = gearBox;
        this.seatsNum = seatsNum;
    }

    public CarModel(CarModel model) {
        this.modelCode = model.modelCode;
        this.companyName = model.companyName;
        this.modelName = model.modelName;
        this.engineCapacity = model.engineCapacity;
        this.gearBox = model.gearBox;
        this.seatsNum = model.seatsNum;
    }

    // Getters and setters

    public int getModelCode() {
        return modelCode;
    }

    public void setModelCode(int modelCode) {
        this.modelCode = modelCode;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public float getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(float engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public GearBox getGearBox() {
        return gearBox;
    }

    public void setGearBox(GearBox gearBox) {
        this.gearBox = gearBox;
    }

    public int getSeatsNum() {
        return seatsNum;
    }

    public void setSeatsNum(int seatsNum) {
        this.seatsNum = seatsNum;
    }

    @Override
    public String toString()
    {
        return "CarModel{" +
                "modelCode=" + modelCode +
                ", companyName='" + companyName + '\'' +
                ", modelName='" + modelName + '\'' +
                ", engineCapacity=" + engineCapacity +
                ", gearBox=" + gearBox +
                ", seatsNum=" + seatsNum +
                '}';


    }
}
