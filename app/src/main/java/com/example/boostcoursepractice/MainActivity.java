package com.example.boostcoursepractice;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;

import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.net.URL;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    TextView textView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView textView= (TextView) findViewById(R.id.textView);

        Button button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int status = NetworkStatus.getConnectivityStatus(getApplicationContext());

                if(status == NetworkStatus.TYPE_MOBILE)
                {
                    textView.setText("모바일로 연결됨");
                }else if(status == NetworkStatus.TYPE_WIFI)
                {
                    textView.setText("무선랜으로 연결됨");
                }else{
                    textView.setText("연결 안됨");
                }
            }
        });

    }
}