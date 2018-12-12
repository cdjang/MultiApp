package com.example.calebjang.multiapp;

        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;


public class Workout_Details_Page extends AppCompatActivity {

    public static final String EXTRA_WORKOUT_ID = "id";

    //Creates the activity, then calls the fragment so it can be used
    //within the activity as well
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout__details__page);
        Workout_Detail_Fragment frag = (Workout_Detail_Fragment)
                getSupportFragmentManager().findFragmentById(R.id.detail_frag);
        //Gets the id from the intent opened bassed on its location,
        //thus if clicking the second item in the list it returns id 2
        int workoutId = (int) getIntent().getExtras().get(EXTRA_WORKOUT_ID);
        frag.setWorkout(workoutId);
    }
}
