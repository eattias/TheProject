package com.example.user.theproject.controller;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.theproject.R;
import com.example.user.theproject.model.backend.DBManagerFactory;
import com.example.user.theproject.model.backend.RentConst;
import com.example.user.theproject.model.datasource.List_DBManager;
import com.example.user.theproject.model.entities.Branch;
import com.example.user.theproject.model.entities.CarModel;
import com.example.user.theproject.model.entities.GearBox;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import static com.example.user.theproject.R.id.addUserButton;
import static com.example.user.theproject.model.backend.DBManagerFactory.*;
import static com.example.user.theproject.model.datasource.List_DBManager.*;

public class addCarScreen extends AppCompatActivity implements View.OnClickListener {
    private List<Branch> branches;
    private List<CarModel> models;
    ArrayAdapter<Integer> adapter1;
    ArrayAdapter<Integer> adapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_car_screen);
        try {
            findViews();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        private Spinner AssociatedBranchSpinner;
        private Spinner modelCodeSpinner;
        private EditText kilometersEditText;
        private EditText carNumEditText;
        private Button addCarButton;

        /**
         * Find the Views in the layout<br />
         * <br />
         * Auto-created on 2017-11-30 14:10:18 by Android Layout Finder
         * (http://www.buzzingandroid.com/tools/android-layout-finder)
         */
        private void findViews() throws Exception {
            AssociatedBranchSpinner = (Spinner) findViewById(R.id.AssociatedBranchSpinner);
            modelCodeSpinner = (Spinner) findViewById(R.id.modelCodeSpinner);
            kilometersEditText = (EditText) findViewById(R.id.kilometersEditText);
            carNumEditText = (EditText) findViewById(R.id.carNumEditText);
            addCarButton = (Button) findViewById(R.id.addCarButton);
            addCarButton.setOnClickListener(this);

            //enter into the list the values of AssociatedBranchSpinner
            new AsyncTask<Void, Void, Void>() {

                @Override
                protected Void doInBackground(Void... params) {
                    try {
                        branches = DBManagerFactory.getInstance().listOfBranchs(); // get all the  branches
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return null;
                }

                @Override
                protected void onPostExecute(Void aVoid) {
                    super.onPostExecute(aVoid);
                    if (branches != null) {
                        List<Integer> listbranchesNum = new ArrayList<>();
                        for (Iterator<Branch> iter = branches.iterator(); iter.hasNext(); ) {
                            Branch item = iter.next();
                            listbranchesNum.add(item.getBranchNum());// add the branchnum of every branch to listbranchesNum
                            adapter1= new ArrayAdapter<Integer>(addCarScreen.this, android.R.layout.simple_spinner_dropdown_item, listbranchesNum);
                            AssociatedBranchSpinner.setAdapter(adapter1);
                        }
                    }
                }}. execute();



            //enter into the list the values of modelCodeSpinner
            new AsyncTask<Void, Void, Void>() {

                @Override
                protected Void doInBackground(Void... params) {
                    try {
                        models = DBManagerFactory.getInstance().listOfModels(); //get all the models
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return null;
                }

                @Override
                protected void onPostExecute(Void aVoid) {
                    super.onPostExecute(aVoid);
                    if (models != null) {
                        List<Integer> listmodelsCode = new ArrayList<>();
                        for (Iterator<CarModel> iter = models.iterator(); iter.hasNext(); ) {
                           CarModel item = iter.next();
                            listmodelsCode.add(item.getModelCode()); //add to listmodelsCode all the model codes
                            adapter2= new ArrayAdapter<Integer>(addCarScreen.this, android.R.layout.simple_spinner_dropdown_item, listmodelsCode);
                            modelCodeSpinner.setAdapter(adapter2);
                        }
                    }
                }}. execute();}



        @Override
        public void onClick ( View v)
            {
                if (v == addCarButton)
                {
                    if( isValid()) {
                        addCar();
                        clearScreen();
                    }
                }
            }

    //function that clear all the field of addCarScreen
    private void clearScreen() {
        kilometersEditText.setText("");
        carNumEditText.setText("");

    }

   //function that verifies if all the datas entered by the user are valid.
    private boolean isValid() {
        boolean flag =true;

        if(TextUtils.isEmpty(this.kilometersEditText.getText().toString()))
        {
            kilometersEditText.setError("You have to enter a first name.\n");
            flag=false;
        }

        if(TextUtils.isEmpty(this.carNumEditText.getText().toString()))
        {
            carNumEditText.setError("You have to enter a last name.\n");
            flag=false;
        }

        return flag;
    }


    private void addCar() {

        final ContentValues contentValues = new ContentValues();
      try {
          //enter all the input datas in the contentvalues
            int assocbranch = Integer.valueOf(this.AssociatedBranchSpinner.getSelectedItem().toString());
            contentValues.put(RentConst.CarConst.ASSOCBRANCH, assocbranch);
            int modelcode = Integer.valueOf(this.modelCodeSpinner.getSelectedItem().toString());
            contentValues.put(RentConst.CarConst.MODELCODE,modelcode );
            int kilometers =Integer.valueOf(this.kilometersEditText.getText().toString());
            contentValues.put(RentConst.CarConst.KMETERS, kilometers);
            int carNumber = Integer.valueOf(this.carNumEditText.getText().toString());
            contentValues.put(RentConst.CarConst.CARNUMS, carNumber);
          //  DBManagerFactory.getInstance().addCar(contentValues);

          new AsyncTask<Void, Void, Void>()
          {
              protected Void doInBackground(Void... params){

                  try {
                      getInstance().addCar(contentValues); //add the content value
                  } catch (Exception e) {
                      e.printStackTrace();
                  }
                  return null;
              }
          }.execute();

      } catch (Exception e) {     }


    }
}
