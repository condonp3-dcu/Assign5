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
 * Displays Product Detail and allows user to save,delete ,close
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * productdetail fields displayed in screen for inputting product data for saving,
 * updating,deleting
 * @ProductUpdate
 */

public class ProductDetail extends AppCompatActivity   implements android.view.View.OnClickListener {

    Button buttonSave;
    Button buttonDelete;
    Button buttonClose;
    EditText editTextProductCode;
    EditText editTextClasss;
    EditText editTextGrade;
    EditText editTextThickness;
    EditText editTextMoq;
    EditText editTextM2Tariff;
    EditText editTextDescription;
    EditText editTextJpegImageId;

    private int _Product_Id = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_detail_activity);

        buttonSave = findViewById(R.id.buttonSave);
        buttonSave.setOnClickListener(this);

        buttonDelete = findViewById(R.id.btnDelete);
        buttonDelete.setOnClickListener(this);

        buttonClose = findViewById(R.id.buttonClose);
        buttonClose.setOnClickListener(this);

        editTextProductCode = findViewById(R.id.editTextCustNo);
        editTextClasss = findViewById(R.id.editTextCustName);
        editTextGrade = findViewById(R.id.editTextTown);
        editTextThickness = findViewById(R.id.editTextCounty);
        editTextMoq = findViewById(R.id.editTextCountry);
        editTextM2Tariff = findViewById(R.id.editTextPhoneNo);
        editTextDescription = findViewById(R.id.editTextContactPerson);
        editTextJpegImageId = findViewById(R.id.editTextJpegImageId);

        _Product_Id = 0;

        Intent intent = getIntent();
        _Product_Id = intent.getIntExtra("product_Id", 0);
        ProductUpdate update = new ProductUpdate(this);
        Product product = new Product();
        product = update.getProductById(_Product_Id);
        editTextProductCode.setText(String.valueOf(product.productCode));
        editTextClasss.setText(product.classs);
        editTextGrade.setText(product.grade);
        editTextThickness.setText(String.valueOf(product.thickness));
        editTextMoq.setText(String.valueOf(product.moq));
        editTextM2Tariff.setText(String.valueOf(product.m2Tariff));
        editTextDescription.setText(product.description);
        editTextJpegImageId.setText(product.jpegImageId);
    }


    public void onClick(View view) {
        if (view == findViewById(R.id.buttonSave)) {
            ProductUpdate update = new ProductUpdate(this);
            Product product = new Product();
            product.productCode = Integer.parseInt(editTextProductCode.getText().toString());
            product.classs = editTextClasss.getText().toString();
            product.grade = editTextGrade.getText().toString();
            product.thickness = Integer.parseInt(editTextThickness.getText().toString());
            product.moq = Integer.parseInt(editTextMoq.getText().toString());
            product.m2Tariff = Float.parseFloat(editTextM2Tariff.getText().toString());
            product.description = editTextDescription.getText().toString();
            product.jpegImageId = editTextJpegImageId.getText().toString();
            product.product_ID = _Product_Id;

            if (_Product_Id == 0) {
                _Product_Id = update.insert(product);

                Toast.makeText(this, "New Product Insert", Toast.LENGTH_SHORT).show();
            } else {

                update.update(product);
                Toast.makeText(this, "Product Record updated", Toast.LENGTH_SHORT).show();
            }
        } else if (view == findViewById(R.id.btnDelete)) {
            ProductUpdate update = new ProductUpdate(this);
            update.delete(_Product_Id);
            Toast.makeText(this, "Product Record Deleted", Toast.LENGTH_SHORT);
            finish();
        } else if (view == findViewById(R.id.buttonClose)) {
            finish();
        }


    }

}