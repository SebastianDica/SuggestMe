package com.codefaction.suggestme11;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * Code Faction. All rights reserved. © 2015.
 * This is the Main Screen class. It will be used for search,
 * updates from database and adapters. It also includes the
 * CodeFactionAdapter class. DO NOT COPY OR REUSE THIS.
 */

public class MainScreen extends ActionBarActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        final ListView listview = (ListView) findViewById(R.id.listView);
        final ArrayList<DataTypeObject> list = new ArrayList<DataTypeObject>();
        /**
         * RANDOMIZING SOME STUFF TO PUT INTO THE MENU LIST
         */
        Random generator = new Random();
        for (int i = 0; i < 20; ++i)
        {
            int pos = generator.nextInt(3);
            String name = "";
            if(pos==0) name = "Suggestion";
            if(pos==1) name = "Group";
            if(pos==2) name = "Update";
            String x = new String();
            x = x.valueOf(i);
            list.add(new DataTypeObject(name, name + x));
        }
        /*
        THIS PART WILL BE ENTIRELY CHANGED DUE TO NOT CONNECTING TO THE DATABASE
        STILL IN PROGRESS.
        */
        final CodeFactionAdapter adapter = new CodeFactionAdapter(this,
                android.R.layout.simple_list_item_1, list);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {

            @Override
            public void onItemClick(AdapterView<?> parent, final View view,
                                    int position, long id) {
                //final DataTypeObject item = (DataTypeObject) parent.getItemAtPosition(position);
                adapter.notifyDataSetChanged();
                view.setAlpha(1);
            }

        });

}

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_main_screen, menu);
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
     * Function that retrieves all the groups of a user. (Owner or member)
     * @param view The MainScreen View. Irrelevant for now.
     */
    public void myGroups(View view)
    {
        Intent myGroups = new Intent(this,MyGroups.class);

        startActivity(myGroups);
    }

    /**
     * Function that retrieves all the suggestions of a user.
     * @param view The MainScreen View. Irrelevant for now.
     */
    public void mySuggestions(View view)
    {
        Intent mySuggestions = new Intent(this,MySuggestions.class);

        startActivity(mySuggestions);
    }
    public void accountSettings(View view)
    {
        Intent accountSettings = new Intent(this,AccountSettings.class);
        accountSettings.putExtra("Whatever","Whatever");
        startActivity(accountSettings);
    }
}

/**
 * The CodeFaction Adapter. Adapts the lists for the application.
 * Does have stables ID's and it works on hashing.
 * Very sensible. Do not modify.
 */
class CodeFactionAdapter extends ArrayAdapter<DataTypeObject> {

    HashMap<DataTypeObject, Integer> mIdMap = new HashMap<DataTypeObject, Integer>();
    private Context newContext;
    public CodeFactionAdapter(Context context, int textViewResourceId, List<DataTypeObject> objects)
    {
        super(context, textViewResourceId, objects);
        this.newContext = context;
        for (int i = 0; i < objects.size(); ++i) {
            mIdMap.put(objects.get(i), i);
        }
    }

    @Override
    public long getItemId(int position)
    {
        DataTypeObject item = getItem(position);
        return mIdMap.get(item);
    }

    @Override
    public boolean hasStableIds()
    {
        return true;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup)
    {
        if(convertView ==null)
        {
            LayoutInflater inflater = (LayoutInflater) newContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.listviewlayout, viewGroup ,false);
        }
        TextView name = (TextView)convertView.findViewById(R.id.textView1);
        TextView description = (TextView)convertView.findViewById(R.id.textView2);

        DataTypeObject data = getItem(position);

        name.setText(data.getName());
        String x ="ERROR";
        description.setText(x.valueOf(data.getID()));

        return convertView;
    }

}
