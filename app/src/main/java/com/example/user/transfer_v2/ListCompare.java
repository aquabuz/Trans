package com.example.user.transfer_v2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

/**
 * Created by User on 2017-05-10.
 */

public class ListCompare extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_country);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);//Back Button
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        getSupportActionBar().setTitle(R.string.act_compare); // Title 변경

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if ( item.getItemId() == android.R.id.home ) {
            onBackPressed();
            return true;// ActionBar Back Button
        }
        return false;
    }

}
