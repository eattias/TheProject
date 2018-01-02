package com.example.user.theproject.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.user.theproject.R;

public class UserScreen extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_screen);
        findViews();
    }

    private Button addUserButton;
    private Button listUsersButton;

    /**
     * Find the Views in the layout<br />
     * <br />
     * Auto-created on 2017-11-30 10:31:40 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    private void findViews() {
        addUserButton = (Button)findViewById( R.id.addUserButton );
        listUsersButton = (Button)findViewById( R.id.listOfUsersButton);

        addUserButton.setOnClickListener(this);
        listUsersButton.setOnClickListener( this );
    }

    /**
     * Handle button click events<br />
     * <br />
     * Auto-created on 2017-11-30 10:31:40 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    @Override
    public void onClick(View v) {
        if ( v == addUserButton ) {
            addUserScreen();
        } else if ( v == listUsersButton ) {
            listUsersScreen ();
        }
    }

    private void listUsersScreen() { //go to usersscreen
        Intent intent = new Intent(this,listUsersScreen.class);
        startActivity(intent);
    }

    private void addUserScreen() { //go to addUserscreen
        Intent intent = new Intent(this,addUserScreen.class);
        startActivity(intent);
    }

}
