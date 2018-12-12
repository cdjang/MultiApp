package com.example.calebjang.multiapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


//Database Helper controls the actual sql and databases
//database.java just calls this helper class
public class DatabaseHelper extends SQLiteOpenHelper {
    //Creates the SQL database, and also creates a table inside it
    public static final String DATABASE_NAME = "Student.db";
    public static final String TABLE_NAME = "Student_Table";

    //ID is a primary key, which means its an unique identifier so sequencing
    //The other strings are column variable names for later
    public static final String COL_1 = "ID";
    public static final String COL_2 = "NAME";
    public static final String COL_3 = "SURNAME";
    public static final String COL_4 = "MARKS";


    //This constructor here, whenever it gets called, it creates your database
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }


    //This is the oncreate method, which creates the database upon start up
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //Executes an SQL function, which is create a table called "table name"
        //and give it the 4 column name variables
        sqLiteDatabase.execSQL("create table  " + TABLE_NAME + "" +
                " (ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                " NAME TEXT, SURNAME TEXT, MARKS INTEGER)");
        //Because primary key is auto increment, there is no need to
        //touch this variable

        //This is a testing table creation
        sqLiteDatabase.execSQL("create table  " +
                "TESTING" +
                " (NAME TEXT, SURNAME TEXT, MARKS INTEGER)");
    }



    //This method is used if there is already a table name created, in
    //which in this case, it deletes the table then runs on create again
    //to recreate that table
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

        onCreate(sqLiteDatabase);
    }


    //Inserts data into the database.  This is for the Insert Button.
    public boolean insertData(String name, String surname, String marks) {
        //Creates instance of the database
        SQLiteDatabase db = this.getWritableDatabase();
        //Creates new values for new content
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, name);
        contentValues.put(COL_3, surname);
        contentValues.put(COL_4, marks);
        //Inserts the data into database, if result is not -1, then continue
        long result = db.insert(TABLE_NAME, null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }


    //Cursor provides read and write data from the table
    public Cursor getAllData(){
        //Creates instance of database
        SQLiteDatabase db = this.getWritableDatabase();
        //Gets the data results form a sql query (select from table)
        Cursor result = db.rawQuery("select * from " +
                TABLE_NAME, null);
        return result;
    }


    //Updates the database information
    public boolean updateDataFunction(String id, String name,
                                      String surname, String marks) {
        //Creates instance of database
        SQLiteDatabase db = this.getWritableDatabase();
        //Creates all of the values, which is name,last name,
        // mark, id (updates content)
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, id);
        contentValues.put(COL_2, name);
        contentValues.put(COL_3, surname);
        contentValues.put(COL_4, marks);
        //Then calls db.update to update the table name with the content values
        //The where clause asks where to update, so we update ID, and
        //update the value with the string ID
        db.update(TABLE_NAME, contentValues, "ID = ?", new String[] {id });
        return true;
    }


    //Deletes data from the database
    public Integer deleteDataFunction (String id) {
        //Creates instance of the database
        SQLiteDatabase db = this.getWritableDatabase();
        //Calls the database, calls delete, deletes from the table,
        //where is at the ID
        return db.delete(TABLE_NAME, "ID = ?", new String[]{id});
    }

}
