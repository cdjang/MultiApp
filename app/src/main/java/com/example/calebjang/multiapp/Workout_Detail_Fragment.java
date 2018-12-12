package com.example.calebjang.multiapp;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class Workout_Detail_Fragment extends Fragment {
    private long workoutId;

    //Inflaters the layout so they can be called as objects, then inflates
    //the fragment workout layout
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_workout__detail, container, false);
    }

    //On start, gets the view from the activity, and sets the text title and
    //description as the workout ids, then calls the setters to set them
    @Override
    public void onStart() {
        super.onStart();
        View view = getView();
        if (view != null) {
            TextView title = (TextView) view.findViewById(R.id.textTitle);
            Workout workout = Workout.workouts[(int) workoutId];
            title.setText(workout.getName());
            TextView description = (TextView) view.findViewById(R.id.textDescription);
            description.setText(workout.getDescription());
        }
    }


    //Sets workout id to passed id
    public void setWorkout(long id){
        this.workoutId = id;
    }
}
