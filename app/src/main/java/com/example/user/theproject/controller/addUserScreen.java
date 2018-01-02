package com.example.user.theproject.controller;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.Toast;

import com.example.user.theproject.R;
import com.example.user.theproject.model.backend.DBManagerFactory;
import com.example.user.theproject.model.backend.RentConst;
import com.example.user.theproject.model.datasource.MySQL_DBManager;
import com.example.user.theproject.model.entities.Client;

public class addUserScreen extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user_screen);
        findViews();

    }

    private EditText IdEditText;
    private EditText FirstNameEditText;
    private EditText LastNameEditText;
    private EditText PhoneEditText;
    private EditText MailEditText;
    private EditText AccountNumberEditText;
    private Button addUserButton;

    /**
     * Find the Views in the layout<br />
     * <br />
     * Auto-created on 2017-11-30 12:24:17 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    private void findViews() {
        IdEditText = (EditText)findViewById( R.id.IdEditText );
        FirstNameEditText = (EditText)findViewById( R.id.FirstNameEditText );
        LastNameEditText = (EditText)findViewById( R.id.LastNameEditText );
        PhoneEditText = (EditText)findViewById( R.id.PhoneEditText );
        MailEditText = (EditText)findViewById( R.id.MailEditText );
        AccountNumberEditText = (EditText)findViewById( R.id.AccountNumberEditText );
        addUserButton = (Button)findViewById( R.id.addUserButton );
        addUserButton.setOnClickListener( this );
    }

    /**
     * Handle button click events<br />
     * <br />
     * Auto-created on 2017-11-30 12:24:17 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    @Override
    public void onClick(View v) {
        if ( v == addUserButton ) {
            if( isValid()) {
                addUser();
                clearScreen();
            }
        }
    }

    //clear the content of the fields in addUserScreen
    private void clearScreen() {
        IdEditText.setText("");
        FirstNameEditText.setText("");
        LastNameEditText.setText("");
        PhoneEditText.setText("");
        MailEditText.setText("");
        AccountNumberEditText.setText("");

    }

    //check if the data fields are valids.
    private boolean isValid() {
        boolean flag =true;
        if(TextUtils.isEmpty(this.IdEditText.getText().toString()))
        {
            IdEditText.setError("You have to enter an id.\n");
            flag=false;
        }

        if(TextUtils.isEmpty(this.FirstNameEditText.getText().toString()))
        {
            FirstNameEditText.setError("You have to enter a first name.\n");
            flag=false;
        }

        if(TextUtils.isEmpty(this.LastNameEditText.getText().toString()))
        {
            LastNameEditText.setError("You have to enter a last name.\n");
            flag=false;
        }
        if(TextUtils.isEmpty(this.PhoneEditText.getText().toString()))
        {
            PhoneEditText.setError("You have to enter a phone number.\n");
            flag=false;
        }
        if(TextUtils.isEmpty(this.MailEditText.getText().toString()))
        {
            MailEditText.setError("You have to enter a mail.\n");
            flag=false;
        }
        if(TextUtils.isEmpty(this.AccountNumberEditText.getText().toString()))
        {
            AccountNumberEditText.setError("You have to enter an account number.\n");
            flag=false;
        }

        //the id has to have 9 numbers
        if(Integer.parseInt(this.IdEditText.getText().toString())> 999999999 ||Integer.parseInt(this.IdEditText.getText().toString())< 100000000)
        {
            flag=false;
            IdEditText.setError("The id is not valid.");
        }
        return flag;
    }


    private void addUser() {
        final ContentValues contentValues = new ContentValues();
        try {
            //get all the datas in the fields and put them in a content value
            int id = Integer.valueOf(this.IdEditText.getText().toString());
            contentValues.put(RentConst.ClientConst.ID, id);
            contentValues.put(RentConst.ClientConst.NAME, this.FirstNameEditText.getText().toString());
            contentValues.put(RentConst.ClientConst.FAMILYNAME, this.LastNameEditText.getText().toString());
            int telnum = Integer.valueOf(this.PhoneEditText.getText().toString());
            contentValues.put(RentConst.ClientConst.TELNUM, telnum);
            contentValues.put(RentConst.ClientConst.MAIL, this.MailEditText.getText().toString());
            int accnum = Integer.valueOf(this.AccountNumberEditText.getText().toString());
            contentValues.put(RentConst.ClientConst.ACCOUNTNUM, accnum);
        //    DBManagerFactory.getInstance().addUser(contentValues);


            new AsyncTask<Void, Void, Void>()
            {
                protected Void doInBackground(Void... params){

                    try {
                        DBManagerFactory.getInstance().addUser(contentValues);// add the content value
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return null;
                }
            }.execute();
//if we didnt succeed to add the client its throw an alert dialog
        } catch (Exception e) {
            AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);

            dlgAlert.setMessage(e.getMessage());
            dlgAlert.setTitle("ERROR");
            dlgAlert.setPositiveButton("OK", null);
            dlgAlert.setCancelable(true);
            dlgAlert.create().show();

            dlgAlert.setPositiveButton("Ok",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {}  });     }



    }

}
