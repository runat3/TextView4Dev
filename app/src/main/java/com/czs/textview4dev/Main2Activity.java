package com.czs.textview4dev;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;

public class Main2Activity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.table_layout);

        TabLayout.Tab tab1 = tabLayout.newTab().setText("AigeStudio");
        tabLayout.addTab(tab1);
        TabLayout.Tab tab2 = tabLayout.newTab().setText("Aige");
        tabLayout.addTab(tab2);
        TabLayout.Tab tab3 = tabLayout.newTab().setText("Studio");
        tabLayout.addTab(tab3);
        TabLayout.Tab tab4 = tabLayout.newTab().setText("Android");
        tabLayout.addTab(tab4);
        TabLayout.Tab tab5 = tabLayout.newTab().setText("Java");
        tabLayout.addTab(tab5);
        TabLayout.Tab tab6 = tabLayout.newTab().setText("Design");
        tabLayout.addTab(tab6);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);

    }
}
