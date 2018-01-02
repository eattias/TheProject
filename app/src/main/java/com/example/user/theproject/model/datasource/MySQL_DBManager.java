package com.example.user.theproject.model.datasource;

import android.content.ContentValues;
import android.database.MatrixCursor;
import android.os.AsyncTask;
import android.util.Log;

import com.example.user.theproject.model.backend.DB_manager;
import com.example.user.theproject.model.backend.PHPtools;
import com.example.user.theproject.model.backend.RentConst;
import com.example.user.theproject.model.entities.Branch;
import com.example.user.theproject.model.entities.Car;
import com.example.user.theproject.model.entities.CarModel;
import com.example.user.theproject.model.entities.Client;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by user on 14/12/2017.
 */

public class MySQL_DBManager implements DB_manager {

    private String WEB_URL = "http://oittah.vlab.jct.ac.il";

    private boolean updateFlag = false;

    @Override
    public boolean userExists(ContentValues c) {
        return false;
    }

    public void printLog(String message)
    {
        Log.d(this.getClass().getName(),"\n"+message);
    }

    public void printLog(Exception message)
    {
        Log.d(this.getClass().getName(),"Exception-->\n"+message);
    }

    @Override
    public void addUser(ContentValues values) throws Exception {

        try {
            String result = PHPtools.POST(WEB_URL + "/addUser.php", values); //send to POST the url which add the user to the DB
            long id = Long.parseLong(result);
            printLog("addUser:\n" + result);

        } catch (IOException e) {
            printLog("addUser Exception:\n" + e);

        }

    }

    @Override
    public void addModel(ContentValues c) throws Exception {
        try {
            String result = PHPtools.POST(WEB_URL + "/addModel.php", c);//send to POST the url which add the model to the DB
            long id = Long.parseLong(result);
            printLog("addModel:\n" + result);

        } catch (IOException e) {
            printLog("addModel Exception:\n" + e);

        }

    }

    @Override
    public void addCar(ContentValues c) throws Exception {

        try {
            String result = PHPtools.POST(WEB_URL + "/addCar.php", c); //send to POST the url which add the car to the DB
            long id = Long.parseLong(result);
            printLog("addCar:\n" + result);

        } catch (IOException e) {
            printLog("addCar Exception:\n" + e);

        }

    }

    @Override
    public List<CarModel> listOfModels() throws Exception { //get all the carModel to a list

        List<CarModel> result = new ArrayList<CarModel>();
        try {
            String str = PHPtools.GET(WEB_URL + "/listCarModel.php"); // call to GET function
            JSONArray array = new JSONObject(str).getJSONArray("models"); // get the models list thanks to GET
            for (int i = 0; i < array.length(); i++) { //for every jsonObject
                JSONObject jsonObject = array.getJSONObject(i);
                ContentValues contentValues = PHPtools.JsonModelToContentValues(jsonObject); //convert the Json to ContentValue
                CarModel carModel = RentConst.ContentValuesToCarModel(contentValues); //convert ContentValue to Carmodel
                result.add(carModel); //add the carModel to the list result
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;


    }

    @Override
    public List<Client> listOfUsers() throws Exception { //get all the users to a list
       List<Client> result = new ArrayList<Client>();
        try {
            String str = PHPtools.GET(WEB_URL + "/listUser.php");// call to GET function
            JSONArray array = new JSONObject(str).getJSONArray("users"); // get the users list thanks to GET
            for (int i = 0; i < array.length(); i++) { //for every jsonObject
                 JSONObject jsonObject = array.getJSONObject(i);
               ContentValues contentValues = PHPtools.JsonUserToContentValues(jsonObject);  //convert the Json to ContentValue
                Client client = RentConst.ContentValuesToClient(contentValues);//convert ContentValue to client
                result.add(client); //add the client to the list result
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;


    }

    @Override
    public List<Branch> listOfBranchs() throws Exception {//get all the branches to a list
        List<Branch> result = new ArrayList<Branch>();
        try {
            String str = PHPtools.GET(WEB_URL + "/listBranch.php");// call to GET function
            JSONArray array = new JSONObject(str).getJSONArray("branches"); // get the branches list thanks to GET
            for (int i = 0; i < array.length(); i++) { //for every jsonObject
                JSONObject jsonObject = array.getJSONObject(i);
                ContentValues contentValues = PHPtools.JsonBranchToContentValues(jsonObject); //convert the Json to ContentValue
                Branch branch = RentConst.ContentValuesToBranch(contentValues);//convert ContentValue to branch
                result.add(branch);//add the branch to the list result
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public List<Car> listOfCars() throws Exception { // get all the cars to a list
        List<Car> result = new ArrayList<Car>();
        try {
            String str = PHPtools.GET(WEB_URL + "/listCar.php"); // call to GET function
            JSONArray array = new JSONObject(str).getJSONArray("cars"); //get the cars list thanks to GET
            for (int i = 0; i < array.length(); i++) { //for every JsonObject
                JSONObject jsonObject = array.getJSONObject(i);
                ContentValues contentValues = PHPtools.JsonCarToContentValues(jsonObject); //convert the Json to ContentValue
                Car car = RentConst.ContentValuesToCar(contentValues); //convert ContentValue to car
                result.add(car); //add the car to the list result
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }
}
