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
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by User on 2017-05-10.
 */

public class ListCountry extends AppCompatActivity {

    ListView lstSearch = null;
    private EditText edtSearch;
    private ListCountryAdapter adapterSearch;

    private ArrayList<CountryModels>    m_ModelsArray = null;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_country);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.act_country); // Title 변경


        m_ModelsArray = new ArrayList<CountryModels>(); // 초기 리스트

        for(int index = 0; index <ListCountryName.NameId.length; index++ ) {

            CountryModels models = new CountryModels();

            models.setCountryName(ListCountryName.NameId[index]);
            models.setCountryCurremcy(ListCountryCurrency.CurrencyId[index]);
            models.setImageId(ListCountryImages.ImageId[index]);

            m_ModelsArray.add(models);
        }


        ListView listView = (ListView) findViewById(R.id.view_country);

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

        lstSearch   = (ListView) findViewById(R.id.view_country);
        edtSearch   = (EditText) findViewById(R.id.edtSearch);

        adapterSearch = new ListCountryAdapter(this, R.layout.listview_row);
        adapterSearch.setData(m_ModelsArray);
        lstSearch.setAdapter(adapterSearch);

        edtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                adapterSearch.getFilter().filter(s);

                if(s.length() == 0) { // 입력값 초기화
                    Log.e("debug","Reset");
                    adapterSearch.setData(m_ModelsArray);
                    adapterSearch.notifyDataSetChanged();
                }

            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

    }
}
