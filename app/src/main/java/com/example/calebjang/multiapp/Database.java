package com.example.calebjang.multiapp;

import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Database extends AppCompatActivity {
    //Instantiates every variable
    DatabaseHelper myDB;
    EditText studentName, studentSurname, studentMark, studentID;
    Button addData, updateData, deleteData, viewData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);
        //On create, creates an instance of my database
        //this holds all of my data and is my personal database
        //Can create another by making another object database
        myDB = new DatabaseHelper(this);

        //Finds all variable views from XML (EditTexts)
        studentName = (EditText)findViewById(R.id.student_name);
        studentSurname = (EditText)findViewById(R.id.student_Surname);
        studentMark = (EditText)findViewById(R.id.student_mark);
        studentID =(EditText)findViewById(R.id.student_id);

        //Finds all variable views from XML (Buttons)
        addData = (Button)findViewById(R.id.add);
        updateData = (Button)findViewById(R.id.update);
        deleteData = (Button)findViewById(R.id.delete);
        viewData = (Button)findViewById(R.id.view);

        //Calls each onclicklistener for each button
        addDataMethod();
        viewDataMethod();
        updateDataMethod();
        deleteDataMethod();
    }



    //View data method, which allows user to view all of the data
    //that is within the database currently
    public void viewDataMethod(){
        //Sets the button as an onclicklistener
        viewData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //sets the result to get all data
                        Cursor result = myDB.getAllData();
                        if (result.getCount() == 0) {
                            //Shows the error message if no data found
                            showMessage("Error", "Nothing Data Found");
                            return;
                        }
                        //Creates a buffer to display all of the data
                        //as long as there is another data result, move next
                        StringBuffer buffer = new StringBuffer();
                        while (result.moveToNext()) {
                            //Adds the data from each column in the database,
                            //then labels each one and creates a new line,
                            //then adds 2 new lines to finish off the section
                            buffer.append("Id :" + result.getString(0)+"\n");
                            buffer.append("Name :" + result.getString(1)+"\n");
                            buffer.append("Surname :" + result.getString(2)+"\n");
                            buffer.append("Mark :" + result.getString(3)+"\n\n");
                        }
                        //Show all of the data that was appended to the buffer
                        //calls the showmessages method in order to display info
                        showMessage("Data", buffer.toString());
                    }
                }
        );
    }



    //This shows the alert dialog, or the modal that pops up when wanting to
    //view all of the users in the database
    public void showMessage(String title, String message){
        //creates dialog, then allows the cancel button, and sets all
        //other of the builder traits
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }



    //Add data method, which allows the user to add new data
    //to the database via the add button
    public void addDataMethod() {
        //Sets button as onclicklistener
        addData.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        //Checks to see if all of the fields are complete before adding to
                        //the database
                        if (studentName.getText().toString().equals("") ||
                                studentSurname.getText().toString().equals("") ||
                                studentMark.getText().toString().equals("")){
                            Toast.makeText(Database.this,
                                    "Complete All Fields",
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            //Else if all the fields are filled out, create bool to see if
                            //data gets inserted properly, and display toast accordingly
                            boolean isInserted = myDB.insertData(studentName.getText().toString(),
                                    studentSurname.getText().toString(),
                                    studentMark.getText().toString());
                            //Display correct messages depending on if statement
                            if (isInserted == true) {
                                Toast.makeText(Database.this,
                                        "Data Inserted",
                                        Toast.LENGTH_SHORT).show();
                                clearData();
                            } else {
                                Toast.makeText(Database.this,
                                        "Data Not Inserted",
                                        Toast.LENGTH_SHORT).show();
                                clearData();
                            }
                        }
                    }
                }
        );
    }


    //This is the update method, which allows the user to update and
    //edit the database information
    public void updateDataMethod() {
        //Sets update as onclicklistener
        updateData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //calls the update data db function, which updates all of the data
                        //with the text that is currently inside the edittext fields.
                        //If the update is successful, sets the boolean value to true.
                        boolean isUpdate = myDB.updateDataFunction(studentID.getText().toString(),
                                studentName.getText().toString(),
                                studentSurname.getText().toString(),
                                studentMark.getText().toString());
                        //Creates an error message for incorrect input
                        if (studentID.getText().toString().equals("")) {
                            Toast.makeText(Database.this,
                                    "Fill Out Student ID",
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            //Display correct messages depending on if statement
                            if (isUpdate == true) {
                                Toast.makeText(Database.this,
                                        "Student Data with ID: " + studentID.getText().toString() +
                                        " Updated",
                                        Toast.LENGTH_SHORT).show();
                                clearData();
                            } else {
                                Toast.makeText(Database.this,
                                        "Data Not Updated",
                                        Toast.LENGTH_SHORT).show();
                                clearData();
                            }
                        }
                    }
                }
        );
    }




    //Delete data method for deleting an item in the database
    public void deleteDataMethod() {
        //sets onclicklistener for delete button
        deleteData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //calls the database function to delete the row, which is indexed by student ID
                        Integer deletedRows = myDB.deleteDataFunction(studentID.getText().toString());
                        //Creates an error message for any incorrect input
                        if (studentID.getText().toString().equals("")) {
                            Toast.makeText(Database.this,
                                    "Fill Out Student ID",
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            //Display correct messages depending on if statement
                            if (deletedRows > 0) {
                                Toast.makeText(Database.this,
                                        "Student Data with ID: " + studentID.getText().toString() +
                                        " Deleted",
                                        Toast.LENGTH_SHORT).show();
                                clearData();
                            } else {
                                Toast.makeText(Database.this,
                                        "Data Not Deleted",
                                        Toast.LENGTH_SHORT).show();
                                clearData();
                            }
                        }
                    }
                }
        );
    }


    //Clear data function, which clears out all of the
    //edit texts fields after a button has been clicked
    public void clearData(){
        studentID.setText("");
        studentName.setText("");
        studentSurname.setText("");
        studentMark.setText("");
    }




    //Placeholders for each button that displays a toast
    //message of what the buttons should do, until implemented
//    public void toastMsgLoad(View v){
//        String msg = "Student Data Loaded";
//        Toast toast = Toast.makeText(this,msg,Toast.LENGTH_SHORT);
//        toast.show();
//    }
//    public void toastMsgAdd(View v) {
//        String msg = "Added Student Data";
//        Toast toast = Toast.makeText(this, msg, Toast.LENGTH_SHORT);
//        toast.show();
//    }
//    public void toastMsgFind(View v){
//        String msg = "Finding Student Data";
//        Toast toast = Toast.makeText(this,msg,Toast.LENGTH_SHORT);
//        toast.show();
//    }
//    public void toastMsgDelete(View v){
//        String msg = "Deleted Student Data";
//        Toast toast = Toast.makeText(this,msg,Toast.LENGTH_SHORT);
//        toast.show();
//    }
//    public void toastMsgUpdate(View v){
//        String msg = "Updated Student Data";
//        Toast toast = Toast.makeText(this,msg,Toast.LENGTH_SHORT);
//        toast.show();
//    }


}

