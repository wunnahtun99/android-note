package com.example.wunna.timetable;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeekBar timeSeekBar= (SeekBar) findViewById(R.id.seekBar);
        ListView timeList=(ListView) findViewById(R.id.timeTableList);
        timeSeekBar.setMax(20);
        timeSeekBar.setProgress(10);
        timeSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int min=1;
                int timeTable;
                if (progress<min){
                    timeTable=min;
                }
                else {
                    timeTable=progress;
                }
                Log.i("Seek Bar value", String.valueOf(timeTable));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}
