package com.example.sshahi.codeforgood;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.microsoft.projectoxford.vision.VisionServiceClient;
import com.microsoft.projectoxford.vision.VisionServiceRestClient;
import com.microsoft.projectoxford.vision.contract.AnalysisResult;
import com.microsoft.projectoxford.vision.rest.VisionServiceException;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {
public VisionServiceClient visionServiceClient = new VisionServiceRestClient("a7e12e49f690477f8ef9cfa1f1865ab0");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bitmap mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.cute_girl);
        ImageView imageView = (ImageView)findViewById(R.id.imageView);
        TextView txtView = (TextView)findViewById(R.id.txtDescription);
        Button btnProcess = (Button)findViewById(R.id.btnProcess);

        imageView.setImageBitmap(mBitmap);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        mBitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);
        ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
        btnProcess.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                AsyncTask<InputStream, String , String> visionTask = new AsyncTask<InputStream, String, String>() {
                    @Override
                    protected String doInBackground(InputStream... params) {
                         try{
                             publishProgress("Recognizing....");
                             String[] features = {"Discription"};
                             String[] details = {};
                             AnalysisResult result = visionServiceClient.analyzeImage(params[0],features, details);

                             String strResult = new Gson().toJson(result);
                             return strResult;
                         } catch (IOException e) {
                              return null;

                         }

                    }
                };
            }
        });

    }
}
