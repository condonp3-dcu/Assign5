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


import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;

public class GalleryFragment extends Fragment {

    TextView tvtoast;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

// Creating am Arraylist with wood panel names, product codes and images.
        final ArrayList<SheetImages> sheetImages = new ArrayList<SheetImages>();
        sheetImages.add(new SheetImages("Particleboard", "furniture grade", R.drawable.particleboard));
        sheetImages.add(new SheetImages("Particleboard P5", "moisture resistant load bearing", R.drawable.particleboardp5));
        sheetImages.add(new SheetImages("Particleboard P6", "heavy-duty load bearing", R.drawable.particleboardp6));
        sheetImages.add(new SheetImages("MDF", "standard grade", R.drawable.mdf));
        sheetImages.add(new SheetImages("MDF MR", "moisture resistant", R.drawable.mdfmr));
        sheetImages.add(new SheetImages("MDF FR", "flame retardant", R.drawable.mdffr));
        sheetImages.add(new SheetImages("MDF Light", "density 400kg/m3", R.drawable.mdflight));
        sheetImages.add(new SheetImages("MDF Ultralight", "density 200kg/m2", R.drawable.mdfultralight));
        sheetImages.add(new SheetImages("Alder", "veneered mdf", R.drawable.alder));
        sheetImages.add(new SheetImages("Ash", "veneered mdf", R.drawable.ash));
        sheetImages.add(new SheetImages("Beech", "veneered mdf", R.drawable.beech));
        sheetImages.add(new SheetImages("Oak", "veneered mdf", R.drawable.oak));
        sheetImages.add(new SheetImages("Pine", "veneered mdf", R.drawable.pine));
        sheetImages.add(new SheetImages("Plywood", "birch-ply", R.drawable.plywood));
        sheetImages.add(new SheetImages("Teak", "veneered mdf", R.drawable.teak));
        sheetImages.add(new SheetImages("Walnut", "veneered mdf", R.drawable.walnut));



// Create an {@link SheetImagesAdapter}, whose data source is a list of
        // {@link SheetImages}s. The adapter knows how to create list item views for each item
        // in the list.
        SheetImagesAdapter flavorAdapter = new SheetImagesAdapter(getActivity(), sheetImages);


// Get a reference to the ListView, and attach the adapter to the listView.
        View root = inflater.inflate(R.layout.productsfragment, container, false);


        final ListView listView = root.findViewById(R.id.listview_products);
        listView.setAdapter(flavorAdapter);

        // use onclicklistener to invoke callback and use toast to show the item in the clicked
// row in the listview
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override

            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                SheetImages selection = (SheetImages) listView.getItemAtPosition(position);

                // Toast to indicate the  user selection.
                Toast toast=Toast.makeText(getActivity(),"Image Resource Id: "+selection.getImageResourceId() , Toast.LENGTH_LONG);
                View view1=toast.getView();
                view1.setBackgroundColor(Color.rgb(8,255,115));
                toast.show();

            }
        });



        return root;



    }

}