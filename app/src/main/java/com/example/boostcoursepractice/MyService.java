package com.example.boostcoursepractice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class MyService extends Service {

    private static final String TAG = "MyService";

    public MyService() {

    }

    @Override
    public void onCreate() {
        super.onCreate();

        Toast.makeText(getApplicationContext(), "onCreate() 호출됨.", Toast.LENGTH_LONG).show();
       // Log.d(TAG, "onCreate() 호출됨.");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //log.d(TAG, "onStartCommand() 호출됨.");
        Toast.makeText(getApplicationContext(), "onStartCommand() 호출됨.", Toast.LENGTH_LONG).show();

        //if(intent == null) return Service.START_STICKY ;
        //else processCommand(intent);
        processCommand(intent);

        return super.onStartCommand(intent, flags, startId);
    }

    private void processCommand(Intent intent)
    {
        String command = "" ;
        String name = "";
        if(intent != null)
        {
            command = intent.getStringExtra("command");
            name = intent.getStringExtra("name");
            //Log.d(TAG, "전달 받은 데이터 : " + command + ", "  +name);

        }

        Toast.makeText(getApplicationContext(), "전달 받은 데이터 : " + command + ", "  +name, Toast.LENGTH_LONG).show();

        try{
            Thread.sleep(5000);
        }
        catch (Exception e){}

        Intent showIntent = new Intent(getApplicationContext(), MainActivity.class);
        showIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_SINGLE_TOP| Intent.FLAG_ACTIVITY_CLEAR_TOP) ;
        showIntent.putExtra("command","show");
        showIntent.putExtra("name", name + "from service");
        startActivity(showIntent);
    };

    @Override
    public void onDestroy() {
        super.onDestroy();
        //Log.d(TAG, "onDestroy() 호출됨.");
        Toast.makeText(getApplicationContext(), "onDestroy() 호출됨.", Toast.LENGTH_LONG).show();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }



}
