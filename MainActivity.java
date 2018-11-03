package com.example.wunna.timetable;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView myListView=(ListView) findViewById(R.id.myListView);
        final ArrayList<String> myFamily=new ArrayList<String>();
        myFamily.add("Kel vin");
        myFamily.add("Alice");
        myFamily.add("Charly");
        myFamily.add("Kol Kol");
        myFamily.add("Co Co");
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,myFamily);
        myListView.setAdapter(arrayAdapter);
        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
             //   Log.i("person",myFamily.get(i));
                Toast.makeText(getApplicationContext(),"Hello"+myFamily.get(i),Toast.LENGTH_LONG).show();
            }
        });


    }
}
