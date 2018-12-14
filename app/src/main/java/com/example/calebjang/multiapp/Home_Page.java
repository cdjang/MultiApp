package com.example.calebjang.multiapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;

import android.widget.Spinner;
import com.github.clans.fab.FloatingActionMenu;
import com.github.clans.fab.FloatingActionButton;


public class Home_Page extends AppCompatActivity {

    //Declare any variables up here to keep items cleaner
    //These are the FAB Variables
    FloatingActionButton floatingActionButton1, floatingActionButton2, floatingActionButton3;
    FloatingActionMenu materialDesignFAM;


    //On create method which sets all of the defaulted items,
    //such as background colors and instantiating any of the
    //buttons and views
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getWindow().getDecorView().setBackgroundColor(Color.WHITE);
        getSupportActionBar().hide();

        //Create spinner elements
        Spinner spinner = (Spinner) findViewById(R.id.SPINNER_HOME);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.spinnerItems,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        //Create the floating action buttons
        materialDesignFAM = (FloatingActionMenu) findViewById(R.id.material_design_android_floating_action_menu);
        floatingActionButton1 = (FloatingActionButton) findViewById(R.id.material_design_floating_action_menu_item1);
        floatingActionButton2 = (FloatingActionButton) findViewById(R.id.material_design_floating_action_menu_item2);
        floatingActionButton3 = (FloatingActionButton) findViewById(R.id.material_design_floating_action_menu_item3);

        //Creates floating action buttons and sets each one to open
        //a new intent when clicked
        floatingActionButton1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Help_Page.class);
                startActivity(intent);
            }
        });
        floatingActionButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Picture_Page.class);
                startActivity(intent);
            }
        });
        floatingActionButton3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Settings.class);
                startActivity(intent);
            }
        });
    }


    //Currently not used
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home_page, menu);
        return true;
    }

    //Currently not used
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        /*Handle action bar item clicks here. The action bar will
        automatically handle clicks on the Home/Up button, so long
        as you specify a parent activity in AndroidManifest.xml.*/
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    public void letsGoButton(View view){
        //Creates spinner and button
        final Spinner letsGo = (Spinner) findViewById(R.id.SPINNER_HOME);
        Button button = (Button)findViewById(R.id.BUTTON_HOME);

        //Sets button listener to wait on click
        //method then takes the spinner item, converts it to a string
        //and then does an if statement, depending on that stirng value
        //to open up a seperate activity for that value
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String spinnerText = letsGo.getSelectedItem().toString();
                //Creates a new intent and activity for each new page
                //that is added, can allow for as many additions as needed
                //Just be sure to add the page to strings page as well
                if (spinnerText.equals("Duel Calculator")) {
                    Intent intent = new Intent(v.getContext(), Duel_Calculator.class);
                    startActivity(intent);
                }else if (spinnerText.equals("Night Mode")){
                    Intent intent = new Intent(v.getContext(), Night_Mode.class);
                    startActivity(intent);
                }else if (spinnerText.equals("Facebook")){
                    Intent intent = new Intent(v.getContext(), Facebook_Page.class);
                    startActivity(intent);
                }else if (spinnerText.equals("Database")){
                    Intent intent = new Intent(v.getContext(), Database.class);
                    startActivity(intent);
                }else if (spinnerText.equals("Workout")){
                    Intent intent = new Intent(v.getContext(), Workout_Page.class);
                    startActivity(intent);
                }else if (spinnerText.equals("Tabs")){
                    Intent intent = new Intent(v.getContext(), Tabs_Page.class);
                    startActivity(intent);
                }else if (spinnerText.equals("Login")){
                    Intent intent = new Intent(v.getContext(), LoginActivity.class);
                    startActivity(intent);
                }else if (spinnerText.equals("Weather")){
                Intent intent = new Intent(v.getContext(), Weather_Page.class);
                startActivity(intent);
            }
            }
        });
    }




}
