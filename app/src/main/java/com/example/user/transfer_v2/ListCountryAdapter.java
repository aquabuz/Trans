package com.example.user.transfer_v2;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by User on 2017-05-15.
 */

public class ListCountryAdapter extends BaseAdapter implements Filterable {

    private LayoutInflater  m_Layout            = null;
    private Context         m_Context           = null;
    private ItemFilter      mFilter             = new ItemFilter();


    private ArrayList<CountryModels>    m_ArrayList     = null;
    private ArrayList<CountryModels>    m_FilterArrayList     = null;


    public ListCountryAdapter(Context context, int textViewResourceId) {

        m_Context           = context;
        m_Layout            = (LayoutInflater)m_Context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    public void setData(ArrayList<CountryModels> list) {
        m_ArrayList = list; // 기본 리스트
        m_FilterArrayList = list; // 필터링 리스트
    }

    @Override
    public int getCount() {
        return m_FilterArrayList.size();
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

        //convertView = m_Layout.inflate(R.layout.listview_row, parent, false);

        View v = convertView;
        if (v == null) {
            LayoutInflater vi = (LayoutInflater)m_Context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(R.layout.listview_row, null);
        }

        TextView Currency    = (TextView) v.findViewById(R.id.Currency);
        TextView Country    = (TextView) v.findViewById(R.id.Country);
        ImageView Images    = (ImageView) v.findViewById(R.id.thumb);

        Currency.setText(m_FilterArrayList.get(position).getCountryCurremcy());
        Country.setText(m_FilterArrayList.get(position).getCountryName());
        Images.setImageResource(m_FilterArrayList.get(position).getImageId());

        Images.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(m_Context, MainActivity.class);

                m_Context.startActivity(intent);
            }
        });

        return v;
    }

    private class ItemFilter extends Filter {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            String filterString = constraint.toString().toLowerCase();

            FilterResults results = new FilterResults();

            int count = m_FilterArrayList.size();
            final ArrayList<CountryModels> tempItems = new ArrayList<CountryModels>();

            for (int i = 0; i < count; i++) {
                String strList = m_FilterArrayList.get(i).getCountryName().toLowerCase();

                Log.d("debug", "strList=" + strList);
                Log.d("debug", "filterString=" + filterString);

                if (strList.contains(filterString)) {
                    Log.e("debug", "Matching");
                    tempItems.add(m_FilterArrayList.get(i));
                }
            }

            results.values = tempItems;
            results.count = tempItems.size();

            Log.d("debug", "results.count=" + results.count);

            return results;
        }

        @SuppressWarnings("unchecked")
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            m_FilterArrayList = (ArrayList<CountryModels>) results.values;
            notifyDataSetChanged();
        }
    }

    public Filter getFilter() {
        return mFilter;
    }

}
