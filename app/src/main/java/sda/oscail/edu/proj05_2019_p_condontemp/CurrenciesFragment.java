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


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Currencies fragment  calls the fixer.io currency exchange rates
 * @author PC
 * @version 1.0 (current version number of program)
 * @since 15/03/2019
 */

public class CurrenciesFragment extends Fragment implements Callback<FixerRates>, APICurrencyClickInterface {

    ListView lvCurrency;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        final View root = inflater.inflate(R.layout.activity_show_rates, container, false);

        lvCurrency = root.findViewById(R.id.lvCurrency);

        getFixerRates();

        return root;
    }

    /**
     *Create a Retrofit instance
     * add a converter (GsonConverterFactory)
     * and build() to build the Retrofit Instance
     */
    private void getFixerRates(){
        //http://data.fixer.io/api/latest?access_key=c0b866cc59fa9266142b6e42a9d495be&format=1
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://data.fixer.io/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        FixerApiInterface service = retrofit.create(FixerApiInterface.class);


//create handler for Retroit Instance:
        Call<FixerRates> call = service.loadCurrencyExchange();

        //  call.enqueue() to execcute the request asynchronously
        call.enqueue(this);
    }


    /**
     * @param call handler for the Retrofit Instance interface
     * @param response handle the successful response
     */
    @Override
    public void onResponse(Call<FixerRates> call, Response<FixerRates> response) {
        FixerRates fixerRates = response.body();
        lvCurrency.setAdapter(new CurrenciesAdapter(getActivity(), fixerRates.getCurrencyList(), this));

        ArrayList rates= new ArrayList();
        rates.add(fixerRates.getCurrencyList());

    }

    /**
     * Handle execution failure ,display a toast message indicating unable to get data
     */
    @Override
    public void onFailure(Call<FixerRates> call, Throwable t) {
        Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_LONG).show();

    }

    /**
     * @param c currency   clicked
     * intent to start ConvertActivity usinf selected currency name and rate
     */
    @Override
    public void onCurrencyItemClick(Currencies c) {

        Intent intent = new Intent(getActivity(), ConvertActivity.class);
        intent.putExtra("currency_name", c.getName());
        intent.putExtra("currency_rate", c.getRate());

        startActivity(intent);

    }
}

