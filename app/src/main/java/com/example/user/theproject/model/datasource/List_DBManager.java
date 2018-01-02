package com.example.user.theproject.model.datasource;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

import com.example.user.theproject.model.backend.DB_manager;
import com.example.user.theproject.model.entities.Branch;
import com.example.user.theproject.model.entities.Car;
import com.example.user.theproject.model.entities.CarModel;
import com.example.user.theproject.model.entities.Client;
import com.example.user.theproject.model.entities.GearBox;
import com.example.user.theproject.model.entities.Order;
import com.example.user.theproject.model.entities.TypeOfOrder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.example.user.theproject.model.backend.RentConst.CarModelToContentValues;
import static com.example.user.theproject.model.backend.RentConst.CarToContentValues;
import static com.example.user.theproject.model.backend.RentConst.ClientToContentValues;
import static com.example.user.theproject.model.backend.RentConst.ContentValuesToCar;
import static com.example.user.theproject.model.backend.RentConst.ContentValuesToCarModel;
import static com.example.user.theproject.model.backend.RentConst.ContentValuesToClient;

/**
 * Created by user on 16/11/2017.
 */

public class List_DBManager implements DB_manager
{


     public static List<Branch> branches;
     public static List<CarModel> models;
     public static List<Car> cars;
     public static List<Client> clients;
     public static List<Order> orders;

    static {
        branches= new ArrayList<>();
        models=new ArrayList<>();
        cars=new ArrayList<>();
        clients=new ArrayList<>();
        orders=new ArrayList<>();
    }

    @Override
    public boolean userExists(ContentValues c)
    {
        Client cl=ContentValuesToClient(c);
        for ( Client item : clients)
            if (cl.getId() == item.getId())
                return true;
        return false;

    }

    @Override
    public void addUser(ContentValues c) throws Exception {
        Client cl=ContentValuesToClient(c);
        if (userExists(c))
                throw new Exception("This client already exists!");
        else
          clients.add(cl);


    }

    @Override
    public void addModel(ContentValues c) throws Exception {
        CarModel cm= ContentValuesToCarModel(c);
        for ( CarModel item : models)
            if (item.equals(cm))
                throw new Exception("This model already exists!");
        models.add(cm);
    }

    @Override
    public void addCar( ContentValues c) throws Exception
    {
        Car car= ContentValuesToCar(c);
        for ( Car item : cars)
            if (item.equals(car))
                throw new Exception("This car already exists!");
        cars.add(car);
    }

    @Override
    public List<CarModel> listOfModels() throws Exception {
        if (models.size() != 0)
            return models;
        else
            throw new Exception("The list of car models is empty!");
    }

    @Override
    public List<Client> listOfUsers() throws Exception {
        if (clients.size() != 0)
            return clients;
        else
            throw new Exception("The list of clients is empty!");
    }

    @Override
    public List<Branch> listOfBranchs() throws Exception {
        if (branches.size() != 0)
            return branches;
        else
            throw new Exception("The list of branches is empty!");
    }

    @Override
    public List<Car> listOfCars() throws Exception {
        if (cars.size() != 0)
            return cars;
        else
            throw new Exception("The list of cars is empty!");
    }

    public void init() throws Exception {

        Branch b1 = new Branch("Ben Gourion Airport", 100, 123);
        Branch b2 = new Branch("Tel Aviv Hayarkon", 200, 345);
        Branch b3 = new Branch("Jerusalem King David", 50, 678);

        CarModel cm1 = new CarModel(208, "Peugeot", "THP 165 S&S GT LINE 5P", 1598, GearBox.MANUAL, 5);
        CarModel cm2 = new CarModel(147, "Citroen", "BLUEHDI 120 S&S FEEL EAT6", 1560, GearBox.AUTOMATIC, 5);
        CarModel cm3 = new CarModel(60, "Volkswagen", "MATCH 5P", 999, GearBox.MANUAL, 5);

        Car c1 = new Car(123, 208, 218, 123456);
        Car c2 = new Car(345, 147, 250, 147852);
        Car c3 = new Car(678, 60, 200, 258963);

        Client cl1 = new Client("Attias", "Eden Esther", 340880590, 536285128, "attias.eden@gmail.com", 369852);
        Client cl2 = new Client("Ittah", "Ora", 336113923, 586485868, "o.ittah@gmail.com", 123456);
        Client cl3 = new Client("Cohen", "David", 345678912, 547859668, "dadou.cohen@gmail.com", 478952);

        Order o1 = new Order(340880590, TypeOfOrder.CLOSED, 123456, new Date(2018, 05, 18), new Date(2018, 06, 18), 145, 200, true, 26, 4000, 14);
        Order o2 = new Order(336113923, TypeOfOrder.OPENED, 147852, new Date(2017, 06, 18), new Date(2017, 06, 28), 0, 100, true, 50, 1500, 56);
        Order o3 = new Order(345678912, TypeOfOrder.CLOSED, 258963, new Date(2018, 02, 19), new Date(2018, 02, 25), 20, 40, false, 0, 600, 89);

        addUser(ClientToContentValues(cl1));
        addUser(ClientToContentValues(cl2));
        addUser(ClientToContentValues(cl3));


        addModel(CarModelToContentValues(cm1));
        addModel(CarModelToContentValues(cm2));
        addModel(CarModelToContentValues(cm3));


        addCar(CarToContentValues(c1));
        addCar(CarToContentValues(c2));
        addCar(CarToContentValues(c3));

        branches.add(b1);
        branches.add(b2);
        branches.add(b3);
    }
}
