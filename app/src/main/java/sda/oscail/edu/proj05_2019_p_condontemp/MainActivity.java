package sda.oscail.edu.proj05_2019_p_condontemp;
/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.v4.view.ViewPager;
import android.os.Bundle;


public class    MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TabLayout tabLayout = findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab());
        tabLayout.addTab(tabLayout.newTab());
        tabLayout.addTab(tabLayout.newTab());
        tabLayout.addTab(tabLayout.newTab());
        tabLayout.addTab(tabLayout.newTab());
        tabLayout.addTab(tabLayout.newTab());


/** Create the adapter that will return a fragment for each of the three
 * primary sections of the activity.
 */
        final ViewPager mypager = findViewById(R.id.pager);
        final MyPageAdapter myadapter = new MyPageAdapter(getSupportFragmentManager(), tabLayout.getTabCount());

        mypager.setAdapter(myadapter);
        tabLayout.setupWithViewPager(mypager);

        //Clear Shared Preferences:
        SharedPreferences sharedPref = getSharedPreferences("MyData",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.clear();
        editor.apply();

        SharedPreferences sharedPref9 = getSharedPreferences("mydata9", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor9 = sharedPref9.edit();
        editor9.clear();
        editor9.apply();

        SharedPreferences pref1 = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor1 = pref1.edit();
        editor1.clear();
        editor1.apply();

        SharedPreferences sharedPrefa = getSharedPreferences("MyData1",MODE_PRIVATE);
        SharedPreferences.Editor editora = sharedPrefa.edit();
        editora.clear();
        editora.apply();


    }

    @Override
    //public void onActivityResult(int requestCode, int resultCode, Intent data)
    public void onActivityResult(int requestCode, int resultCode, Intent data)

    {
        super.onActivityResult(requestCode,resultCode,data);

    }


}
