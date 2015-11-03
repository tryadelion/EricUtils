/*
 * Copyright (c) 2015.  made by CptEric.The code, comments and names are under the Creative Commons liscence.
 */

package com.software.cpteric.ericutils;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

/**
 * Created by useit on 3/11/15.
 */
public abstract class AbstractActivity extends AppCompatActivity {

    public abstract Boolean setupView();

    public abstract int layoutId();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //TODO: Implement your own! this is an example!
        /**
         *
         * EXAMPLE IMPLEMENTATION OF THE ABSTRACT ACTIVITY SYSTEM :
         *
         *
        setContentView(layoutId());

        Boolean isInnerView = setupView();
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        if (isInnerView) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        TextView text = new TextView(this);

        switch (layoutId()) {
            case R.layout.activity_review_expense:
                text.setText("Gasto");
                break;
        }
        //text.setTextColor(Color.WHITE);
        //text.setTextSize(25);
        text.setGravity(Gravity.CENTER_HORIZONTAL);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setCustomView(text);
        getSupportActionBar().setDisplayShowCustomEnabled(true);**/
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //TODO: Implement your own! this is an example!
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_splash, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //TODO: Implement your own! this is an example!
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();//go to previous screen. yeehaw.
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

