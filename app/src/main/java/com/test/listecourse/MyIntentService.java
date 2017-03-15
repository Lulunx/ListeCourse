package com.test.listecourse;

import android.app.IntentService;
import android.content.Intent;
import android.os.CountDownTimer;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

public class MyIntentService extends IntentService {
    public int tempsRestant=5;
    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    public void onCreate()
    {
        super.onCreate();
        Log.i("TAG", "C'est parti!");
    }

    @Override
    public IBinder onBind(Intent arg0)
    {
        return null;
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        tempsRestant = 10;
        for (tempsRestant = 10 ; tempsRestant >0 ; tempsRestant--){
            try {
                TimeUnit.SECONDS.sleep(1);
                Log.i("temps ",""+tempsRestant);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Log.i("temps ","BOOOOUUUUUM");
    }
}
