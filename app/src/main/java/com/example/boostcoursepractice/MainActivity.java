package com.example.boostcoursepractice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListFragment fragment1 ;
    ViewerFragment fragment2 ;

    FragmentManager manager ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = getSupportFragmentManager();

        fragment1 = (ListFragment) manager.findFragmentById(R.id.list_fragment) ;
        fragment2 = (ViewerFragment) manager.findFragmentById(R.id.viewer_fragment);

    }

    public void onImageChange(int index)
    {
        fragment2.setImage(index);

    }

}

