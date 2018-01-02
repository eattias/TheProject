package com.example.user.theproject.controller;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.theproject.R;
import com.example.user.theproject.model.backend.DBManagerFactory;
import com.example.user.theproject.model.backend.DB_manager;
import com.example.user.theproject.model.datasource.List_DBManager;
import com.example.user.theproject.model.entities.Branch;

import java.util.ArrayList;
import java.util.List;

public class BranchScreen extends AppCompatActivity  {

    private List<Branch> branches;
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
     * Au8to-created on 2017-12-07 12:08:52 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
   private void findViews() throws Exception {

       new AsyncTask<Void, Void, Void>() {

           @Override
           protected Void doInBackground(Void... params) {
               try {
                   branches = DBManagerFactory.getInstance().listOfBranchs(); //get all the branches from the database
               } catch (Exception e) {
                   e.printStackTrace();
               }
               return null;
           }

           @Override
           protected void onPostExecute(Void aVoid) {
               super.onPostExecute(aVoid);
               if (branches != null) {

                   textView = (TextView) findViewById(R.id.textView);
                   textView.setText(branches.toString(), TextView.BufferType.EDITABLE); //print all the branches in a textview
               }
           }
       }.execute();

   }
}



