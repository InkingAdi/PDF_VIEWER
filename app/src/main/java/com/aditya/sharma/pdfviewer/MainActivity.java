package com.aditya.sharma.pdfviewer;
import com.aditya.sharma.pdfviewer.constants.Constants;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        askStoragePermission(Manifest.permission.READ_EXTERNAL_STORAGE, Constants.READ_STORAGE);
        askStoragePermission(Manifest.permission.WRITE_EXTERNAL_STORAGE,Constants.WRITE_STORAGE);

    }

    public void askStoragePermission(String permission_type, Integer REQUEST_CODE){

        if(ContextCompat.checkSelfPermission(getApplicationContext(),permission_type) != PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(MainActivity.this,new String[]{permission_type},REQUEST_CODE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults)
    {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode == Constants.READ_STORAGE){
            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(MainActivity.this,"Read Permission Granted !",Toast.LENGTH_LONG).show();
            }else {
                Toast.makeText(getApplicationContext(), "Storage Read Permission Denied",Toast.LENGTH_LONG).show();
            }
        }

        if(requestCode == Constants.WRITE_STORAGE){
            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(MainActivity.this,"Storage Write Permission Granted !",Toast.LENGTH_LONG).show();
            }else {
                Toast.makeText(getApplicationContext(), "Storage Write Permission Denied",Toast.LENGTH_LONG).show();
            }
        }
    }
}