package com.codefaction.suggestme11;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class SurveyScreen extends ActionBarActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey_screen);

       // Intent toDisplay = getIntent();
       // String surveyTitle = toDisplay.getStringExtra(Datbase.title); // extract title from database

      /*  String surveyTitle = "suggestion 1";
        TextView title = new TextView(this);
        title.setTextSize(38);
        title.setText(surveyTitle);

        setContentView(title);

        ImageView pieChart = new ImageView(this);

        pieChart. */

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_survey_screen, menu);
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
}
