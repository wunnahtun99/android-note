package com.example.wunna.web;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    public class DownloadTask extends AsyncTask<String,Void,String>{

        @Override
        protected String doInBackground(String... strings) {
            String result="";
            URL url;
            HttpURLConnection urlConnection=null;
            try
            {
                url=new URL(strings[0]);
                urlConnection=(HttpURLConnection) url.openConnection();
                InputStream inputStream=urlConnection.getInputStream();
                InputStreamReader reader=new InputStreamReader(inputStream);
                int data=reader.read();
                while (data!=-1){
                    char current=(char) data;
                    result+=current;
                    data=reader.read();
                }
                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
                return "fail";
            } catch (IOException e) {
                e.printStackTrace();
                return "fail";
            }



        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DownloadTask task=new DownloadTask();
        String result=null;
        try {
             result=task.execute("https://www.ecowebhosting.co.uk/").get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        Log.i("content",result);
    }
}
