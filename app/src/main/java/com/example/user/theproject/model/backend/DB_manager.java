package com.example.user.theproject.model.backend;

import android.content.ContentValues;

import com.example.user.theproject.model.entities.Branch;
import com.example.user.theproject.model.entities.Car;
import com.example.user.theproject.model.entities.CarModel;
import com.example.user.theproject.model.entities.Client;

import java.util.List;

/**
 * Created by user on 16/11/2017.
 */

public interface DB_manager
{
    public boolean userExists(ContentValues c);
    public void addUser(ContentValues c) throws Exception;
    public void addModel(ContentValues c) throws Exception;
    public void addCar(ContentValues c) throws Exception;
   // public void init() throws Exception;
    public List<CarModel> listOfModels() throws Exception;
    public List<Client> listOfUsers() throws Exception;
    public List<Branch> listOfBranchs() throws Exception;
    public List<Car> listOfCars() throws Exception;


}
