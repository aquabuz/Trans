package com.example.user.transfer_v2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

/**
 * Created by User on 2017-05-10.
 */

public class ListCountry extends AppCompatActivity {

    ListView lstSearch = null;
    private EditText edtSearch;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_country);

        lstSearch   = (ListView) findViewById(R.id.view_country);
        edtSearch   = (EditText) findViewById(R.id.edtSearch);

        adapter = new ArrayAdapter<String>(this, R.layout.listview_row, R.id.Country, ListCountryName.NameId);
        lstSearch.setAdapter(adapter);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.act_country); // Title 변경

        ListView listView = (ListView) findViewById(R.id.view_country);

        final ListCountryAdapter adapter = new ListCountryAdapter(this, ListCountryCurrency.CurrencyId, ListCountryName.NameId, ListCountryImages.ImageId);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("Currency", ListCountryCurrency.CurrencyId[position]);
                intent.putExtra("Country", ListCountryName.NameId[position]);
                intent.putExtra("Position", position);

                startActivity(intent);
            }
        });

        edtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                String searchText = s.toString();
                Log.e("=d=", searchText);
            }
        });

    }
}
