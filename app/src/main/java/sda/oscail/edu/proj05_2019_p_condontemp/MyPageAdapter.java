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
 * Page adapter to set up the fragments:
 */

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class MyPageAdapter extends FragmentStatePagerAdapter
{
    int mNumOfTabs;
    public static final int HOME = 0;
    public static final int GALLERY = 1;
    public static final int PRODUCTS = 2;
    public static final int CUSTOMERS = 3;
    public static final int QUOTE = 4;
    public static final int CURRENCIES = 5;
    public static final String UI_TAB_HOME = "HOME";
    public static final String UI_TAB_GALLERY ="GALLERY";
    public static final String UI_TAB_PRODUCTS = "PRODUCTS";
    public static final String UI_TAB_CUSTOMERS = "CUSTOMERS";
    public static final String UI_TAB_CURRENCIES = "CURRENCIES";
    public static final String UI_TAB_QUOTE = "QUOTE";



    public MyPageAdapter(FragmentManager fm, int NumOfTabs)
    {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public android.support.v4.app.Fragment getItem(int position)
    {

        switch (position)
        {
            case HOME:
                HomeFragment HomeTab = new HomeFragment();
                return HomeTab;
            case GALLERY:
                GalleryFragment GalleryTab = new GalleryFragment();
                return GalleryTab;
            case PRODUCTS:
                ProductsFragment ProductsTab = new ProductsFragment();
                return ProductsTab;
            case CUSTOMERS:
                CustomersFragment CustomersTab = new CustomersFragment();
                return CustomersTab;
            case CURRENCIES:
                CurrenciesFragment CurrenciesTab = new CurrenciesFragment();
                return CurrenciesTab;
            case QUOTE:
                QuoteFragment QuoteTab = new QuoteFragment();
                return QuoteTab;
            default:
                return null;
        }
    }

    @Override
    public int getCount()
    {
        return mNumOfTabs;
    }

    public CharSequence getPageTitle(int position) {
        switch (position) {
            case HOME:
                return UI_TAB_HOME;
            case GALLERY:
                return UI_TAB_GALLERY;
            case PRODUCTS:
                return UI_TAB_PRODUCTS;
            case CUSTOMERS:
                return UI_TAB_CUSTOMERS;
            case CURRENCIES:
                return UI_TAB_CURRENCIES;
            case QUOTE:
                return UI_TAB_QUOTE;
            default:
                break;
        }
        return null;
    }

}