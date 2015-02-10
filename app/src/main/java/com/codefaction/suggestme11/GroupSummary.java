package com.codefaction.suggestme11;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class GroupSummary extends ActionBarActivity
{
    private String name;
    private int id;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_summary);


        TextView textView = (TextView)findViewById(R.id.groupNameSummary);
        Bundle extras = getIntent().getExtras();

        if(extras!= null)
        {
            String value = extras.getString("GROUP_NAME");
            textView.clearComposingText();
            textView.setText(value);
            this.name = value;
        }
        else
        {
            textView.clearComposingText();
            textView.setText("ERROR");
            this.name = "ERROR";
        }
        this.id = 0;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_group_summary, menu);
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
