package com.example.boostcoursepractice;

import android.os.Bundle;

import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    ImageView imageView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        imageView = (ImageView) findViewById(R.id.imageView);

        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendImageRequest();
            }
        });
    }

    public void sendImageRequest() {
        String url = "https://lh5.googleusercontent.com/p/AF1QipP88UCg_d5npMcxmBkm_ZXqmxm2korTx5Bdya9k=w237-h160-k-no";
        ImageLoadTask task = new ImageLoadTask(url, imageView);
        task.execute();

    }
}