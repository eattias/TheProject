package com.example.user.theproject.controller;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.user.theproject.R;
import com.example.user.theproject.model.backend.DBManagerFactory;
import com.example.user.theproject.model.datasource.List_DBManager;
import com.example.user.theproject.model.entities.Car;

import java.util.List;

public class listCarsScreen extends AppCompatActivity {

    private List<Car> cars;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_cars_screen);
        try {
            findViews();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private TextView textView;

    /**
     * Find the Views in the layout<br />
     * <br />
     * Auto-created on 2017-12-07 12:08:52 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    private void findViews() throws Exception {
        new AsyncTask<Void, Void, Void>() {

            @Override
            protected Void doInBackground(Void... params) {
                try {
                    cars = DBManagerFactory.getInstance().listOfCars(); //get the list of cars from DB
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                if (cars != null) {
                    textView = (TextView) findViewById(R.id.textView);
                    textView.setText(cars.toString(), TextView.BufferType.EDITABLE); //print all the cras
               }
            }
        }.execute();
    }

}
