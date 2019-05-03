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

public class ProductUpdate {
    private DatabaseHelper databaseHelper;
    public ProductUpdate(Context context) {
        databaseHelper = new DatabaseHelper(context);
    }

    public int insert(Product product) {

        //Open connection to write data
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Product.KEY_productCode, product.productCode);
        values.put(Product.KEY_classs,product.classs);
        values.put(Product.KEY_grade, product.grade);
        values.put(Product.KEY_thickness, product.thickness);
        values.put(Product.KEY_moq,product.moq);
        values.put(Product.KEY_m2Tariff, product.m2Tariff);
        values.put(Product.KEY_description,product.description);
        values.put(Product.KEY_jpegImageId, product.jpegImageId);
        // Inserting Row
        long product_Id = db.insert(Product.TABLE, null, values);
        db.close(); // Closing database connection
        return (int) product_Id;

    }

    public void delete(int product_Id) {

        SQLiteDatabase db = databaseHelper.getWritableDatabase();

        db.delete(Product.TABLE, Product.KEY_ID + "= ?", new String[] { String.valueOf(product_Id) });
        db.close(); // Closing database connection
    }

    public void update(Product product) {

        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Product.KEY_productCode, product.productCode);
        values.put(Product.KEY_classs,product.classs);
        values.put(Product.KEY_grade, product.grade);
        values.put(Product.KEY_thickness, product.thickness);
        values.put(Product.KEY_moq,product.moq);
        values.put(Product.KEY_m2Tariff, product.m2Tariff);
        values.put(Product.KEY_description, product.description);
        values.put(Product.KEY_jpegImageId, product.jpegImageId);


        db.update(Product.TABLE, values, Product.KEY_ID + "= ?", new String[] { String.valueOf(product.product_ID) });
        db.close(); // Closing database connection
    }

    public ArrayList<HashMap<String, String>>  getProductList() {
        //Open connection to read only
        SQLiteDatabase db = databaseHelper.getReadableDatabase();
        String selectQuery =  "SELECT  " +
                Product.KEY_ID + "," +
                Product.KEY_productCode + "," +
                Product.KEY_classs + "," +
                Product.KEY_grade + "," +
                Product.KEY_thickness + "," +
                Product.KEY_moq+ "," +
                Product.KEY_m2Tariff + "," +
                Product.KEY_description + "," +
                Product.KEY_jpegImageId +
                " FROM " + Product.TABLE;


        ArrayList<HashMap<String, String>> productList = new ArrayList<HashMap<String, String>>();

        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list

        if (cursor.moveToFirst()) {
            do {
                HashMap<String, String> product = new HashMap<String, String>();
                product.put("id", cursor.getString(cursor.getColumnIndex(Product.KEY_ID)));
                product.put("productCode", cursor.getString(cursor.getColumnIndex(Product.KEY_productCode)));
                product.put("classs", cursor.getString(cursor.getColumnIndex(Product.KEY_classs)));
                product.put("grade", cursor.getString(cursor.getColumnIndex(Product.KEY_grade)));
                product.put("thickness", cursor.getString(cursor.getColumnIndex(Product.KEY_thickness)));
                product.put("moq", cursor.getString(cursor.getColumnIndex(Product.KEY_moq)));
                product.put("m2Tariff", cursor.getString(cursor.getColumnIndex(Product.KEY_m2Tariff)));
                product.put("description", cursor.getString(cursor.getColumnIndex(Product.KEY_description)));
                product.put("jpegImageId", cursor.getString(cursor.getColumnIndex(Product.KEY_jpegImageId)));
                productList.add(product);

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return productList;

    }

    public Product getProductById(int Id){
        SQLiteDatabase db = databaseHelper.getReadableDatabase();
        String selectQuery =  "SELECT  " +
                Product.KEY_ID + "," +
                Product.KEY_productCode + "," +
                Product.KEY_classs + "," +
                Product.KEY_grade + "," +
                Product.KEY_thickness + "," +
                Product.KEY_moq + "," +
                Product.KEY_m2Tariff + "," +
                Product.KEY_description + "," +
                Product.KEY_jpegImageId +
                " FROM " + Product.TABLE
                + " WHERE " +
                Product.KEY_ID + "=?";


        Product product = new Product();

        Cursor cursor = db.rawQuery(selectQuery, new String[] { String.valueOf(Id) } );

        if (cursor.moveToFirst()) {
            do {
                product.product_ID =cursor.getInt(cursor.getColumnIndex(Product.KEY_ID));
                product.productCode =cursor.getInt(cursor.getColumnIndex(Product.KEY_productCode));
                product.classs=cursor.getString(cursor.getColumnIndex(Product.KEY_classs));
                product.grade =cursor.getString(cursor.getColumnIndex(Product.KEY_grade));
                product.thickness =cursor.getInt(cursor.getColumnIndex(Product.KEY_thickness));
                product.moq =cursor.getInt(cursor.getColumnIndex(Product.KEY_moq));
                product.m2Tariff =cursor.getFloat(cursor.getColumnIndex(Product.KEY_m2Tariff));
                product.description  =cursor.getString(cursor.getColumnIndex(Product.KEY_description));
                product.jpegImageId =cursor.getString(cursor.getColumnIndex(Product.KEY_jpegImageId));

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return product;
    }

}
