package com.codefaction.suggestme11;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import org.json.JSONObject;


public class Login extends ActionBarActivity
{

    public final static String CODE_FACTION = "com.codefaction.suggestme11.AccessDB";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        try
        {
            String test = "{\"success\":1,\"message\":\"Database Error1. Please Try Again!\"}";
            JSONObject testOb = new JSONObject(test);
            if(testOb.getInt(Tags.TAG_SUCCESS) == 1)
                Log.v("TESTSuccess",test);
            else
                Log.v("TESTFailure",test);
        }
        catch(Exception e)
        {
            Log.v("TESTFailure","Extrenefail");
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * The registration function. Retrieves information from the user and sends it to the database.
     * @param view The login view activity. Irrelevant for now.
     */
    public void callRegister(View view)
    {
        Intent openRegister = new Intent(this,Register.class);

        startActivity(openRegister);
    }

    /**
     * The login function. Connects directly to the database. (TO BE IMPLEMENTED)
     * @param view The login view activity. Irrelevant for now.
     */
    public void login(View view)
    {
        Intent login = new Intent(this,MainScreen.class);
        EditText loginEmail = (EditText) findViewById(R.id.loginEmail);
        EditText password = (EditText) findViewById(R.id.loginPass);
        String logMail = loginEmail.getText().toString();
        String logPass = password.getText().toString();
        login.putExtra(CODE_FACTION,logMail);
        login.putExtra(CODE_FACTION,logPass);

        DataTypeObject loginRequest = new DataTypeObject(Tags.REQUEST,"0");
        if(true)
        {
            Log.v("HHHMessage", "WHAT THE HELL");
            startActivity(login);
        }
        else
        {

        }
    }
}
