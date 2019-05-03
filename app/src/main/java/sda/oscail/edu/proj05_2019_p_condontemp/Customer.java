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
 * Define fields to represent Customer table columns:
 */
public class Customer {
    // table name
    public static final String TABLE = "Customer";

    // Table Columns names
    public static final String ID = "id";
    public static final String CcustNo = "custNo";
    public static final String CcustName = "custName";
    public static final String Ttown = "town";
    public static final String Ccounty = "county";
    public static final String Ccountry = "country";
    public static final String PphoneNo = "phoneNo";
    public static final String CcontactPerson = "contactPerson";
    public static final String Eemail = "email";
    public static final String Ccurrency1 = "currency1";
    public static final String Ddiscount = "discount";

    // declare vars:
    public int cust_ID;
    public int custNo;
    public String custName;
    public String town;
    public String county;
    public String country;
    public String phoneNo;
    public String contactPerson;
    public String email;
    public String currency1;
    public int discount;

}
