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
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * customer detail fields displayed in screen for inputting customer data for saving,
 * updating,deleting
 * @CustomerUpdate
 */
public class CustomerDetail extends AppCompatActivity   implements android.view.View.OnClickListener{


    Button buttonSave;
    Button buttonDelete;
    Button buttonClose;
    EditText editTextCustNo;
    EditText editTextCustName;
    EditText editTextTown;
    EditText editTextCounty;
    EditText editTextCountry;
    EditText editTextPhoneNo;
    EditText editTextContactPerson;
    EditText editTextEmail;
    EditText editTextCurrency1;
    EditText editTextDiscount;

    private int _Cust_Id = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer_detail_activity);

        buttonSave = findViewById(R.id.buttonSave);
        buttonSave.setOnClickListener(this);

        buttonDelete = findViewById(R.id.buttonDelete);
        buttonDelete.setOnClickListener(this);

        buttonClose = findViewById(R.id.buttonClose);
        buttonClose.setOnClickListener(this);

        editTextCustNo = findViewById(R.id.editTextCustNo);
        editTextCustName = findViewById(R.id.editTextCustName);
        editTextTown = findViewById(R.id.editTextTown);
        editTextCounty = findViewById(R.id.editTextCounty);
        editTextCountry = findViewById(R.id.editTextCountry);
        editTextPhoneNo = findViewById(R.id.editTextPhoneNo);
        editTextContactPerson = findViewById(R.id.editTextContactPerson);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextCurrency1 = findViewById(R.id.editTextCurrency1);
        editTextDiscount = findViewById(R.id.editTextDiscount);

        _Cust_Id = 0;

        Intent intent1 = getIntent();
        _Cust_Id = intent1.getIntExtra("cust_Id", 0);
        CustomerUpdate uupdate = new CustomerUpdate(this);
        Customer customer = new Customer();
        customer = uupdate.getCustomerById(_Cust_Id);
        editTextCustNo.setText(String.valueOf(customer.custNo));
        editTextCustName.setText(customer.custName);
        editTextTown.setText(customer.town);
        editTextCounty.setText(customer.county);
        editTextCountry.setText(customer.country);
        editTextPhoneNo.setText(customer.phoneNo);
        editTextContactPerson.setText(customer.contactPerson);
        editTextEmail.setText(customer.email);
        editTextCurrency1.setText(customer.currency1);
        editTextDiscount.setText(String.valueOf(customer.discount));

    }


    public void onClick(View view) {
        if (view == findViewById(R.id.buttonSave)) {
            CustomerUpdate uupdate = new CustomerUpdate(this);
            Customer customer = new Customer();
            customer.custNo = Integer.parseInt(editTextCustNo.getText().toString());
            customer.custName = editTextCustName.getText().toString();
            customer.town = editTextTown.getText().toString();
            customer.county = editTextCounty.getText().toString();
            customer.country = editTextCountry.getText().toString();
            customer.phoneNo = editTextPhoneNo.getText().toString();
            customer.contactPerson = editTextContactPerson.getText().toString();
            customer.email = editTextEmail.getText().toString();
            customer.currency1 = editTextCurrency1.getText().toString();
            customer.discount = Integer.parseInt(editTextDiscount.getText().toString());
            customer.cust_ID = _Cust_Id;
            if (_Cust_Id == 0) {
                _Cust_Id = uupdate.insert(customer);

                Toast.makeText(this, "New Customer Insert", Toast.LENGTH_SHORT).show();
            } else {

                uupdate.update(customer);
                Toast.makeText(this, "Customer Record updated", Toast.LENGTH_SHORT).show();
            }

        } else if (view == findViewById(R.id.buttonDelete)) {
            CustomerUpdate uupdate = new CustomerUpdate(this);
            uupdate.delete(_Cust_Id);
            //Toast.makeText(this, "Customer Record Deleted", Toast.LENGTH_SHORT).show();
            Toast.makeText(this, "Customer Record Deleted", Toast.LENGTH_SHORT).show();
            finish();
        } else if (view == findViewById(R.id.buttonClose)) {
            finish();
        }


    }



}
