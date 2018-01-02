package com.example.user.theproject.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.user.theproject.R;

public class CarScreen extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_screen);
        findViews();
    }

    private Button addCarButton;
    private Button listOfCarsButton;

    /**
     * Find the Views in the layout<br />
     * <br />
     * Auto-created on 2017-11-30 10:43:25 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    private void findViews() {
        addCarButton = (Button)findViewById( R.id.addCarButton );
        listOfCarsButton = (Button)findViewById( R.id.listOfCarsButton );

        addCarButton.setOnClickListener( this );
        listOfCarsButton.setOnClickListener( this );
    }

    /**
     * Handle button click events<br />
     * <br />
     * Auto-created on 2017-11-30 10:43:25 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    @Override
    public void onClick(View v) {
        if ( v == addCarButton ) {
          addcarScreen();
        } else if ( v == listOfCarsButton ) {
            listCarsScreen();
        }
    }

    //go to addcarscreen
    private void addcarScreen() {
        Intent intent = new Intent(this,addCarScreen.class);
        startActivity(intent);
    }

    //goto listcarssrcreen
    private void listCarsScreen() {
        Intent intent = new Intent(this,listCarsScreen.class);
        startActivity(intent);
    }

}
