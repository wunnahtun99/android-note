package com.example.wunna.timetable;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView timeList;
    public void generateTime(int timeTable){
        ArrayList<String> timeContent=new ArrayList<String>();
        for (int i=1;i<=10;i++){
            timeContent.add(String.valueOf(i*timeTable));
        }
        ArrayAdapter<String> adapeter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,timeContent);
        timeList.setAdapter(adapeter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeekBar timeSeekBar= (SeekBar) findViewById(R.id.seekBar);
        timeList=(ListView) findViewById(R.id.timeTableList);
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
           //     Log.i("Seek Bar value", String.valueOf(timeTable));
            generateTime(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        generateTime(10);


    }
}
