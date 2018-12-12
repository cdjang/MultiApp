package com.example.calebjang.multiapp;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Night_Mode extends AppCompatActivity {
    //Creates the variables needed for the page
    boolean dark_mode = false;
    Button button;

    //On create method that sets all of the default items, such as action bar
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_night__mode);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Creates button and cats it to the button xml view
        button = (Button)findViewById(R.id.buttonDark);
    }

    //Creates the method darkButton and is set to an onclick value
    //when the button is clicked, set from the XML side
    public void darkButton(View view){

        //If dark mode is false, as in the screen is white,  change the theme
        //to the dark theme, set the content view to dark, and the root view
        //layout to dark, then view a toast showing night mode is on
        if (dark_mode == false){
            setTheme(R.style.ThemeOverlay_AppCompat_Dark);
            getApplication().setTheme(R.style.AppTheme_Dark);
            setContentView(R.layout.activity_night__mode);
            View but = findViewById(R.id.buttonDark);
            View root = but.getRootView();
            root.setBackgroundColor(Color.parseColor("#111111"));
            String msg = "Night Mode Enabled!";
            Toast toast = Toast.makeText(this,msg,Toast.LENGTH_SHORT);
            toast.show();
            dark_mode = true;

        //If dark mode is true, as in the screen is dark,  change the theme
        //to the light theme, set the content view to light, and the root view
        // layout to light, then view a toast showing night mode is off
        }else{
            setTheme(R.style.AppTheme);
            getApplication().setTheme(R.style.AppTheme);
            setContentView(R.layout.activity_night__mode);
            View but = findViewById(R.id.buttonDark);
            View root = but.getRootView();
            root.setBackgroundColor(Color.parseColor("#ffffff"));
            String msg = "Night Mode Disabled!";
            Toast toast = Toast.makeText(this,msg,Toast.LENGTH_SHORT);
            toast.show();
            dark_mode = false;
        }
    }

    //A change text method that can be used to display and change
    //the text value of the night mode button
    public void changeText(){
        button.setText("Change");
    }
}
