package com.example.user.theproject.controller;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.example.user.theproject.R;
import com.example.user.theproject.model.backend.DBManagerFactory;
import com.example.user.theproject.model.datasource.List_DBManager;
import com.example.user.theproject.model.datasource.MySQL_DBManager;
import com.example.user.theproject.model.entities.Client;

import java.util.List;

public class listUsersScreen extends AppCompatActivity {
    private List<Client> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_branch_screen);
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
                    users = DBManagerFactory.getInstance().listOfUsers(); //get all the clients(users) from DB
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                if (users != null) {
                    textView = (TextView) findViewById(R.id.textView);
                    textView.setText(users.toString(), TextView.BufferType.EDITABLE); //print all the clients in a textview
                }
            }
        }.execute();
    }

}
