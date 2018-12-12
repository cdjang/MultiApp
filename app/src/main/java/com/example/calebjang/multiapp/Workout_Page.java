package com.example.calebjang.multiapp;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Workout_Page extends AppCompatActivity
        implements Workout_List_Fragment.Listener{
    Button showDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout__page);

        //This is for the onClick Listener in order to click a button (display)
//        showDetails = (Button)findViewById(R.id.showDetailsButton);
//        showDetailsMethod();

    }

//    public void showDetailsMethod() {
//        showDetails.setOnClickListener(
//                new View.OnClickListener(){
//                    @Override
//                    public void onClick(View view){
//                        Intent intent = new Intent(view.getContext(), Workout_Details_Page.class);
//                        startActivity(intent);
//                    }
//                }
//        );
//    }


    //This is for when the items within the list viewers are clicked, it opens
    //a new intent and then puts extra information over, which is the value of
    //its position in the list, and passes that over as the ID value
    @Override
    public void itemClicked(long id) {
        Intent intent = new Intent(this, Workout_Details_Page.class);
        intent.putExtra(Workout_Details_Page.EXTRA_WORKOUT_ID, (int)id);
        startActivity(intent);
    }
}