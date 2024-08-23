package com.example.mycameraw;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private static int CAMERA_PERMISSION_CODE=100;
    private static int VIDEO_RECORD_CODE=101;
    private Uri videoPath;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(isCameraPresentInPhone())
        {
            Log.i("VIDEO_RECORD_TAG","Camera is detected");
            getCameraPermission();
        }
        else {
            Log.i("VIDEO_RECORD_TAG","Camera is not detected");
        }
    }
    private boolean isCameraPresentInPhone()
    {
        if(getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_ANY)){
            return true;
        }
        else{
            return false;
        }
    }
    public void recordVideoButtonPressed(View view){
        recordVideo();
    }
    private void getCameraPermission(){
        if (ContextCompat.checkSelfPermission(this,
                android.Manifest.permission.CAMERA)==PackageManager.PERMISSION_DENIED){
            ActivityCompat.requestPermissions(this, new String[]
                    {android.Manifest.permission.CAMERA},CAMERA_PERMISSION_CODE);
        }
    }
    private void recordVideo(){
        Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        startActivityForResult(intent,VIDEO_RECORD_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==VIDEO_RECORD_CODE){
            if(resultCode==RESULT_OK){
                videoPath=data.getData();
                Log.i("VIDEO_RECORD_TAG","Video is recorded and avaibale at path" + videoPath);
            } else if (resultCode==RESULT_CANCELED) {
                Log.i("VIDEO_RECORD_TAG", "Recording Video cancelled");
            }
            else{
                Log.i("VIDEO_RECORD_TAG", "Recording Video error");
            }
        }
    }
}