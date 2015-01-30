package com.codefaction.suggestme11;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class SuggestOptions extends ActionBarActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggest_options);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_suggest_options, menu);
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
     * The option of text suggestion.
     * @param view The view of the options.
     */
    public void textSuggest(View view)
    {
        Intent makeTxtSug = new Intent(this,textSuggestion.class);
        startActivity(makeTxtSug);

    }

    /**
     * The option of survey suggestion.
     * @param view The view of the options.
     */
    public void surveySuggest(View view)
    {

        Intent makeSurvey = new Intent(this,SurveySuggestion.class);
        startActivity(makeSurvey);

    }

    /**
     * The option of debate suggestion.
     * @param view The view of the options.
     */
    public void debateSuggest(View view)
    {

        Intent makeDebate = new Intent(this,DebateSuggestion.class);
        startActivity(makeDebate);

    }



}
