package com.example.user.theproject.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.user.theproject.R;

public class MainScreen extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        findViews();
    }
    private Button userButton;
    private Button carButton;
    private Button banchButton;
    private Button modelButton;

    /**
     * Find the Views in the layout<br />
     * <br />
     * Auto-created on 2017-12-07 10:30:06 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    private void findViews() {
        userButton = (Button)findViewById( R.id.userButton );
        carButton = (Button)findViewById( R.id.carButton );
        banchButton = (Button)findViewById( R.id.banchButton );
        modelButton = (Button)findViewById( R.id.modelButton );

        userButton.setOnClickListener( this );
        carButton.setOnClickListener( this );
        banchButton.setOnClickListener( this );
        modelButton.setOnClickListener( this );
    }

    /**
     * Handle button click events<br />
     * <br />
     * Auto-created on 2017-12-07 10:30:06 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    @Override
    public void onClick(View v) {
        if ( v == userButton ) {
            userscreen();
        } else if ( v == carButton ) {
            carscreen();
        } else if ( v == banchButton ) {
            branchscreen();
        } else if ( v == modelButton ) {
            modelscreen();
        }
    }

    public void userscreen()
    {
        Intent intent = new Intent(this,UserScreen.class);
        startActivity(intent);
    }

    private void branchscreen()
    {

        Intent intent = new Intent(this,BranchScreen.class);
        startActivity(intent);
    }

    private void carscreen() {

        Intent intent = new Intent(this,CarScreen.class);
        startActivity(intent);
    }

    private void modelscreen()
    {
        Intent intent = new Intent(this,ModelScreen.class);
        startActivity(intent);
    }

}
