package com.example.user.theproject.model.entities;

/**
 * Created by user on 09/11/2017.
 */

public class Client {
    private String familyName;
    private String name;
    private int id;
    private int telNum;
    private String mail;
    private int accountNum; // cartis ashray

    //constructors

    public Client(String familyName, String name, int id, int telNum, String mail, int accountNum) {
        this.familyName = familyName;
        this.name = name;
        this.id = id;
        this.telNum = telNum;
        this.mail = mail;
        this.accountNum = accountNum;
    }

    public Client(Client client) {
        this.familyName = client.familyName;
        this.name = client.name;
        this.id = client.id;
        this.telNum = client.telNum;
        this.mail= client.mail;
        this.accountNum = client.accountNum;
    }

    // Getters and setters

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public int getTelNum() {
        return telNum;
    }

    public void setTelNum(int telNum) {
        this.telNum = telNum;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(int accountNum) {
        this.accountNum = accountNum;
    }

    @Override
    public String toString() {
        return "Client{" +
                "familyName='" + familyName + '\'' +
                ", name='" + name + '\'' +
                ", id=" + id +
                ", telNum=" + telNum +
                ", mail='" + mail + '\'' +
                ", accountNum=" + accountNum +
                '}';
    }
}
