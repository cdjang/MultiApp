package com.example.calebjang.multiapp;


//Separate workout class that talks to both the workout activities
//as well as the fragments
public class Workout {

    //Creates the variables needed
    private String name;
    private String description;

    //Creates workout array holding all of the text
    //makes it final so it cannot be changed
    public static final Workout[] workouts = {

            //Workout text descriptions and Details
            new Workout("The Limb Loosener",
                    "5 Handstand push-ups\n10 1-legged squats\n15 Pull-ups"),
            new Workout("Core Agony",
                    "100 Pull-ups\n100 Push-ups\n100 Sit-ups\n100 Squats"),
            new Workout("The Wimp Special",
                    "5 Pull-ups\n10 Push-ups\n15 Squats"),
            new Workout("Strength and Length",
                    "500 meter run\n21 x 1.5 pood kettleball swing\n21 x pull-ups")
    };

    //Need to make getter and setters for the private variables access
    //Each Workout has a name and description
    private Workout(String name, String description) {
        this.name = name;
        this.description = description;
    }
    public String getDescription() {
        return description;
    }
    public String getName() {
        return name;
    }
    public String toString() {
        return this.name;
    }
}