package com.example.boostcoursepractice;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button serviceStartBtn ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        serviceStartBtn = (Button) findViewById(R.id.btn_start_service);
        editText = (EditText) findViewById(R.id.editText);

        serviceStartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editText.getText().toString();

                Intent intent = new Intent(getApplicationContext(), MyService.class);
                intent.putExtra("command", "show");
                intent.putExtra("name", name) ;
                startService(intent);

            }
        });

        Intent intent = getIntent() ;
        processCommand(intent) ;
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

        processCommand(intent) ;
    }

    private void processCommand(Intent intent)
    {
        if(intent != null)
        {
            String command = intent.getStringExtra("command") ;
            String name = intent.getStringExtra("name");
            Toast.makeText(getApplicationContext(), "서비스로부터 전달 받은 데이터 : " + command + ", " + name, Toast.LENGTH_LONG).show();

        }
    }
}
