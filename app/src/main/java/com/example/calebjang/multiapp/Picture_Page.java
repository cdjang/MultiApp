package com.example.calebjang.multiapp;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.icu.text.SimpleDateFormat;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;
import java.util.Date;

public class Picture_Page extends AppCompatActivity {

    //Creates the variables for the app
    Button cameraButton;
    ImageView cameraImage;
    Uri file;

    //On creates the typical items such as the action bar and such
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture__page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        //Sets all of the buttons and images to their corresponding views
        cameraButton = (Button) findViewById(R.id.cameraButton);
        cameraImage = (ImageView) findViewById(R.id.cameraImage);

        //Checks to see if the user has permission to access the camera for the
        //app, if not, close the application
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            cameraButton.setEnabled(false);
            ActivityCompat.requestPermissions(this,
                    new String[] { Manifest.permission.CAMERA,
                            Manifest.permission.WRITE_EXTERNAL_STORAGE }, 0);
        }
    }

    //The request permission method, which checks the request code of the
    //camera, which enables the camera button if the request goes through
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == 0) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED
                    && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                cameraButton.setEnabled(true);
            }
        }
    }


    //Takes the picture method, which creates a new intent page, and sets a
    //file variable which takes the uri from the picture, and puts it in the media
    public void takePicture(View view){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        file = Uri.fromFile(getOutputMediaFile());
        intent.putExtra(MediaStore.EXTRA_OUTPUT, file);

        //Sets the policy to allow the user into the camera moce
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());
        startActivityForResult(intent, 100);
        }


    //The activity result, or the picture that is received, sets the image
    //to that picture, then rotates the image 90 degrees in order to
    //straighten out the view
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 100) {
            if (resultCode == RESULT_OK) {
                cameraImage.setImageURI(file);
                cameraImage.setRotation(90);
            }
        }
    }


    //Creates a directory for the media file to be stored in
    private static File getOutputMediaFile(){
        File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES), "CameraDemo");
        //If the directory already exists, then do not create a new directory
        if (!mediaStorageDir.exists()){
            if (!mediaStorageDir.mkdirs()){
                return null;
            }
        }
        //Prints a timestamp on the picture and allow the image to be seperated
        //per the file extension
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        return new File(mediaStorageDir.getPath() + File.separator +
                "IMG_"+ timeStamp + ".jpg");
    }
}
