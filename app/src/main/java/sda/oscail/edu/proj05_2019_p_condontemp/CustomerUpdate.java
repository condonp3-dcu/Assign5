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

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *@author PC
 * @version 1.0 (current version number of program)
* @since 15/03/2019
 * {@link CustomerUpdate} is an allows the user to
 * update Customer table in sqlite database
 */
public class CustomerUpdate {
    private CustDatabaseHelper  custdatabaseHelper;
    public CustomerUpdate(Context context) {
        custdatabaseHelper = new CustDatabaseHelper(context);
    }


    public int insert(Customer customer) {
        //Open connection to write data
        SQLiteDatabase db = custdatabaseHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Customer.CcustNo, customer.custNo);
        values.put(Customer.CcustName,customer.custName);
        values.put(Customer.Ttown, customer.town);
        values.put(Customer.Ccounty, customer.county);
        values.put(Customer.Ccountry,customer.county);
        values.put(Customer.PphoneNo, customer.phoneNo);
        values.put(Customer.CcontactPerson,customer.contactPerson);
        values.put(Customer.Eemail, customer.email);
        values.put(Customer.Ccurrency1, customer.currency1);
        values.put(Customer.Ddiscount,customer.discount);
        // Inserting Row
        long cust_Id = db.insert(Customer.TABLE, null, values);
        db.close(); // Closing database connection
        return (int) cust_Id;
    }

    public void delete(int cust_Id) {

        SQLiteDatabase db = custdatabaseHelper.getWritableDatabase();

        db.delete(Customer.TABLE, Customer.ID + "= ?", new String[] { String.valueOf(cust_Id) });
        db.close(); // Closing database connection
    }

    public void update(Customer customer) {

        SQLiteDatabase db = custdatabaseHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Customer.CcustNo, customer.custNo);
        values.put(Customer.CcustName,customer.custName);
        values.put(Customer.Ttown, customer.town);
        values.put(Customer.Ccounty, customer.county);
        values.put(Customer.Ccountry,customer.county);
        values.put(Customer.PphoneNo, customer.phoneNo);
        values.put(Customer.CcontactPerson,customer.contactPerson);
        values.put(Customer.Eemail, customer.email);
        values.put(Customer.Ccurrency1, customer.currency1);
        values.put(Customer.Ddiscount,customer.discount);

        db.update(Customer.TABLE, values, Customer.ID + "= ?", new String[] { String.valueOf(customer.cust_ID) });
        db.close(); // Closing database connection
    }

    public ArrayList<HashMap<String, String>>  getCustomerList() {
        //Open connection to read only
        SQLiteDatabase db = custdatabaseHelper.getReadableDatabase();
        String selectQuery =  "SELECT  " +
                Customer.ID + "," +
                Customer.CcustNo + "," +
                Customer.CcustName + "," +
                Customer.Ttown + "," +
                Customer.Ccounty + ","  +
                Customer.Ccountry+ "," +
                Customer.PphoneNo + "," +
                Customer.CcontactPerson+ "," +
                Customer.Eemail + "," +
                Customer.Ccurrency1 + "," +
                Customer.Ddiscount +
                " FROM " + Customer.TABLE;


        ArrayList<HashMap<String, String>> customerList = new ArrayList<HashMap<String, String>>();

        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list

        if (cursor.moveToFirst()) {
            do {
                HashMap<String, String> customer = new HashMap<String, String>();
                customer.put("id", cursor.getString(cursor.getColumnIndex(Customer.ID)));
                customer.put("custNo", cursor.getString(cursor.getColumnIndex(Customer.CcustNo)));
                customer.put("custName", cursor.getString(cursor.getColumnIndex(Customer.CcustName)));
                customer.put("town", cursor.getString(cursor.getColumnIndex(Customer.Ttown)));
                customer.put("county", cursor.getString(cursor.getColumnIndex(Customer.Ccounty)));
                customer.put("country", cursor.getString(cursor.getColumnIndex(Customer.Ccounty)));
                customer.put("phoneNo", cursor.getString(cursor.getColumnIndex(Customer.PphoneNo)));
                customer.put("contactPerson", cursor.getString(cursor.getColumnIndex(Customer.CcontactPerson)));
                customer.put("email", cursor.getString(cursor.getColumnIndex(Customer.Eemail)));
                customer.put("currency1", cursor.getString(cursor.getColumnIndex(Customer.Ccurrency1)));
                customer.put("discount", cursor.getString(cursor.getColumnIndex(Customer.Ddiscount)));
                customerList.add(customer);

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return customerList;

    }

    public Customer getCustomerById(int Id){

        SQLiteDatabase db = custdatabaseHelper.getReadableDatabase();
        String selectQuery =  "SELECT  " +
                Customer.ID + "," +
                Customer.CcustNo + "," +
                Customer.CcustName + "," +
                Customer.Ttown + "," +
                Customer.Ccounty + "," +
                Customer.Ccountry + "," +
                Customer.PphoneNo + "," +
                Customer.CcontactPerson + "," +
                Customer.Eemail + "," +
                Customer.Ccurrency1 + "," +
                Customer.Ddiscount +
                " FROM " + Customer.TABLE
                + " WHERE " +
                Customer.ID + "=?";

        Customer customer = new Customer();

        Cursor cursor = db.rawQuery(selectQuery, new String[] { String.valueOf(Id) } );

        if (cursor.moveToFirst()) {
            do {
                customer.cust_ID =cursor.getInt(cursor.getColumnIndex(Customer.ID));
                customer.custNo =cursor.getInt(cursor.getColumnIndex(Customer.CcustNo));
                customer.custName=cursor.getString(cursor.getColumnIndex(Customer.CcustName));
                customer.town=cursor.getString(cursor.getColumnIndex(Customer.Ttown));
                customer.county =cursor.getString(cursor.getColumnIndex(Customer.Ccounty));
                customer.country =cursor.getString(cursor.getColumnIndex(Customer.Ccountry));
                customer.phoneNo =cursor.getString(cursor.getColumnIndex(Customer.PphoneNo));
                customer.contactPerson =cursor.getString(cursor.getColumnIndex(Customer.CcontactPerson));
                customer.email  =cursor.getString(cursor.getColumnIndex(Customer.Eemail));
                customer.currency1  =cursor.getString(cursor.getColumnIndex(Customer.Ccurrency1));
                customer.discount =cursor.getInt(cursor.getColumnIndex(Customer.Ddiscount));

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return customer;

    }

}
