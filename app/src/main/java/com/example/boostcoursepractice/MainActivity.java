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

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {

    Button button;
    TextView textView ;
    Handler handler ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        handler = new Handler() ;
        textView = (TextView) findViewById(R.id.textView) ;
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new ClientThread().start();
            }
        });
    }

    class ClientThread extends Thread {

        @Override
        public void run() {
            //super.run();
            String host = "localhost";
            int port = 5001;

            try {
                Socket socket = new Socket(host, port);

                ObjectOutputStream outstream = new ObjectOutputStream(socket.getOutputStream());
                outstream.writeObject("안녕!");
                outstream.flush();
                Log.d("ClientThread", "서버로 보냄.");

                ObjectInputStream instream  = new ObjectInputStream(socket.getInputStream());
                final Object input = instream.readObject() ;
                Log.d("ClientThread", "받은 데이터 : " + input);

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        textView.setText("받은 데이터 : " + input);
                    }
                }) ;

                socket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

}




