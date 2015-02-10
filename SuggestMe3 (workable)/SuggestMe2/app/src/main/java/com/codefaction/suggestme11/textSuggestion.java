package com.codefaction.suggestme11;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class textSuggestion extends ActionBarActivity
{

    public final static String CODE_FACTION = "com.codefaction.suggestme11.AccessDB";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_suggestion);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_text_suggestion, menu);
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
     * Submitting a text suggestion.
     * @param view The text suggestion settings screen.
     */
    public  void submitTxtSug(View view)
    {
        //Intent submitTxtSug = new Intent(this,AccessDatabase.class); // for now just move to screen
        Intent submitTxtSug = new Intent(this,GroupActivity.class); // return to group screen
        EditText suggestion = (EditText) findViewById(R.id.userTxtSug);
        EditText tags = (EditText) findViewById(R.id.TxtTagBox); //need to parse tags
        String submitSug = suggestion.getText().toString();
        String submitTags = tags.getText().toString();
        submitTxtSug.putExtra(CODE_FACTION,submitSug);
        submitTxtSug.putExtra(CODE_FACTION,submitTags);

        startActivity(submitTxtSug);

    }
}
