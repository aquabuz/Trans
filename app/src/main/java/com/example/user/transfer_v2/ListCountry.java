package com.example.user.transfer_v2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

/**
 * Created by User on 2017-05-10.
 */

public class ListCountry extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_country);

        ListView listView = (ListView) findViewById(R.id.listview);

        ListCountryAdapter adapter = new ListCountryAdapter(this, ListCountryCurrency.CurrencyId, ListCountryName.NameId, ListCountryImages.ImageId);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent =new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("Currency", ListCountryCurrency.CurrencyId[position -1]);
                intent.putExtra("Country", ListCountryName.NameId[position -1]);
                intent.putExtra("Position", position -1);

                startActivity(intent);
            }
        });

    }
}
