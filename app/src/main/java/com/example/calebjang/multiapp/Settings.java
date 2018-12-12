package com.example.calebjang.multiapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ShareActionProvider;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;

public class Settings extends AppCompatActivity {
    private ShareActionProvider shareActionProvider;

    //Defaulted on create method which opens up the items like action bar
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }
    //Currently does not contain any code, this page being blank.
    //Opened solely to add an extra intent page, a filler page


    public boolean onCreateOptionsMenu (Menu menu) {
        //Inflate the menu, this adds items to the app bar
        getMenuInflater().inflate(R.menu.menu_home_page,menu);
        MenuItem menuItem = menu.findItem(R.id.action_share);
        shareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(menuItem);
        setShareActionIntent("Want to test pizza");
        return super.onCreateOptionsMenu(menu);
    }

    private  void setShareActionIntent (String text){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, text);
        shareActionProvider.setShareIntent(intent);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_create_order:
//Code to run when the Create Order item is clicked
                Intent intent = new Intent(this, Picture_Page.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}




//TESTINGG
