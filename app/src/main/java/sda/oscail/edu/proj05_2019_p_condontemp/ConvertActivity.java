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
 *  citation
 * Class contains code adapted from :
 * https://www.youtube.com/watch?v=u1zb4dHthss
 * https://www.androidauthority.com/retrofit-android-tutorial-906928/
 * https://github.com/square/retrofit
 * https://www.javatpoint.com/android-json-parsing-tutorial
 * https://stackoverflow.com/questions/36100187/how-to-start-fragment-from-an-activity
 *
 * This activity allows the useer to convert Euros to a selected currency and also
 * chose a currency to use in a Quote [in Quote Fragment]
 */

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.text.DecimalFormat;

public class ConvertActivity   extends FragmentActivity {

    private TextView tvTitle, tvSubTitle, tvOutputName, tvOutputRate;
    private EditText etInput;
    private Button btnCalculate,btnUse;

    private String currencyName,rate;
    private double currencyRate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convert);

        tvTitle = findViewById(R.id.tvTitle);
        tvSubTitle = findViewById(R.id.tvSubTitle);
        tvOutputName = findViewById(R.id.tvOutputName);
        tvOutputRate = findViewById(R.id.tvOutputRate);

        etInput = findViewById(R.id.etInput);
        btnCalculate = findViewById(R.id.btnCalculate);
        btnUse=findViewById(R.id.btnUseCurrency);

        Intent intent = getIntent();
        currencyName = intent.getStringExtra("currency_name");
        currencyRate = intent.getDoubleExtra("currency_rate", 0);
        rate=String.valueOf(currencyRate);

        tvTitle.setText("EUR to " + currencyName.toUpperCase());
        tvSubTitle.setText("Rate 1 :  " + currencyRate);
        tvOutputName.setText(currencyName.toUpperCase() + ": ");
        btnUse.setText("USE  '"+currencyName.toUpperCase() + "'  IN A QUOTE");


        // calculate selected currency to Euros:
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etInput.getText().toString().length() == 0){
                    return;
                }

                double input;
                try{
                    input = Double.parseDouble(etInput.getText().toString());
                }
                catch (NumberFormatException e){
                    etInput.setText("");
                    return;
                }

                double output = input * currencyRate;
                DecimalFormat decimalFormat = new DecimalFormat("#,###.##");
                tvOutputRate.setText(decimalFormat.format(output));
            }
        });


        btnUse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //send currency and rate to be used in View Quote
                SharedPreferences sharedPref9 = getApplicationContext().getSharedPreferences("mydata9", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor9 = sharedPref9.edit();
                editor9.clear();
                editor9.putString("currencytouse", currencyName);
                editor9.putString("rate", rate);
                editor9.apply();

                // Start QuoteFragment inside this activity
                // code adapted from https://stackoverflow.com/questions/36100187/how-to-start-fragment-from-an-activity
                QuoteFragment fragmentOne = new QuoteFragment();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, fragmentOne);
                transaction.addToBackStack(null);
                transaction.commit();

            }
        });
    }

}
