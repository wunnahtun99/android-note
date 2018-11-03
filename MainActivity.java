package com.example.wunna.timetable;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       final Handler handle=new Handler();
        Runnable run=new Runnable() {
            @Override
            public void run() {
                Log.i("delay","1s");
                handle.postDelayed(this,1000);

            }
        };
        handle.post(run);

    }
}
