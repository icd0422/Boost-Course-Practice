package com.example.boostcoursepractice;

import android.os.AsyncTask;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.Menu;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    ValueHandler valueHandler;
    Handler handler2;

    int value = 0;
    boolean running = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        valueHandler = new ValueHandler();

        handler2 = new Handler();

        textView = (TextView) findViewById(R.id.textView);

        Button button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //new BackgroundThread().start();

                new Thread(new Runnable() {

                    int threadValue = 0;
                    //int value = 0;

                    @Override
                    public void run() {
                        running = true;
                        while (running) {
                            //value += 1;
                            threadValue += 1;
                            handler2.post(new Runnable() {
                                @Override
                                public void run() {
                                    value += 1;
                                    textView.setText("현재 값" + value);
                                }
                            });

                            try {
                                Thread.sleep(1);
                            } catch (Exception e) {
                            }
                        }

                        Log.d("JJH", "threadValue 값 : " + threadValue);
                        //Log.d("JJH", "value 값 : " + value);
                    }
                }).start();
            }
        });

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //new BackgroundThread().start();
                new AsyncBackground().execute();
            }
        });

        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                running = false;
            }
        });

        Button button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //textView.setText("현재 값 : " + value);
            }
        });
    }

    class BackgroundThread extends Thread {

        int threadValue = 0;
        //int value = 0;

        public void run() {
            running = true;
            while (running) {
                //value += 1;
                threadValue += 1;
                Message message = valueHandler.obtainMessage();
                //Bundle bundle = new Bundle();
                //bundle.putInt("value", value);
                //message.setData(bundle);
                valueHandler.sendMessage(message);
                try {
                    Thread.sleep(1);
                } catch (Exception e) {
                }
            }

            Log.d("JJH", "threadValue 값 : " + threadValue);
            //Log.d("JJH", "value 값 : " + value);
        }


    }

    class ValueHandler extends Handler {

        int sum = 0;

        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);

            value += 1;
            //Bundle bundle = msg.getData();
            //int value = bundle.getInt("value");

            textView.setText("현재 값 : " + value);
            //textView.setText("메세지큐의 마지막 값 : " + value);
        }
    }

    class AsyncBackground extends AsyncTask<String, Integer, Integer> {
        int threadValue = 0;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            running = true;
        }

        @Override
        protected Integer doInBackground(String... strings) {
            while (running) {
                threadValue += 1;
                publishProgress();
                try {
                    Thread.sleep(1);
                } catch (Exception e) {
                }


            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);

            value += 1;
            textView.setText("현재 값 : " + value);
        }

        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);

            Log.d("JJH", "threadValue 값 : " + threadValue);
        }
    }
}




