package com.example.user.theproject.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.user.theproject.R;

public class ModelScreen extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_model_screen);
        findViews();
    }

    private Button addmodelButton;
    private Button listmodelsButton;

    /**
     * Find the Views in the layout<br />
     * <br />
     * Auto-created on 2017-12-07 14:27:44 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    private void findViews() {
        addmodelButton = (Button)findViewById( R.id.addmodelButton );
        listmodelsButton = (Button)findViewById( R.id.listmodelsButton );

        addmodelButton.setOnClickListener(this);
        listmodelsButton.setOnClickListener( this );
    }

    /**
     * Handle button click events<br />
     * <br />
     * Auto-created on 2017-12-07 14:27:44 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    @Override
    public void onClick(View v) {
        if ( v == addmodelButton ) {
            addmodel();

         } else if ( v == listmodelsButton ) {
           showmodels();
         }
    }


    private void addmodel() { //go to addModelscreen
        Intent intent = new Intent(this,addModel.class);
        startActivity(intent);
    }

    private void showmodels() { //go to list models screen
        Intent intent = new Intent(this,listModels.class);
        startActivity(intent);
    }
}
