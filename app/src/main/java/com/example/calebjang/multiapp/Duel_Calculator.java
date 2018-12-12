package com.example.calebjang.multiapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Duel_Calculator extends AppCompatActivity {

    //instantiates all of the button variables, edit texts, and any
    //other variables
    Button button0, button1, button2, button3, button4, button5, button6,
            button7, button8, button9, buttonPlus, buttonMinus, button00,
            button000, buttonEqual, buttonReset;
    EditText Player1LP, Player2LP;
    boolean Plus, Minus;
    int valueOne, valueTwo;
    String focus;



    //Default on create method, initializing all of the default items
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_duel__calculator);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Setting each button to find its configured view on the xml
        button0 = (Button) findViewById(R.id.button0);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        button0 = (Button) findViewById(R.id.button0);
        button00 = (Button) findViewById(R.id.button00);
        button000 = (Button) findViewById(R.id.button000);
        buttonMinus = (Button) findViewById(R.id.buttonMinus);
        buttonPlus = (Button) findViewById(R.id.buttonPlus);
        buttonEqual = (Button) findViewById(R.id.buttonEquals);
        Player1LP = (EditText) findViewById(R.id.Player1LP);
        Player2LP = (EditText) findViewById(R.id.Player2LP);
        buttonReset = (Button) findViewById(R.id.buttonReset);

        //So keyboard doesnt pup up when clicked
        Player1LP.setShowSoftInputOnFocus(false);
        Player2LP.setShowSoftInputOnFocus(false);

        //Custom on touch listeners to not allow the users to
        //touch the players LP texts
        Player1LP.setOnTouchListener(new View.OnTouchListener()
        {
            public boolean onTouch(View arg0, MotionEvent arg1)
            {
                focus = "1";
                return false;
            }
        });
        Player2LP.setOnTouchListener(new View.OnTouchListener()
        {
            public boolean onTouch(View arg0, MotionEvent arg1)
            {
                focus = "2";
                return false;
            }
        });


        //Creates on click listener for the reset button, which when
        //on long click, resets the players texts to the default life points
        buttonReset.setOnLongClickListener(new View.OnLongClickListener(){
            @Override
            public boolean onLongClick(View v){
                Player1LP.setText("8000");
                Player2LP.setText("8000");
                return true;
            }
        });

        //Sets onclicklistener for the button 1 and appends it to the
        //edit text value field
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (focus == "1") {
                    Player1LP.setText(Player1LP.getText() + "1");
                    buttonEqual.setClickable(true);
                    buttonEqual.setAlpha(1f);
                } else if (focus == "2"){
                    Player2LP.setText(Player2LP.getText() + "1");
                    buttonEqual.setClickable(true);
                    buttonEqual.setAlpha(1f);
                }
            }
        });

        //Sets onclicklistener for the button 2 and appends it to the
        //edit text value field
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (focus == "1") {
                    Player1LP.setText(Player1LP.getText() + "2");
                    buttonEqual.setClickable(true);
                    buttonEqual.setAlpha(1f);
                } else if (focus == "2"){
                    Player2LP.setText(Player2LP.getText() + "2");
                    buttonEqual.setClickable(true);
                    buttonEqual.setAlpha(1f);
                }
            }
        });

        //Sets onclicklistener for the button 3 and appends it to the
        //edit text value field
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (focus == "1") {
                    Player1LP.setText(Player1LP.getText() + "3");
                    buttonEqual.setClickable(true);
                    buttonEqual.setAlpha(1f);
                } else if (focus == "2"){
                    Player2LP.setText(Player2LP.getText() + "3");
                    buttonEqual.setClickable(true);
                    buttonEqual.setAlpha(1f);
                }
            }
        });

        //Sets onclicklistener for the button 4 and appends it to the
        //edit text value field
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (focus == "1") {
                    Player1LP.setText(Player1LP.getText() + "4");
                    buttonEqual.setClickable(true);
                    buttonEqual.setAlpha(1f);
                } else if (focus == "2"){
                    Player2LP.setText(Player2LP.getText() + "4");
                    buttonEqual.setClickable(true);
                    buttonEqual.setAlpha(1f);
                }
            }
        });

        //Sets onclicklistener for the button 5 and appends it to the
        //edit text value field
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (focus == "1") {
                    Player1LP.setText(Player1LP.getText() + "5");
                    buttonEqual.setClickable(true);
                    buttonEqual.setAlpha(1f);
                } else if (focus == "2"){
                    Player2LP.setText(Player2LP.getText() + "5");
                    buttonEqual.setClickable(true);
                    buttonEqual.setAlpha(1f);
                }
            }
        });

        //Sets onclicklistener for the button 6 and appends it to the
        //edit text value field
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (focus == "1") {
                    Player1LP.setText(Player1LP.getText() + "6");
                    buttonEqual.setClickable(true);
                    buttonEqual.setAlpha(1f);
                } else if (focus == "2"){
                    Player2LP.setText(Player2LP.getText() + "6");
                    buttonEqual.setClickable(true);
                    buttonEqual.setAlpha(1f);
                }
            }
        });

        //Sets onclicklistener for the button 7 and appends it to the
        //edit text value field
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (focus == "1") {
                    Player1LP.setText(Player1LP.getText() + "7");
                    buttonEqual.setClickable(true);
                    buttonEqual.setAlpha(1f);
                } else if (focus == "2"){
                    Player2LP.setText(Player2LP.getText() + "7");
                    buttonEqual.setClickable(true);
                    buttonEqual.setAlpha(1f);
                }
            }
        });

        //Sets onclicklistener for the button 8 and appends it to the
        //edit text value field
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (focus == "1") {
                    Player1LP.setText(Player1LP.getText() + "8");
                    buttonEqual.setClickable(true);
                    buttonEqual.setAlpha(1f);
                } else if (focus == "2"){
                    Player2LP.setText(Player2LP.getText() + "8");
                    buttonEqual.setClickable(true);
                    buttonEqual.setAlpha(1f);
                }
            }
        });

        //Sets onclicklistener for the button 9 and appends it to the
        //edit text value field
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (focus == "1") {
                    Player1LP.setText(Player1LP.getText() + "9");
                    buttonEqual.setClickable(true);
                    buttonEqual.setAlpha(1f);
                } else if (focus == "2"){
                    Player2LP.setText(Player2LP.getText() + "9");
                    buttonEqual.setClickable(true);
                    buttonEqual.setAlpha(1f);
                }
            }
        });

        //Sets onclicklistener for the button 0 and appends it to the
        //edit text value field
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (focus == "1") {
                    Player1LP.setText(Player1LP.getText() + "0");
                    buttonEqual.setClickable(true);
                    buttonEqual.setAlpha(1f);
                } else if (focus == "2"){
                    Player2LP.setText(Player2LP.getText() + "0");
                    buttonEqual.setClickable(true);
                    buttonEqual.setAlpha(1f);
                }
            }
        });

        //Sets onclicklistener for the button 00 and appends it to the
        //edit text value field
        button00.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (focus == "1") {
                    Player1LP.setText(Player1LP.getText() + "00");
                    buttonEqual.setClickable(true);
                    buttonEqual.setAlpha(1f);
                } else if (focus == "2"){
                    Player2LP.setText(Player2LP.getText() + "00");
                    buttonEqual.setClickable(true);
                    buttonEqual.setAlpha(1f);
                }
            }
        });

        //Sets onclicklistener for the button 000 and appends it to the
        //edit text value field
        button000.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (focus == "1") {
                    Player1LP.setText(Player1LP.getText() + "000");
                    buttonEqual.setClickable(true);
                    buttonEqual.setAlpha(1f);
                } else if (focus == "2"){
                    Player2LP.setText(Player2LP.getText() + "000");
                    buttonEqual.setClickable(true);
                    buttonEqual.setAlpha(1f);
                }
            }
        });

        //Sets onclicklistener for the button + and then clears the
        //edit text field in order to wait for the next input
        buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (focus == "1") {
                    if (Player1LP == null) {
                        Player1LP.setText("");
                    } else {
                        valueOne = Integer.parseInt(Player1LP.getText() + "");
                        Plus = true;
                        Player1LP.setText(null);
                        buttonPlus.setAlpha(.5f);
                        buttonPlus.setClickable(false);
                        buttonEqual.setAlpha(.5f);
                        buttonEqual.setClickable(false);
                        buttonMinus.setAlpha(.5f);
                        buttonMinus.setClickable(false);
                    }
                } else if (focus == "2"){
                    if (Player2LP == null) {
                        Player2LP.setText("");
                    } else {
                        valueOne = Integer.parseInt(Player2LP.getText() + "");
                        Plus = true;
                        Player2LP.setText(null);
                        buttonPlus.setAlpha(.5f);
                        buttonPlus.setClickable(false);
                        buttonEqual.setAlpha(.5f);
                        buttonEqual.setClickable(false);
                        buttonMinus.setAlpha(.5f);
                        buttonMinus.setClickable(false);
                    }
                }
            }
        });

        //Sets onclicklistener for the button - and then clears the
        //edit text field in order to wait for the next input
        buttonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (focus == "1") {
                    if (Player1LP == null) {
                        Player1LP.setText("");
                    } else {
                        valueOne = Integer.parseInt(Player1LP.getText() + "");
                        Minus = true;
                        Player1LP.setText(null);
                        buttonPlus.setAlpha(.5f);
                        buttonPlus.setClickable(false);
                        buttonEqual.setAlpha(.5f);
                        buttonEqual.setClickable(false);
                        buttonMinus.setAlpha(.5f);
                        buttonMinus.setClickable(false);
                    }
                } else if (focus == "2"){
                    if (Player2LP == null) {
                        Player2LP.setText("");
                    } else {
                        valueOne = Integer.parseInt(Player2LP.getText() + "");
                        Minus = true;
                        Player2LP.setText(null);
                        buttonPlus.setAlpha(.5f);
                        buttonPlus.setClickable(false);
                        buttonEqual.setAlpha(.5f);
                        buttonEqual.setClickable(false);
                        buttonMinus.setAlpha(.5f);
                        buttonMinus.setClickable(false);
                    }
                }
            }
        });

        //Sets onclicklistener for the button = and then clears the
        //edit text field in order to wait for the next input
        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (focus == "1") {
                    valueTwo = Integer.parseInt(Player1LP.getText() + "");
                    if (Plus == true) {
                        Player1LP.setText(valueOne + valueTwo + "");
                        Plus = false;
                        buttonPlus.setAlpha(1f);
                        buttonPlus.setClickable(true);
                        buttonMinus.setAlpha(1f);
                        buttonMinus.setClickable(true);
                    }
                    if (Minus == true) {
                        Player1LP.setText(valueOne - valueTwo + "");
                        Minus = false;
                        buttonPlus.setAlpha(1f);
                        buttonPlus.setClickable(true);
                        buttonMinus.setAlpha(1f);
                        buttonMinus.setClickable(true);
                    }
                } else if (focus == "2"){
                    valueTwo = Integer.parseInt(Player2LP.getText() + "");
                    if (Plus == true) {
                        Player2LP.setText(valueOne + valueTwo + "");
                        Plus = false;
                        buttonPlus.setAlpha(1f);
                        buttonPlus.setClickable(true);
                        buttonMinus.setAlpha(1f);
                        buttonMinus.setClickable(true);
                    }
                    if (Minus == true) {
                        Player2LP.setText(valueOne - valueTwo + "");
                        Minus = false;
                        buttonPlus.setAlpha(1f);
                        buttonPlus.setClickable(true);
                        buttonMinus.setAlpha(1f);
                        buttonMinus.setClickable(true);
                    }
                }
            }
        });
    }


    //Creates a toast message for the reset button to instruct the user
    public void toastMsg(View v){
        String msg = "Hold to Reset";
        Toast toast = Toast.makeText(this,msg,Toast.LENGTH_SHORT);
        toast.show();
    }

    //Default on create method for the menu page
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home_page, menu);
        return true;
    }


    //Default options selected method
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }









}