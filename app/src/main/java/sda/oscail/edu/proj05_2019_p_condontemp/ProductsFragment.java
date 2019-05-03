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

/**
 *@author PC
 * @version 1.0 (current version number of program)
 * @since 15/03/2019
 * {@link sda.oscail.edu.proj05_2019_p_condontemp.ProductsFragment}  allows the user to
 * Create Products ,Delete Products,Update Products an show all Products from the Product table in sqlite database
 * @return Product Detail screen or Product List
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

public class ProductsFragment extends android.support.v4.app.ListFragment {

    /**
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     * @param context        The current context. Used to inflate the layout file.
     * @param  Product Detail Individual Product Details [ ie line from Product Table in Sqlite sheets.db
     * @param ProductList A List of Products Stored in Sqlite sheets.db Product Table
     * @param buttonAdd allows use to add new product
     * @param buttonShowAll displays the Product list ( if there are products saved in the database)
     */

    Button buttonAdd;
    Button buttonShowAll;
    TextView product_Id;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        final View root = inflater.inflate(R.layout.activity_product, container, false);

        Button buttonAdd = root.findViewById(R.id.btnAdd);
        Button buttonShowAll = root.findViewById(R.id.btnGetAll);


        //Add a new product:
        buttonAdd.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Intent intent = new Intent(getActivity(),ProductDetail.class);
                        intent.putExtra("product_Id",0);
                        startActivity(intent);

                    }
                });

//list the products:
        buttonShowAll.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        ProductUpdate uppp = new ProductUpdate(getActivity());
                        ArrayList<HashMap<String, String>> productList = uppp.getProductList();

                        if(productList.size()!=0) {
                            ListView lv = getListView();
                            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
                                    product_Id = view.findViewById(R.id.product_Id);
                                    String productId = product_Id.getText().toString();
                                    Intent showIntent = new Intent(getActivity().getApplicationContext(),ProductDetail.class);

                                    showIntent.putExtra("product_Id", Integer.parseInt( productId));
                                    startActivity(showIntent);

                                }
                            });

                            ListAdapter adapter = new SimpleAdapter( getActivity(),productList, R.layout.product_record, new String[] { "id","productCode","classs","grade","m2Tariff","moq","jpegImageId"  }, new int[] {R.id.product_Id,R.id.productCode,R.id.classs,R.id.grade,R.id.m2Tariff,R.id.moq,R.id.pb });
                            setListAdapter(adapter);


                        }else{
                            Toast.makeText(getActivity(),"No product!",Toast.LENGTH_SHORT).show();
                        }

                    }


                });

        return root;

    }
}








