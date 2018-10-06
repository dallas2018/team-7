package com.example.sshahi.codeforgood;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
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
import com.microsoft.projectoxford.vision.contract.Caption;
import com.microsoft.projectoxford.vision.rest.VisionServiceException;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {
public VisionServiceClient visionServiceClient = new VisionServiceRestClient("a7e12e49f690477f8ef9cfa1f1865ab0");
   ProgressDialog mDialog = new ProgressDialog(MainActivity.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bitmap mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.cute_girl);
        ImageView imageView = (ImageView)findViewById(R.id.imageView);
        Button btnProcess = (Button)findViewById(R.id.btnProcess);

        imageView.setImageBitmap(mBitmap);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        mBitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);
        final ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());

        btnProcess.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                @SuppressLint("StaticFieldLeak") final AsyncTask<InputStream, String , String> visionTask = new AsyncTask<InputStream, String, String>() {
                    @Override
                    protected String doInBackground(InputStream... params) {
                         try{
                             publishProgress("Recognizing....");
                             String[] features = {"Description"};
                             String[] details = {};
                             AnalysisResult result = visionServiceClient.analyzeImage(params[0],features, details);

                             String strResult = new Gson().toJson(result);
                             return strResult;

                         } catch (Exception e) {
                              return null;

                         }

                        }

                    @Override
                    public void onPreExecute(){
                        mDialog.show();
                    }
                    @Override
                    public void onPostExecute(String s){
                        mDialog.dismiss();

                        AnalysisResult result = new Gson().fromJson(s, AnalysisResult.class);
                        TextView textView = (TextView)findViewById(R.id.txtDescription);
                        StringBuilder stringBuilder = new StringBuilder();
                         for (Caption caption: result.description.captions)
                         {
                             stringBuilder.append(caption.text);
                         }
                         textView.setText(stringBuilder);

                    }

                    @Override
                    public void onProgressUpdate(String... values){

                        mDialog.setMessage(values[0 ]);
                    }



                };

                visionTask.execute(inputStream);
            }
        });

    }
}
