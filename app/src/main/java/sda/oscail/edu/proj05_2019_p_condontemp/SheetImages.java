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
 * Define sheet images here:
 */

public class SheetImages {

    // Name of the Sheet Type
    private String mName;
    // Product Code
    private String mProductCode;


    // Drawable resource ID
    private int mImageResourceId;

    /*
     * Create a new SheetImages object. */

    public SheetImages(String fName, String fCode, int imageResourceId)
    {
        mName = fName;
        mProductCode = fCode;
        mImageResourceId = imageResourceId;
    }

    /**
     * Get the name of the Sheet :
     */
    public String getSheetName() {
        return mName;
    }

    /**
     * Get the Product Code
     */
    public String getSheetNumber() {
        return mProductCode;
    }

    /**
     * Get the image resource ID
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }


}

