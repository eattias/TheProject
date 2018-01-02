package com.example.user.theproject.controller;

import android.content.ContentValues;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.user.theproject.R;
import com.example.user.theproject.model.backend.DBManagerFactory;
import com.example.user.theproject.model.backend.RentConst;
import com.example.user.theproject.model.datasource.List_DBManager;
import com.example.user.theproject.model.entities.CarModel;
import com.example.user.theproject.model.entities.GearBox;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class addModel extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_model);
        try {
            findViews();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private EditText modelcodeTextView;
    private EditText companyNametextView;
    private EditText modelNameTextView;
    private EditText engineCapacitytextView;
    private Spinner gearBoxSpinner;
    private EditText seatsNumTextView;
    private Button addmodelButton;

    /**
     * Find the Views in the layout<br />
     * <br />
     * Auto-created on 2017-12-07 14:31:52 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    private void findViews() throws Exception {
        modelcodeTextView = (EditText)findViewById( R.id.modelcodeTextView );
        companyNametextView = (EditText)findViewById( R.id.companyNametextView );
        modelNameTextView = (EditText)findViewById( R.id.modelNameTextView );
        engineCapacitytextView = (EditText)findViewById( R.id.engineCapacitytextView );
        gearBoxSpinner = (Spinner)findViewById( R.id.gearBoxSpinner );
        seatsNumTextView = (EditText)findViewById( R.id.seatsNumTextView );
        addmodelButton = (Button)findViewById( R.id.addmodelButton );
        addmodelButton.setOnClickListener( this );
        ArrayAdapter<GearBox> adapter = new ArrayAdapter<GearBox> (this,android.R.layout.simple_spinner_dropdown_item,GearBox.values());
        gearBoxSpinner.setAdapter(adapter);
    }

    /**
     * Handle button click events<br />
     * <br />
     * Auto-created on 2017-12-07 14:31:52 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    @Override
    public void onClick(View v) {
        if ( v == addmodelButton ) {
            if( isValid()) {
                addmodel();
                clearScreen();
            }
        }
    }

    //clear the screen after the user cliks on the addmodelButton
    private void clearScreen() {
        modelcodeTextView.setText("");
        companyNametextView.setText("");
        modelNameTextView.setText("");
        engineCapacitytextView.setText("");
        seatsNumTextView.setText("");
    }

    //verify if all the datas are valid
    private boolean isValid() {
        boolean flag =true;
        if(TextUtils.isEmpty(this.modelcodeTextView.getText().toString()))
        {
            modelcodeTextView.setError("You have to enter the model code.\n");
            flag=false;
        }

        if(TextUtils.isEmpty(this.companyNametextView.getText().toString()))
        {
            companyNametextView.setError("You have to enter the company name of the model.\n");
            flag=false;
        }

        if(TextUtils.isEmpty(this.engineCapacitytextView.getText().toString()))
        {
            engineCapacitytextView.setError("You have to enter the capacity of the engine.\n");
            flag=false;
        }
        if(TextUtils.isEmpty(this.modelNameTextView.getText().toString()))
        {
            modelNameTextView.setError("You have to enter a model name.\n");
            flag=false;
        }
        if(TextUtils.isEmpty(this.seatsNumTextView.getText().toString()))
        {
            seatsNumTextView.setError("You have to enter the number of seats of the model.\n");
            flag=false;
        }
        return flag;
    }



    private void addmodel() {
        final ContentValues contentValues = new ContentValues();
        try {

            //get all the datas and put them in a content value
            int modelcode = Integer.valueOf(this.modelcodeTextView.getText().toString());
            contentValues.put(RentConst.CarModelConst.MODELCODE,modelcode);
            contentValues.put(RentConst.CarModelConst.COMPANYNAME, this.companyNametextView.getText().toString());
            contentValues.put(RentConst.CarModelConst.MODELNAME, this.modelNameTextView.getText().toString());
            int seatsnum = Integer.valueOf(this.seatsNumTextView.getText().toString());
            contentValues.put(RentConst.CarModelConst.SEATSNUM, seatsnum);
            float enginecapacity = Float.valueOf(this.engineCapacitytextView.getText().toString());
            contentValues.put(RentConst.CarModelConst.ENGINECAPACITY, enginecapacity);
            contentValues.put(RentConst.CarModelConst.GEARBOX,this.gearBoxSpinner.getSelectedItem().toString());
       //     DBManagerFactory.getInstance().addModel(contentValues);


          new AsyncTask<Void, Void, Void>()
          {
                protected Void doInBackground(Void... params){

                    try {
                        DBManagerFactory.getInstance().addModel(contentValues); // add the content value
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return null;
                                }
              }.execute();

        } catch (Exception e) {     }
    }

}
