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

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 *
 * @author PC
 * @version 1.0 (current version number of program)
 * @since 15/03/2019
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    /** version number to upgrade database version
     *to Add, Edit table, change the version number
     */
    private static final int DATABASE_VERSION = 8;

    /**
     *database name
     */
    private static final String DATABASE_NAME = "sheets.db";

    public DatabaseHelper(Context context ) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * @param db SQlite database
     * create table Customer and Product (if not already created)
     */

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Create table:
        String CREATE_TABLE_PRODUCT = "CREATE TABLE " + Product.TABLE  + "("
                + Product.KEY_ID  + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                + Product.KEY_productCode + " INTEGER, "
                + Product.KEY_classs + " TEXT, "
                + Product.KEY_grade + " TEXT, "
                + Product.KEY_thickness + " INTEGER, "
                + Product.KEY_moq + " INTEGER, "
                + Product.KEY_m2Tariff + " FLOAT, "
                + Product.KEY_description + " TEXT, "
                + Product.KEY_jpegImageId + " TEXT )";

        db.execSQL(CREATE_TABLE_PRODUCT);



        String sql = "SELECT name FROM sqlite_master WHERE type='table' AND name='" + Customer.TABLE + "'";
        Cursor mCursor = db.rawQuery(sql, null);
        if (mCursor.getCount() <= 0) {

            mCursor.close();

            String CREATE_TABLE_CUSTOMER = "CREATE TABLE " + Customer.TABLE + "("
                    + Customer.ID + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                    + Customer.CcustNo + " INTEGER, "
                    + Customer.CcustName + " TEXT, "
                    + Customer.Ttown + " TEXT, "
                    + Customer.Ccounty + " TEXT, "
                    + Customer.Ccountry + " TEXT, "
                    + Customer.PphoneNo + " TEXT, "
                    + Customer.CcontactPerson + " TEXT, "
                    + Customer.Eemail + " TEXT, "
                    + Customer.Ccurrency1 + " TEXT, "
                    + Customer.Ddiscount + " INTEGER )";

            db.execSQL(CREATE_TABLE_CUSTOMER);
        }
        mCursor.close();


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if it existed
        db.execSQL("DROP TABLE IF EXISTS " + Product.TABLE);

        // Create the tables again
        onCreate(db);

    }

}
