package com.example.user.transfer_v2;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by User on 2017-05-15.
 */

public class ListCountryAdapter extends BaseAdapter {

    private LayoutInflater  m_Layout            = null;
    private Context         m_Context           = null;
    private String[]        m_CountryCurrency    = null;
    private String[]        m_CountryName       = null;
    private int[]           m_Images           = null;

    public ListCountryAdapter(Context context, String[] CountryCurrency, String[] CountryName, int[] Images) {

        m_Layout            = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        m_Context           = context;
        m_CountryCurrency   = CountryCurrency;
        m_CountryName       = CountryName;
        m_Images            = Images;

    }

    @Override
    public int getCount() {
        return m_CountryCurrency.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = m_Layout.inflate(R.layout.listview_row, parent, false);

        TextView Currncy    = (TextView) convertView.findViewById(R.id.Currency);
        TextView Country    = (TextView) convertView.findViewById(R.id.Country);
        ImageView Images    = (ImageView) convertView.findViewById(R.id.thumb);

        Currncy.setText(m_CountryCurrency[position]);
        Country.setText(m_CountryName[position]);
        Images.setImageResource(m_Images[position]);

        Images.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(m_Context, MainActivity.class);

                m_Context.startActivity(intent);
            }
        });

        return convertView;
    }
}
