package com.example.user.transfer_v2;

import android.content.Intent;
import android.os.Handler;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

//    TextView textView;
//    EditText editText;

//    클래스 호출
//    private TextWatcherClass    m_TextWatcherClass          = null;

    private Intent      m_Intent        = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        m_Intent = getIntent();
        final String currency     = m_Intent.getStringExtra("Currency");
        final int country = m_Intent.getIntExtra("Position", 0);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);//Back Button
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        //tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);//키패드 활성

        final ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        FragmentPagerrAdpater adapter = new FragmentPagerrAdpater(getSupportFragmentManager());

        final TabFragment1 tabFragment1 = new TabFragment1();

        TabFragment2 tabFragment2 = new TabFragment2();

        adapter.addFragment(tabFragment1, "Send");
        adapter.addFragment(tabFragment2, "Receive");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

//        클래스 호출
//        textView = (TextView)findViewById(R.id.compareText); // 결과를 보여줄 TextView
//        editText = (EditText)findViewById(R.id.inputText); // 값을 입력할 EditText
//
//        m_TextWatcherClass = new TextWatcherClass();
//
//        editText.addTextChangedListener(m_TextWatcherClass); // TextWatcher 리스너 등록

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                ((TabFragment1) tabFragment1).setCurrency(currency);
                ((TabFragment1) tabFragment1).setCountry(country);
            }
        }, 200);

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
