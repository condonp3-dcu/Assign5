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
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import static android.content.Context.MODE_PRIVATE;


public class QuoteFragment extends  android.support.v4.app.ListFragment {
    /**
     * Create a new Quotation.
     *
     * @param line is count of the  products seleced
     * @param cust_Id is the customer id in SqQlite table customer
     * @param product_id is the id of the  product in th SQlite table Customer
     * @param m2Tariffdouble is the m2 tarriff  format for calculating the price
     * @param rate to use is the exchalge rate:EUR id the currency has not been seleced
     * from curencies
     * @param list is an arraylist for storing the products selected
     *
     * */

    Button btnSelect,btnCheckout;
    int line=0;
    TextView cust_Id;
    TextView product_Id1;
    private int _Cust_Id1 = 0;
    private int _Product_Id1 = 0;
    private double m2Tariffdouble;
    private double ratetouse;
    private double exchange;
    String currency="";
    ArrayList<String> list = new ArrayList<String>();



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View root = inflater.inflate(R.layout.fragment_quotations, container, false);
        btnSelect = root.findViewById(R.id.btn_Select);
        btnCheckout = root.findViewById(R.id.btn_Checkout);
        final TextView TVquote = root.findViewById(R.id.textViewQuote);

/**   get current date:
 *
 */
        Date cDate = new Date();
        final String fDate = new SimpleDateFormat("yyyy-MM-dd").format(cDate);

/**  add 1 week from current date for delivery:
 */
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Calendar cal = Calendar.getInstance();
        cal.setTime(cDate);
        cal.add(Calendar.DATE, 7);
        final String delDate = sdf.format(cal.getTime());

/** disable checkout until customer/product selected
 *
 */
        if  (line<1){
            btnCheckout.setEnabled(false);
        }

/** if alternative currency selected then change here for quote:
 *
 */
        SharedPreferences sharedPref9 = getActivity().getSharedPreferences("mydata9", Context.MODE_PRIVATE);
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

        /** Set a click listener for Fragment button to SAVE/SEND QUOTE
         */
        btnSelect.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        /**clicked to show customers to select from:
                         *
                         */
                        list.clear();
                        CustomerUpdate uupdate = new CustomerUpdate(getActivity());
                        final ArrayList<HashMap<String, String>> customerList = uupdate.getCustomerList();

                        if(customerList.size()!=0) {
                            ListView lv = getListView();
                            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
                                    Toast.makeText(getActivity(),"Tap items to select(tap again for more) ",Toast.LENGTH_LONG).show();
                                    cust_Id = view.findViewById(R.id.cust_Id);
                                    final String custId = cust_Id.getText().toString();
                                    _Cust_Id1 = 0;

                                    _Cust_Id1=Integer.parseInt( custId);

                                    final String custToQuote=customerList.get(_Cust_Id1-1).get("custName");
                                    final String curr=customerList.get(_Cust_Id1-1).get("currency1");
                                    final String disc = customerList.get(_Cust_Id1-1).get("discount");
                                    final String email = customerList.get(_Cust_Id1-1).get("email");
                                    Toast.makeText(getActivity(),"customerselected "+custToQuote,Toast.LENGTH_SHORT).show();
                                    TVquote.setText("Customer to Quote: "+custToQuote);

                                    SharedPreferences sharedPrefa = getActivity().getSharedPreferences("MyData1",MODE_PRIVATE);
                                    SharedPreferences.Editor editora = sharedPrefa.edit();
                                    editora.clear();


                                    ProductUpdate up = new ProductUpdate(getActivity());
                                    final ArrayList<HashMap<String, String>> productList = up.getProductList();
                                    if(productList.size()!=0) {

                                        ListView lv = getListView();
                                        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                            @Override
                                            public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
                                                product_Id1 = view.findViewById(R.id.product_Id);
                                                String productId = product_Id1.getText().toString();
                                                _Product_Id1 = 0;
                                                _Product_Id1=Integer.parseInt(productId);
                                                SharedPreferences sharedPref = getActivity().getSharedPreferences("MyData",MODE_PRIVATE);
                                                SharedPreferences.Editor editor = sharedPref.edit();
                                                editor.putString("qdate",fDate);
                                                editor.putString("customer",custToQuote );
                                                editor.putString("custId",custId);
                                                editor.putString("currency",curr);
                                                editor.putString("discount",disc);
                                                editor.putString("delDate",delDate);
                                                editor.putString("email",email);
                                                editor.apply();


                                                line++;
/** disable checkout until customer and product selected
 *
 */
                                                if  (line<1) {
                                                } else {
                                                    btnCheckout.setEnabled(true);
                                                }


                                                int index=0;
                                                int ij=productList.size();
                                                for (int i = 0; i < ij; i++){

                                                    if (productList.get(i).get("id").equals(productId)) {
                                                        ;index=i;

                                                    }
                                                }

                                                String Index=String.valueOf(index);
                                                list.add(Index);

                                            }
                                        });

                                        int size=productList.size();
                                        for (int i = 0; i < size; i++) {
                                            String m2Tarifff = productList.get(i).get("m2Tariff");
                                            m2Tariffdouble = 0;
                                            m2Tariffdouble = Double.valueOf(m2Tarifff);
                                            m2Tariffdouble=m2Tariffdouble*exchange;
                                            DecimalFormat decimalFormat = new DecimalFormat("##.##");
                                            double twodigitm2Tariff = Double.valueOf(decimalFormat.format(m2Tariffdouble));
                                            final String m2Tarifftwodigit = String.valueOf(twodigitm2Tariff);
                                            productList.get(i).put("m2Tariff",m2Tarifftwodigit);
                                            productList.get(i).put("curr",currency);

                                        }
                                        ListAdapter adapter = new SimpleAdapter( getActivity(),productList, R.layout.product_record_quote  , new String[] { "id","productCode","classs","grade","m2Tariff","moq","jpegImageId","curr"}, new int[] {R.id.product_Id,R.id.productCode,R.id.classs,R.id.grade,R.id.m2Tariff,R.id.moq,R.id.pb,R.id.M2TarriffTitle});
                                        setListAdapter(adapter);

                                    }else{
                                        Toast.makeText(getActivity(),"No product!",Toast.LENGTH_SHORT).show();
                                    }

                                }
                            });

                            ListAdapter adapter = new SimpleAdapter( getActivity(),customerList, R.layout.customer_recordquote, new String[] {  "id","custName","custNo","currency1"}, new int[] {R.id.cust_Id,R.id.custName2,R.id.custNo2,R.id.currency2});
                            setListAdapter(adapter);

                        }else{
                            Toast.makeText(getActivity(),"No customer!",Toast.LENGTH_SHORT).show();
                        }
                    }


                });


        if  (line<1) {
            btnCheckout.setEnabled(false);
        } else   {
            btnCheckout.setEnabled(true);
        }


        btnCheckout.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        /** Put the list of products selected in SharedPrefa editora for View Quote activity
                         *
                         */
                        SharedPreferences sharedPrefa = getActivity().getSharedPreferences("MyData1", MODE_PRIVATE);
                        SharedPreferences.Editor editora = sharedPrefa.edit();
                        editora.clear();

                        editora.putInt("listsize", list.size());
                        for (int i = 0; i < list.size(); i++) {

                            editora.putString("list" + "_" + i, list.get(i));
                            editora.apply();
                        }
                        line = 0;
                        list.clear();
                        Intent intent11 = new Intent(getActivity(), ViewQuote.class);
                        startActivity(intent11);

                    }
                });

        return root;
    }

}




