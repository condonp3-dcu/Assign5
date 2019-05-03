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
 * citation
 * Class contains code adapted from :
 * https://www.youtube.com/watch?v=u1zb4dHthss
 * https://www.androidauthority.com/retrofit-android-tutorial-906928/
 * https://github.com/square/retrofit
 * https://www.javatpoint.com/android-json-parsing-tutorial
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.List;


public class CurrenciesAdapter extends BaseAdapter {

    private LayoutInflater inflater;
    private List<Currencies> currenciesList;
    private APICurrencyClickInterface APICurrencyClickInterface;

    public CurrenciesAdapter(Context context, List<Currencies> currenciesList, APICurrencyClickInterface APICurrencyClickInterface) {
        this.currenciesList = currenciesList;
        this.APICurrencyClickInterface = APICurrencyClickInterface;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return currenciesList.size();
    }

    @Override
    public Object getItem(int i) {
        return currenciesList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View currencyItemView = inflater.inflate(R.layout.activity_currency, null);
        TextView tvName = currencyItemView.findViewById(R.id.textViewName);
        TextView tvRate = currencyItemView.findViewById(R.id.textViewRate);

        final Currencies c = currenciesList.get(i);

        tvName.setText(c.getName());
        tvRate.setText(Double.toString(c.getRate()));


        currencyItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                APICurrencyClickInterface.onCurrencyItemClick(c);
            }
        });
        return currencyItemView;
    }
}
