package com.codefaction.suggestme11;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


public class OwnGroups extends ActionBarActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_own_groups);

        final ListView listview = (ListView) findViewById(R.id.myGroupList);

        /*
        THIS PART WILL BE ENTIRELY CHANGED DUE TO NOT CONNECTING TO THE DATABASE
        */
        ArrayList<DataTypeObject> list = new ArrayList<>();
        list.add(new DataTypeObject("Group","My own Group"));
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
                callManagerView();
            }

        });
    }

    /**
     * Accesses the manager view of a group.
     * ---------------------TO BE UPDATED
     */
    public void callManagerView()
    {
        Intent managerView = new Intent(this, GroupManagerView.class);
        managerView.putExtra("GROUP_NAME","Name");
        managerView.putExtra("Whatever","Whatever");
        startActivity(managerView);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_own_groups, menu);
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
