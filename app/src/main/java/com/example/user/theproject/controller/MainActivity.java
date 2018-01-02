package com.example.user.theproject.controller;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.user.theproject.R;
import com.example.user.theproject.model.datasource.List_DBManager;
import com.example.user.theproject.model.entities.Branch;
import com.example.user.theproject.model.entities.Car;
import com.example.user.theproject.model.entities.CarModel;
import com.example.user.theproject.model.entities.Client;
import com.example.user.theproject.model.entities.GearBox;
import com.example.user.theproject.model.entities.Order;
import com.example.user.theproject.model.entities.TypeOfOrder;
import com.example.user.theproject.model.backend.DB_manager;

import java.util.Date;

import static com.example.user.theproject.model.datasource.List_DBManager.branches;

public class MainActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List_DBManager lst = new List_DBManager();
        try {
            lst.init();
            findViews();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    private RelativeLayout relativeLayout;
    private ImageView imageView;
    private EditText editText;
    private EditText editText2;
    private CardView cardView;
    private TextView textView;
    private TextView textView2;
    private LinearLayout linearLayout;
    private LinearLayout linearLayout2;
    private ImageView imageView4;
    private ImageView imageView3;
    private ImageView imageView2;
    private TextView textView3;
    private CardView cardView3;
    private TextView textView4;
    private Button loginbutton;

    /**
     * Find the Views in the layout<br />
     * <br />
     * Auto-created on 2017-11-30 13:27:46 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    private void findViews() {
        loginbutton = (Button)findViewById( R.id.loginButton );
        imageView = (ImageView) findViewById(R.id.imageView);
        editText = (EditText) findViewById(R.id.editText);
        editText2 = (EditText) findViewById(R.id.editText2);
        cardView = (CardView) findViewById(R.id.cardView);
        textView = (TextView) findViewById(R.id.textView);
        textView2 = (TextView) findViewById(R.id.textView2);
        linearLayout = (LinearLayout) findViewById(R.id.linearLayout);
       relativeLayout = (RelativeLayout) findViewById(R.id.RelativeLayout);
        imageView4 = (ImageView) findViewById(R.id.imageView4);
        imageView3 = (ImageView) findViewById(R.id.imageView3);
        imageView2 = (ImageView) findViewById(R.id.imageView2);
        textView3 = (TextView) findViewById(R.id.textView3);
        cardView3 = (CardView) findViewById(R.id.cardView3);
        textView4 = (TextView) findViewById(R.id.textView4);
        loginbutton.setOnClickListener( this );
    }

    public void onClick(View v) {
        if (v == loginbutton) {
            Intent intent = new Intent(this, MainScreen.class); //go to main screen
            startActivity(intent);
        }

    }
}


