package com.codefaction.suggestme11;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class SurveySuggestion extends ActionBarActivity
{

    public final static String CODE_FACTION = "com.codefaction.suggestme11.AccessDB";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey_suggestion);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_survey_suggestion, menu);
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
     * Submitting a survey suggestion.
     * @param view The survey suggestion settings screen.
     */
    public void submitSurSug(View view)
    {
        //Intent submit = new Intent(this,AccessDatabase.class);
        Intent submitSurSug = new Intent(this,GroupActivity.class); //return to screen
        EditText suggestion = (EditText) findViewById(R.id.userSurSug);
        EditText options = (EditText) findViewById(R.id.options);
        EditText tags = (EditText) findViewById(R.id.surTagbox);
        String submitSug = suggestion.getText().toString();
        String submitOps = options.getText().toString(); //need to parse options
        String submitTags = tags.getText().toString(); //need to parse tags
        submitSurSug.putExtra(CODE_FACTION,submitSug);
        submitSurSug.putExtra(CODE_FACTION,submitOps);
        submitSurSug.putExtra(CODE_FACTION,submitTags);

        startActivity(submitSurSug);
    }
}
