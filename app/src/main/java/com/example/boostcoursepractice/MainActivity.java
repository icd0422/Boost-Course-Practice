package com.example.boostcoursepractice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       /* ActionBar abar = getSupportActionBar();
        abar.hide();*/


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int curId = item.getItemId();

        switch (curId) {
            case R.id.menu_12:
                Toast.makeText(this, "12클릭됨", Toast.LENGTH_SHORT).show();
                break;

            case R.id.menu_15:
                Toast.makeText(this, "15클릭됨", Toast.LENGTH_SHORT).show();
                break;

            case R.id.menu_19:
                Toast.makeText(this, "19클릭됨", Toast.LENGTH_SHORT).show();
                break;

            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}

