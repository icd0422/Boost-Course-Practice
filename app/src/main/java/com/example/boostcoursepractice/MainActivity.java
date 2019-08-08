package com.example.boostcoursepractice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button ;
    Button button2 ;
    MainFragment mainFragment;
    SubFragment subFragment;
    //FrameLayout frameLayout ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainFragment = new MainFragment();
        subFragment  = new SubFragment();

        button = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);
        //        //frameLayout = (FrameLayout) findViewById(R.id.frame_layout);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //getSupportFragmentManager().beginTransaction().add(R.id.frame_layout, mainFragment).commit();
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, mainFragment).commit();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, subFragment).commit();
            }
        });
    }

    public void chageFragement(int n)
    {
        if(n == 0)
        {
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, mainFragment).commit();
        }
        else if(n==1)
        {
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, subFragment).commit();
        }
    }
}

