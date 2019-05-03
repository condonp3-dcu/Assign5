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
 */


import android.content.Intent;
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
import java.util.ArrayList;
import java.util.HashMap;

public class CustomersFragment extends  android.support.v4.app.ListFragment {

    Button buttonAdd, buttonShowAll;
    TextView cust_Id;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        final View root = inflater.inflate(R.layout.activity_customer, container, false);

        Button buttonAdd = root.findViewById(R.id.buttonAdd);
        Button buttonShowAll = root.findViewById(R.id.buttonShowAll);


        //Add a new customer:
        buttonAdd.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Intent intent1 = new Intent(getActivity(),CustomerDetail.class);
                        intent1.putExtra("cust_Id",0);
                        startActivity(intent1);

                    }
                });

// Show customer list:
        buttonShowAll.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        CustomerUpdate update = new CustomerUpdate(getActivity());
                        ArrayList<HashMap<String, String>> customerList =update.getCustomerList();

                        if(customerList.size()!=0) {
                            ListView lv = getListView();
                            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
                                    cust_Id = view.findViewById(R.id.cust_Id);
                                    String custId = cust_Id.getText().toString();

                                    Intent showIntent = new Intent(getActivity().getApplicationContext(),CustomerDetail.class);
                                    showIntent.putExtra("cust_Id", Integer.parseInt( custId));
                                    startActivity(showIntent);
                                }
                            });

                            ListAdapter adapter = new SimpleAdapter( getActivity(),customerList, R.layout.customer_record, new String[] { "id","custNo","custName","currency1","county"}, new int[] {R.id.cust_Id, R.id.custNo,R.id.custName,R.id.currency1,R.id.county});
                            setListAdapter(adapter);

                        }else{

                            Toast.makeText(getActivity(),"No customer! ",Toast.LENGTH_SHORT).show();
                        }

                    }


                });


        return root;

    }




}
