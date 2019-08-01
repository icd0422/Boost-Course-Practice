package com.example.boostcoursepractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity {

    Button serialBtn;
    Button parcelBtn;
    Button backBtn;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        serialBtn = (Button)findViewById(R.id.serial_btn);
        parcelBtn = (Button)findViewById(R.id.parcel_btn) ;
        backBtn = (Button)findViewById(R.id.button2);
        intent = getIntent() ;

        serialBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<String> names = (ArrayList<String>) intent.getSerializableExtra("names");

                String temp = "";
                for(int i=0 ; i<names.size() ; i++)
                {
                    temp += names.get(i) + " " ;
                }
                Toast.makeText(getApplicationContext(), temp, Toast.LENGTH_LONG).show() ;
            }
        });

        parcelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               SimpleData simpleData = (SimpleData) intent.getParcelableExtra("simpleData");
                Toast.makeText(getApplicationContext(),  simpleData.number + " "+simpleData.message, Toast.LENGTH_LONG).show() ;
            }
        });



        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }








}
