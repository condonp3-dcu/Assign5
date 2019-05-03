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
 */

/**
 * Define fields to represent Product table columns:
 */
public class Product {
    // table name
    public static final String TABLE = "Product";

    // Table Columns names
    public static final String KEY_ID = "id";
    public static final String KEY_productCode = "productCode";
    public static final String KEY_classs = "classs";
    public static final String KEY_grade = "grade";
    public static final String KEY_thickness = "thickness";
    public static final String KEY_moq = "moq";
    public static final String KEY_m2Tariff = "m2Tariff";
    public static final String KEY_description = "description";
    public static final String KEY_jpegImageId = "jpegImageId";

    // declare vars data
    public int product_ID;
    public int productCode;
    public String classs;
    public String grade;
    public int thickness;
    public int moq;
    public float m2Tariff;
    public String description;
    public String jpegImageId;

}
