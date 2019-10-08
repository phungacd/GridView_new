package com.example.gridview_new;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        List<Hotgirl> image_details = getListData();
        final GridView gridView = (GridView) findViewById(R.id.gridView);
        gridView.setAdapter(new GridView_Custom(this, image_details));


        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Object o = gridView.getItemAtPosition(position);

                Hotgirl country = (Hotgirl) o;

                Uri uri = Uri.parse(country.getUrl());

                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
    }

    private  List<Hotgirl> getListData() {
        List<Hotgirl> list = new ArrayList<Hotgirl>();
        Hotgirl ha = new Hotgirl("Nguyen Nhu Ha","a1","https://www.facebook.com/Halequynhnhu123?__tn__=%2CdC-R-R&eid=ARBn75LhHH18BcehNDLk_C0YHjP5N2ZsXU_OKoa-X7St8uwJaxrKm_SCaaD-tI0VQFlAKr9MJVa6ZIkA&hc_ref=ARS2emTWvM_Je2rVB7t9ckeNKdNqxhodN-kGa7CzU28a8v49CseqARc7InkCQE7mGRY&fref=nf");
        Hotgirl trinh = new Hotgirl("Ngoc Trinh", "a2", "https://www.facebook.com/ngoctrinhfashion89?fref=search&__tn__=%2Cd%2CP-R&eid=ARCwlK9TRIKpeee484pmnwJcXzPeveypHEoIdoqT0-40ZNpc_mVoO8LNgsyBH3NmfQ7O7h9WAjFEAKhz");
        Hotgirl linh = new Hotgirl("Chu Dieu Linh", "a3", "https://www.facebook.com/linhka1993?fref=search&__tn__=%2Cd%2CP-R&eid=ARDx4NUVCZB7pCbNGYnOz8hL9EXe1XHt-57lGvHDUIGhOIc5YbqXVOnDW8uWpyADNKBEf0ffa2oFzd5g");
        Hotgirl ngoc = new Hotgirl("Linh duong Lan Ngoc", "a4", "https://www.facebook.com/fromninhduonglanngoc/");
        Hotgirl pu = new Hotgirl("Chi Pu", "a5", "https://www.facebook.com/chipupu93/?__tn__=%2Cd%2CP-R&eid=ARBv3MA-x6d_noUJ5O48__64vTOzDJdAwyj1mLVGgShNgZqjQJHEuDrpMQ5dJpLr0WwVaLApa6LwaYr0");
        Hotgirl hi = new Hotgirl("Nguyen Huong", "a7", "https://www.facebook.com/chipupu93/?__tn__=%2Cd%2CP-R&eid=ARBv3MA-x6d_noUJ5O48__64vTOzDJdAwyj1mLVGgShNgZqjQJHEuDrpMQ5dJpLr0WwVaLApa6LwaYr0");

        list.add(ha);
        list.add(trinh);
        list.add(linh);
        list.add(ngoc);
        list.add(pu);
        list.add(hi);

        return list;
    }
}
