package sda.oscail.edu.proj05_2019_p_condontemp;
/**
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
 */

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static sda.oscail.edu.proj05_2019_p_condontemp.R.*;
import static sda.oscail.edu.proj05_2019_p_condontemp.R.layout.*;


/**
 * @author PC
 * @version 1.0 (current version number of program)
 * @since 15/03/2019
 * View Quote shows the quote information generated in QuoteFragment
 * {@link QuoteFragment}
 * user can send email of quote
 */


public class ViewQuote extends AppCompatActivity implements android.view.View.OnClickListener{
    /**
     * Create a new Quotation.
     *
     * @param message is a the order data built up into one Stringfor email
     * @param disc double double value of discount
     * @param m2Tarriffdouble is the m2 tariff format for calculating thr price
     * @paran moqdouble id the pack size(minumum order quantity) for ccalculating th price of the quote
     * @paran m2pricedouble is the p2 price (m2tarriff -disc)
     * @param ratetouse is EUR id no currency senected from currencies fragment
     * @param packsdouble is the no of packs od a product selected is an arraylist for storing the products selected
     * @param totalprice is the total price of the order.
     *
     * */


    String message  ="";
    String currency="";
    private double discdouble;
    private double m2Tariffdouble;
    private double m2pricedouble;
    private double linetotalprice;
    private double moqdouble;
    private double packsdouble;
    private double totalprice;
    private double ratetouse;
    private double exchange;
    Button btnBack, btnSendquote;

    /**
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(activity_show_quote);
        TextView tvcustomer = findViewById(id.tvcustomer);
        TextView tvqdate = findViewById(id.tvqdate);
        TextView tvcurrency = findViewById(id.currenc);
        TextView tvdeldate = findViewById(id.tvdeliverydate);
        btnBack = findViewById(id.btn_back);
        btnBack.setOnClickListener(this);
        btnSendquote = findViewById(id.btn_sendquote);
        btnSendquote.setOnClickListener(this);
        ArrayList<String> noofpacks = new ArrayList<String>();

        /**Shared Pref9 is from Convert Activity : Use currency ( if selected). Otherwise
         * stay with Euros
         */
        SharedPreferences sharedPref9 = getApplicationContext().getSharedPreferences("mydata9", Context.MODE_PRIVATE);
        final String currencytouse = sharedPref9.getString("currencytouse", "default");
        final String rate = sharedPref9.getString("rate", "default");
        if (currencytouse=="default") {
            currency="EUR";
            exchange=1;
        } else {
            ratetouse=Double.parseDouble(rate);
            currency=currencytouse;
            exchange=ratetouse;
        }

        SharedPreferences sharedPref = getSharedPreferences("MyData", MODE_PRIVATE);
        final String qdate = sharedPref.getString("qdate", "default");
        final String custToQuote = sharedPref.getString("customer", "default");
        final String disc = sharedPref.getString("discount", "default");
        final String delDate = sharedPref.getString("delDate", "default");

        /** set textviews in Quote:
         *
         * */
        tvqdate.setText(qdate);
        tvdeldate.setText(delDate);
        tvcustomer.setText(custToQuote);
        tvcurrency.setText(currency);

        discdouble = 0;
        discdouble = Double.valueOf(disc);

        /** get list size from QuoteFragment
         *
         * */

        SharedPreferences sharedPrefa = getSharedPreferences("MyData1", MODE_PRIVATE);
        int size = sharedPrefa.getInt("listsize", 0);

        ProductUpdate update = new ProductUpdate(this);
        final ArrayList<HashMap<String, String>> productList = update.getProductList();

        /** Get list of items selected in Fragment Quote and assign to a arraylist
         *
         */
        ArrayList<String> array = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {

            final String lineStringa = sharedPrefa.getString("list" + "_" + i, "default");
            array.add(lineStringa);
        }

        ArrayList<String> strings = new ArrayList<String>();
        for (int i = 0; i < size; i++) {
            strings.add(array.get(i));

        }

        /**Sort through Array and group products selected from QuoteFragment ( ie group
         *  any repeat selects
         */

        Map<String, Integer> counts = new HashMap<String, Integer>();

        for (String str : strings) {
            if (counts.containsKey(str)) {
                counts.put(str, counts.get(str) + 1);
            } else {
                counts.put(str, 1);
            }
        }

        final LinearLayout layout = findViewById(id.LinearMain);
        //LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
        // LinearLayout.LayoutParams.WRAP_CONTENT);


        /** work put prices for each line in thr Quote and the total price
         *
         */
        totalprice = 0;
        for (Map.Entry<String, Integer> entry : counts.entrySet()) {

            int j = Integer.parseInt(entry.getKey());

            final String productcode = productList.get(j).get("productCode");
            final String classs = productList.get(j).get("classs");
            final String grade = productList.get(j).get("grade");
            final String thickness = productList.get(j).get("thickness");
            final String m2Tariff = productList.get(j).get("m2Tariff");
            final String moq = productList.get(j).get("moq");
            final String packs = (String.valueOf(entry.getValue()));

            m2Tariffdouble = 0;
            m2Tariffdouble = Double.valueOf(m2Tariff);
            moqdouble = Double.valueOf(moq);
            packsdouble = Double.valueOf(packs);

            /** work out prices:
             *  m2pricedouble ie price/m2 is m2Tariff/m2 less %discount
             *  */
            m2pricedouble = (m2Tariffdouble - (m2Tariffdouble * discdouble / 100))*exchange;
            /** price of item in line is length(2.44) x width(1.22) x packquantity(moqdouble) X m2price X no of packs
             *
             */
            linetotalprice = (2.44 * 1.22 * m2pricedouble * moqdouble * packsdouble);
            totalprice = totalprice + linetotalprice;
            DecimalFormat decimalFormat = new DecimalFormat("##.##");
            double twodigitprice = Double.valueOf(decimalFormat.format(m2pricedouble));
            double twodigitlineprice = Double.valueOf(decimalFormat.format(linetotalprice));
            final String m2price = String.valueOf(twodigitprice);
            final String lineprice = String.valueOf(twodigitlineprice);


            /**set quote values in activity_show_quote:
             *
             */
            LinearLayout la = new LinearLayout(this);
            la.setOrientation((LinearLayout.HORIZONTAL));

            TextView tv = new TextView(this);
            tv.setText(productcode);
            tv.setTextSize(2, 10);
            tv.setPadding(2, 2, 2, 2);
            tv.setTextColor(Color.RED);
            la.addView(tv);
            TextView tv1 = new TextView(this);
            tv1.setText(classs);
            tv1.setTextSize(2, 10);
            tv1.setPadding(2, 2, 2, 2);
            tv1.setTextColor(Color.RED);
            la.addView(tv1);
            TextView tv2 = new TextView(this);
            tv2.setText(grade);
            tv2.setTextSize(2, 10);
            tv2.setPadding(2, 2, 2, 2);
            tv2.setTextColor(Color.RED);
            la.addView(tv2);
            TextView tv3 = new TextView(this);
            tv3.setText(thickness);
            tv3.setTextSize(2, 10);
            tv3.setPadding(3, 2, 2, 2);
            tv3.setTextColor(Color.RED);
            la.addView(tv3);
            TextView tv4 = new TextView(this);
            tv4.setText(currency);
            tv4.setTextSize(2, 10);
            tv4.setPadding(10, 2, 2, 2);
            tv4.setTextColor(Color.BLUE);
            la.addView(tv4);
            TextView tv5 = new TextView(this);
            tv5.setText(m2price);
            tv5.setTextSize(2, 10);
            tv5.setPadding(1, 2, 2, 2);
            tv5.setTextColor(Color.RED);
            la.addView(tv5);
            TextView tv8 = new TextView(this);
            tv8.setText("/m2");
            tv8.setTextSize(2, 10);
            tv8.setPadding(2, 2, 2, 2);
            tv8.setTextColor(Color.RED);
            la.addView(tv8);
            TextView tv6 = new TextView(this);
            tv6.setText("packs:");
            tv6.setTextSize(2, 10);
            tv6.setPadding(10, 2, 2, 2);
            tv6.setTextColor(Color.DKGRAY);
            la.addView(tv6);
            TextView tv7 = new TextView(this);
            tv7.setText(packs);
            tv7.setTextSize(2, 10);
            tv7.setPadding(4, 2, 2, 2);
            tv7.setTextColor(Color.DKGRAY);
            la.addView(tv7);
            TextView tv12 = new TextView(this);
            tv12.setText(currency);
            tv12.setTextSize(2, 10);
            tv12.setPadding(18, 2, 2, 2);
            tv12.setTextColor(Color.BLUE);
            la.addView(tv12);
            TextView tv9 = new TextView(this);
            tv9.setText(lineprice);
            tv9.setTextSize(2, 10);
            tv9.setPadding(2, 2, 2, 2);
            tv9.setTextColor(Color.RED);
            la.addView(tv9);

            layout.addView(la);
            message+="\n"+ "code "+productcode+" class "+classs+" grade "+grade+" "+"\n"+"2440 x 1220 x "+thickness+"mm"+" "+ " moq  "+moq+" sheets"+"\n"+currency+m2price+"/m2"+ "  packs: "+packs
                    +"   "+currency+" "+lineprice+ "\n";

        }
        LinearLayout la1 = new LinearLayout(this);
        la1.setOrientation((LinearLayout.HORIZONTAL));
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        double twodigittotalprice = Double.valueOf(decimalFormat.format(totalprice));
        final String totalpricee = String.valueOf(twodigittotalprice);
        TextView tv10 = new TextView(this);
        tv10.setText("Total Price:  ");
        tv10.setTextSize(2, 20);
        tv10.setPadding(170, 2, 2, 2);
        tv10.setTextColor(Color.RED);
        la1.addView(tv10);
        TextView tv13 = new TextView(this);
        tv13.setText(currency);
        tv13.setTextSize(2, 20);
        tv13.setPadding(15, 2, 2, 2);
        tv13.setTextColor(Color.BLUE);
        la1.addView(tv13);
        TextView tv11 = new TextView(this);
        tv11.setText(totalpricee);
        tv11.setTextSize(2, 20);
        tv11.setPadding(1, 2, 2, 2);
        tv11.setTextColor(Color.RED);
        la1.addView(tv11);
        layout.addView(la1);

        message+="\n"+"Total Price : "+currency+" "+totalpricee;

        array.clear();
        strings.clear();
        noofpacks.clear();

    }

    /** Set a click listener for Fragment button to SAVE/SEND QUOTE
     *
     * @param view
     */
    public void onClick(View view) {
        if (view == findViewById(R.id.btn_sendquote)) {
            Intent intent9 = new Intent(Intent.ACTION_SEND);
            intent9.setType("*/*");
            String [] TO = new String[1];
            TO[0]=getEmail();
            intent9.putExtra(Intent.EXTRA_EMAIL, TO);
            intent9.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.email_subject));
            intent9.putExtra(Intent.EXTRA_TEXT, createOrderSummary());

            //Safety check to check that the intent can work ie call resolveActivity() on
            // the intent object. If result is non-null there is at leasr one app that can
            //handle the intent ant it is safe to startActivity.
            if (intent9.resolveActivity(this.getPackageManager()) != null) {
                startActivity(intent9);
            }


        } else if(view == findViewById(R.id.btn_back)) {
            // clear quote data from shared preferences:
            SharedPreferences sharedPref9 = getSharedPreferences("mydata9", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor9 = sharedPref9.edit();
            editor9.clear();
            editor9.apply();
            SharedPreferences sharedPrefa = getSharedPreferences("MyData1",MODE_PRIVATE);
            SharedPreferences.Editor editora = sharedPrefa.edit();
            editora.clear();
            editora.apply();

            finish();
        }

    }

    /**
     * Returns the Email Body Message.
     * <p> Email body message is created used prescription related data inputed from user </p>
     *
     * @return Email Body Message
     */

    private String createOrderSummary()
    {

        /** Info for message on the quote email:
         *
         */
        SharedPreferences sharedPref = getSharedPreferences("MyData", MODE_PRIVATE);
        final String qdate = sharedPref.getString("qdate", "default");
        final String custToQuote = sharedPref.getString("customer", "default");
        final String delDate = sharedPref.getString("delDate", "default");

        /** Message on the quote email:
         *
         */
        String quoteMessage =   "Quote date:  "+qdate+    "     " +"\n" + "Customer :  " +  custToQuote;
        quoteMessage += "\n" + "\n" + "Delivery date:  " + delDate+  "\n";
        quoteMessage+=message;

        return quoteMessage;
    }

    private String getEmail()
    {
        SharedPreferences sharedPref = getSharedPreferences("MyData", MODE_PRIVATE);
        final String email = sharedPref.getString("email", "default");
        return email;
    }


}