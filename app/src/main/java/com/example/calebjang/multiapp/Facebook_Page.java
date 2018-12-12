package com.example.calebjang.multiapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.Login;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;
import java.util.Arrays;

public class Facebook_Page extends AppCompatActivity {

    //Creates all of the variables needed within this page
    CallbackManager callbackManager;
    TextView txtEmail, txtBirthday, txtFriends, Welcome;
    ImageView imgAvatar;
    ProgressDialog mDialog;

    //Method that displays the activity result codes
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    //On create method that create the items like action bar
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        FacebookSdk.sdkInitialize(getApplicationContext());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facebook__page);
        callbackManager = CallbackManager.Factory.create();

        //Creates and sets the views to their corresponding items
        txtBirthday = (EditText) findViewById(R.id.txtBirthday);
        txtEmail = (EditText) findViewById(R.id.txtEmail);
        txtFriends = (EditText) findViewById(R.id.txtFriends);
        Welcome = (TextView)findViewById(R.id.Welcome);
        imgAvatar = (ImageView)findViewById(R.id.avatar);
        LoginButton loginButton = (LoginButton)findViewById(R.id.login_button);
        loginButton.setReadPermissions(Arrays.asList("public_profile", "email", "user_birthday", "user_friends"));

        //Creates a login button which calls teh facebook callback manager
        //api and returns depending on success or fails
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                //Displays a dialog to show the user that data is loading
                mDialog = new ProgressDialog(Facebook_Page.this);
                mDialog.setMessage("Retrieving Data...");
                mDialog.show();

                //Gets the token on success and the removes the dialog alert
                String accesstoken = loginResult.getAccessToken().getToken();
                GraphRequest request = GraphRequest.newMeRequest(loginResult.getAccessToken(), new GraphRequest.GraphJSONObjectCallback() {
                    @Override
                    public void onCompleted(JSONObject object, GraphResponse response) {
                        mDialog.dismiss();
                        Log.d("response", response.toString());
                        Welcome.setText("");
                        txtEmail.setEms(20);
                        getData(object);
                    }
                });

                //Creates a bundle to string the successful strings gathered
                //from the facebook api and the json
                Bundle parameters = new Bundle();
                parameters.putString("fields", "id,email,birthday,friends");
                request.setParameters((parameters));
                request.executeAsync();
            }

            //Defaukted methods created when success was
            @Override
            public void onCancel() {
            }
            @Override
            public void onError(FacebookException error) {
            }
        });

        //If already logged in
        if(AccessToken.getCurrentAccessToken() != null){
            //Just set user id
            Welcome.setText("");
            txtEmail.setText(AccessToken.getCurrentAccessToken().getUserId());
        }
    }

    //Gets the data method from the json objects
    private void getData(JSONObject object){
        try {
            //Grabs the profile picture from the facebook url apis
            URL profile_picture = new URL("https://graph.facebook.com/"+object.getString("id")+"/picture?width=250&height=250");
            //Loads the picture with a picasso extension
            Picasso.with(this).load(profile_picture.toString()).into(imgAvatar);
            //Then sets the text fields with the values received from the json files
            txtEmail.setText(object.getString("email"));
            txtBirthday.setText(object.getString("birthday"));
            txtFriends.setText("Friends: "+ object.getJSONObject("friends").getJSONObject("summary").getString("total_count"));
        //Catches and throws any exceptions found
        } catch (MalformedURLException e){
            e.printStackTrace();
        } catch (JSONException e){
            e.printStackTrace();
        }
    }

    //Method created in order to print out the keyhash within the log console
    //Specifically made for the facebook api, which requires the machines specific
    //private key hash.
    private void printKeyHash(){
        try {
            PackageInfo info = getPackageManager().getPackageInfo("com.example.calebjang.multiapp", PackageManager.GET_SIGNATURES);
            for (android.content.pm.Signature signature:info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        //Catches any exceptions and throws
        } catch (PackageManager.NameNotFoundException e){
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }
    }

    //A toast medssage method which tells the user to fill out all of the fields
    //first before clicking the button.  Solely for cosmetic at the moment
    public void toastMsg(View v){
        String msg = "Please Fill Out All Fields";
        Toast toast = Toast.makeText(this,msg,Toast.LENGTH_SHORT);
        toast.show();
    }
}
