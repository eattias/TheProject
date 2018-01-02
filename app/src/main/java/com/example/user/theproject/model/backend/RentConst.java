package com.example.user.theproject.model.backend;

import android.content.ContentValues;

import com.example.user.theproject.model.entities.Branch;
import com.example.user.theproject.model.entities.Car;
import com.example.user.theproject.model.entities.CarModel;
import com.example.user.theproject.model.entities.Client;
import com.example.user.theproject.model.entities.GearBox;
import com.example.user.theproject.model.entities.Order;
import com.example.user.theproject.model.entities.TypeOfOrder;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

/**
 * Created by user on 23/11/2017.
 */

public class RentConst {

        public static class BranchConst
        {
            public static final String ADDRESS = "address";
            public static final String PARKNUM = "parkingNums";
            public static final String BRANCHNUM = "branchNum";
        }
        public static class CarConst
        {
            public static final String ASSOCBRANCH = "associetedBranch";
            public static final String MODELCODE = "modelCode";
            public static final String KMETERS = "kilometers";
            public static final String CARNUMS= "carNumber";
        }
        public static class CarModelConst
        {
            public static final String MODELCODE = "modelCode";
            public static final String COMPANYNAME = "companyName";
            public static final String MODELNAME = "modelName";
            public static final String ENGINECAPACITY= "engineCapacity";
            public static final String GEARBOX= "gearBox";
            public static final String SEATSNUM= "seatsNum";
        }
        public static class ClientConst
        {
            public static final String FAMILYNAME = "familyName";
            public static final String NAME = "name";
            public static final String ID = "_id";
            public static final String TELNUM= "telNum";
            public static final String MAIL= "mail";
            public static final String ACCOUNTNUM = "accountNum";
        }
    public static class OrderConst
    {
        public static final String CLIENT_NUM = "clientNum";
        public static final String TYPE = "type";
        public static final String CARNUM = "carNumber";
        public static final String RENTAL_BEG= "rentalBeg";
        public static final String RENTAL_END= "rentalEnd";
        public static final String KM_START_VALUE= "kmStartValue";
        public static final String KM_END_VALUE= "kmEndValue";
        public static final String FUEL_FILLED= "fuelFilled";
        public static final String AMOUNT_FUEL= "amountFuel";
        public static final String COST= "cost";
        public static final String ORDER_NUM= "orderNum";
    }



    // Class to content values

    public static ContentValues BranchToContentValues(Branch branch)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put(RentConst.BranchConst.ADDRESS,branch.getAddress());
        contentValues.put(RentConst.BranchConst.BRANCHNUM, branch.getBranchNum());
        contentValues.put(RentConst.BranchConst.PARKNUM, branch.getParkingNums());
        return contentValues;
    }

    public static ContentValues CarToContentValues(Car car)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put(RentConst.CarConst.ASSOCBRANCH,car.getAssocietedBranch());
        contentValues.put(RentConst.CarConst.MODELCODE, car.getModelCode());
        contentValues.put(RentConst.CarConst.KMETERS,car.getKilometers() );
        contentValues.put(RentConst.CarConst.CARNUMS,car.getCarNumber());

        return contentValues;
    }

    public static ContentValues CarModelToContentValues(CarModel carModel)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put(CarModelConst.COMPANYNAME,carModel.getCompanyName());
        contentValues.put(CarModelConst.ENGINECAPACITY,carModel.getEngineCapacity());
        contentValues.put(CarModelConst.GEARBOX, String.valueOf(carModel.getGearBox()));
        contentValues.put(CarModelConst.MODELCODE,carModel.getModelCode());
        contentValues.put(CarModelConst.MODELNAME,carModel.getModelName());
        contentValues.put(CarModelConst.SEATSNUM,carModel.getSeatsNum());
        return contentValues;
    }

    public static ContentValues ClientToContentValues(Client client)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ClientConst.ACCOUNTNUM,client.getAccountNum());
        contentValues.put(ClientConst.FAMILYNAME,client.getFamilyName());
        contentValues.put(ClientConst.ID,client.getId());
        contentValues.put(ClientConst.MAIL,client.getMail());
        contentValues.put(ClientConst.NAME,client.getName());
        contentValues.put(ClientConst.TELNUM,client.getTelNum());
        return contentValues;
    }

    public static ContentValues OrderToContentValues(Order order)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put(OrderConst.AMOUNT_FUEL,order.getAmountFuel());
        contentValues.put(OrderConst.CARNUM,order.getCarNumber());
        contentValues.put(OrderConst.CLIENT_NUM,order.getClientNum());
        contentValues.put(OrderConst.COST,order.getCost());
        contentValues.put(OrderConst.FUEL_FILLED,order.isFuelFilled());
        contentValues.put(OrderConst.KM_END_VALUE,order.getKmEndValue());
        contentValues.put(OrderConst.KM_START_VALUE,order.getKmStartValue());
        contentValues.put(OrderConst.ORDER_NUM,order.getOrderNum());
        contentValues.put(OrderConst.RENTAL_BEG, String.valueOf(order.getRentalBeg()));
        contentValues.put(OrderConst.RENTAL_END, String.valueOf(order.getRentalEnd()));
        contentValues.put(OrderConst.TYPE, String.valueOf(order.getType()));
        return contentValues;
    }



    // content values to class

    public static Branch ContentValuesToBranch(ContentValues contentValues) {
        Branch branch= new Branch(contentValues.getAsString(BranchConst.ADDRESS),contentValues.getAsInteger(BranchConst.PARKNUM),contentValues.getAsInteger(BranchConst.BRANCHNUM));
        return branch; }

    public static Car ContentValuesToCar(ContentValues contentValues) {
        Car car= new Car(contentValues.getAsInteger(CarConst.ASSOCBRANCH),contentValues.getAsInteger(CarConst.MODELCODE),contentValues.getAsInteger(CarConst.KMETERS),contentValues.getAsInteger(CarConst.CARNUMS));
        return car; }

    public static CarModel ContentValuesToCarModel(ContentValues contentValues) {
                CarModel carModel = new CarModel(contentValues.getAsInteger(CarModelConst.MODELCODE),contentValues.getAsString(CarModelConst.COMPANYNAME),contentValues.getAsString(CarModelConst.MODELNAME),contentValues.getAsFloat(CarModelConst.ENGINECAPACITY),GearBox.valueOf(contentValues.get(CarModelConst.GEARBOX).toString()),contentValues.getAsInteger(CarModelConst.SEATSNUM));
        return carModel; }

    public static Client ContentValuesToClient(ContentValues contentValues) {
        Client client= new Client(contentValues.getAsString(ClientConst.FAMILYNAME),contentValues.getAsString(ClientConst.NAME),contentValues.getAsInteger(ClientConst.ID),contentValues.getAsInteger(ClientConst.TELNUM),contentValues.getAsString(ClientConst.MAIL),contentValues.getAsInteger(ClientConst.ACCOUNTNUM));
        return client; }

    public static Order ContentValuesToOrder(ContentValues contentValues) throws ParseException {
       Order order= new Order(contentValues.getAsInteger(OrderConst.CLIENT_NUM),StringToTypeOfOrder(contentValues.get(OrderConst.TYPE).toString()),contentValues.getAsInteger(OrderConst.CARNUM), StringToDate(contentValues.get(OrderConst.RENTAL_BEG).toString()),StringToDate(contentValues.get(OrderConst.RENTAL_END).toString()),contentValues.getAsFloat(OrderConst.KM_START_VALUE),contentValues.getAsFloat(OrderConst.KM_END_VALUE),contentValues.getAsBoolean(OrderConst.FUEL_FILLED),contentValues.getAsInteger(OrderConst.AMOUNT_FUEL),contentValues.getAsDouble(OrderConst.COST),contentValues.getAsInteger(OrderConst.ORDER_NUM));
        return order; }

    public static TypeOfOrder StringToTypeOfOrder(String s) {
        if (s== "OPENED") return TypeOfOrder.OPENED;
        else return TypeOfOrder.CLOSED;}

    public static Date StringToDate(String s) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = formatter.parse(s);
        return date;
    }



}




