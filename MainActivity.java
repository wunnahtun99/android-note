package com.example.wunna.web;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    Button download;
    ImageView downloadImage;

    public class ImageDownloader extends AsyncTask<String,Void,Bitmap>{

        @Override
        protected Bitmap doInBackground(String... urls) {

            try {
                URL url=new URL(urls[0]);
                HttpURLConnection connection=(HttpURLConnection)url.openConnection();
                connection.connect();
                InputStream inputStream=connection.getInputStream();
                Bitmap bitmap= BitmapFactory.decodeStream(inputStream);
                return bitmap;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }


    public void downloadImage(View view){
        //URL https://i.pinimg.com/originals/c7/43/a5/c743a5c03efdf60b1e57f22087a288ea.jpg

        ImageDownloader task=new ImageDownloader();
        Bitmap myImage;
        try {
            myImage=task.execute("https://i.pinimg.com/originals/c7/43/a5/c743a5c03efdf60b1e57f22087a288ea.jpg").get();
            downloadImage.setImageBitmap(myImage);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        download= (Button) findViewById(R.id.button);
        downloadImage= (ImageView) findViewById(R.id.imageView);



    }
}
