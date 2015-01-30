package com.codefaction.suggestme11;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class Register extends ActionBarActivity
{

    public final static String CODE_FACTION = "com.codefaction.suggestme11.AccessDB";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_register, menu);
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
     * The registration view.
     * @param view The current view of the app. *Login*
     *             ------------------------TO BE UPDATED
     */
    public void register(View view)
    {
        Intent register = new Intent("Database here");

        EditText regName = (EditText) findViewById(R.id.registerName);
        EditText regEmail = (EditText) findViewById(R.id.registerEmail);
        EditText regID = (EditText) findViewById(R.id.registerID);
        EditText regPass = (EditText) findViewById(R.id.password);
        EditText confirmPass = (EditText) findViewById(R.id.confirmPass);

        register.putExtra(CODE_FACTION,regName.getText().toString());
        register.putExtra(CODE_FACTION,regEmail.getText().toString());
        register.putExtra(CODE_FACTION,regID.getText().toString());
        register.putExtra(CODE_FACTION,regPass.getText().toString());
        register.putExtra(CODE_FACTION,confirmPass.getText().toString()); //no need to define a String

        startActivity(register);
    }
}
