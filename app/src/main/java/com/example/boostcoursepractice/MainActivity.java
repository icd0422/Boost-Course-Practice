package com.example.boostcoursepractice;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
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

    EditText editText ;
    EditText editText2 ;
    EditText editText3 ;
    EditText editText4 ;
    EditText editText5  ;
    TextView textView;
    SQLiteDatabase database ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);
        editText2 = (EditText) findViewById(R.id.editText2);
        editText3 = (EditText) findViewById(R.id.editText3);
        editText4 = (EditText) findViewById(R.id.editText4);
        editText5 = (EditText) findViewById(R.id.editText5);

        textView = (TextView) findViewById(R.id.textView);

        Button button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String databaseName = editText.getText().toString();
                openDatabase(databaseName);
            }
        });

        Button button2 = (Button) findViewById(R.id.button2);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tableName = editText2.getText().toString();
                createTable(tableName);
            }
        });

        Button button3 = (Button) findViewById(R.id.button3);

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editText3.getText().toString().trim();
                String ageStr = editText4.getText().toString().trim();
                String mobile = editText5.getText().toString().trim();

                int age = -1 ;
                try{
                    age = Integer.parseInt(ageStr);
                }catch (Exception e) {
                    e.printStackTrace();
                }

                insertData(name, age, mobile);

            }
        });

        Button button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tableName = editText2.getText().toString();
                selectData(tableName);
            }
        });
    }

    public void openDatabase(String databaseName)
    {
        println("openDatabase() 호출됨");
        database = openOrCreateDatabase(databaseName, MODE_PRIVATE, null);

        if(database != null)
        {
            println("데이터 베이스 오픈됨");
        }

    }

    public void createTable(String tableName)
    {
        println("crateTable() 호출됨");

        if(database !=null)
        {
            String sql = "create table " + tableName + "(_id integer PRIMARY KEY autoincrement , name text, age integer, mobile text) ";
            database.execSQL(sql);

            println("테이블 생성됨.");
        }else{
            println("먼저 데이터베이스를 오픈하세요");
        }
    }

    public void insertData(String name, int age, String mobile)
    {
        println("insertData() 호출됨");

        if(database != null)
        {
            String sql = "insert into customer(name, age, mobile) values(?,?,?)";
            Object[] params = {name, age, mobile};

            database.execSQL(sql, params);
            println("데이터 추가됨");
        }else{
            println("먼저 데이터베이스를 오픈하세요.");
        }
    }

    public void selectData(String tableName)
    {
        println("selectData() 호출됨");

        if(database != null)
        {
            String sql = "select name, age, mobile from " + tableName ;
            Cursor cursor = database.rawQuery(sql, null);
            println("조회된 데이터 개수 : " + cursor.getCount());

            for(int i=0 ; i<cursor.getCount() ; i++)
            {
                cursor.moveToNext();
                String name = cursor.getString(0);
                int age = cursor.getInt(1);
                String mobile = cursor.getString(2) ;

                println("#" + i + "->" + name + ", " + age + ", " + mobile);
            }

            cursor.close();
        }
    }


    public void println(String s)
    {
        textView.append(s+"\n");
    }

}