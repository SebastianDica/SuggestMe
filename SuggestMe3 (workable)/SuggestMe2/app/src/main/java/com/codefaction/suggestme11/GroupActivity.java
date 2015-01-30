package com.codefaction.suggestme11;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class GroupActivity extends ActionBarActivity
{
    private String name;
    private int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);
        TextView textView = (TextView)findViewById(R.id.groupName);

        Bundle extras = getIntent().getExtras();
        if(extras!= null)
        {
            String value = extras.getString("GROUPNAME");
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
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_group, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void groupDetails(View view)
    {
        Intent groupDetails = new Intent(this,GroupSummary.class);

        groupDetails.putExtra("GROUP_NAME",name);

        startActivity(groupDetails);
    }

    public void suggestButton(View view)
    {
        Intent suggestButton = new Intent(this,SuggestOptions.class);
        startActivity(suggestButton);
    }

}
