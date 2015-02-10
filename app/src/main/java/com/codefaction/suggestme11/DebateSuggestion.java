package com.codefaction.suggestme11;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class DebateSuggestion extends ActionBarActivity {

    public final static String CODE_FACTION = "com.codefaction.suggestme11.AccessDB";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_debate_suggestion);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_debate_suggestion, menu);
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
     * Submitting the debate suggestion.
     * @param view The debate suggestion settings screen.
     */
    public void submitDebate(View view)
    {
        //Intent submitTxtSug = new Intent(this,AccessDatabase.class); // for now just move to screen
        Intent submitDebSug = new Intent(this,GroupActivity.class); // return to group screen
        EditText suggestion = (EditText) findViewById(R.id.debateSug);
        EditText tags = (EditText) findViewById(R.id.debTagbox); //need to parse tags
        String submitSug = suggestion.getText().toString();
        String submitTags = tags.getText().toString();
        submitDebSug.putExtra(CODE_FACTION,submitSug);
        submitDebSug.putExtra(CODE_FACTION,submitTags);

        startActivity(submitDebSug);
    }
}
