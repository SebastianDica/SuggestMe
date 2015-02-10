package com.codefaction.suggestme11;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;



public class MyGroups extends ActionBarActivity
{
    private ArrayList<DataTypeObject> listDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_groups);
        listDB = new ArrayList<DataTypeObject>();
        /* JUST FOR TESTING */
        DataTypeObject testoption1 = new DataTypeObject("Group","Test Option 1");
        DataTypeObject testoption2 = new DataTypeObject("Group","Test Option 2");
        DataTypeObject cat = new DataTypeObject("Group","Cat");
        DataTypeObject dog = new DataTypeObject("Group","Dog");
        DataTypeObject doggie = new DataTypeObject("Group","Doggie");
        DataTypeObject dogman = new DataTypeObject("Group","Dogman");
        listDB.add(testoption1);
        listDB.add(testoption2);
        listDB.add(cat);
        listDB.add(dog);
        listDB.add(doggie);
        listDB.add(dogman);
        updateList(listDB);


    }
    public void updateList(ArrayList<DataTypeObject> listS)
    {
        final ArrayList<DataTypeObject> list = new ArrayList<DataTypeObject>();
        for(int i = 0 ; i < listS.size() ; i++)
        {
            list.add(listS.get(i));
        }
        final ListView listview = (ListView) findViewById(R.id.myGroupList);

        /*
        THIS PART WILL BE ENTIRELY CHANGED DUE TO NOT CONNECTING TO THE DATABASE
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
                int positionDB = 0;
                for(int i = 0 ; i < listDB.size() ; i++)
                {
                    if(listDB.get(i).getName().equals(list.get(position).getName()))
                    {
                        positionDB = i;
                        i = listDB.size();
                    }
                }

                callGroup(positionDB);
            }

        });
    }

    /**
     * Calling a certain group after the user has selected one
     * of the options in the list view
     * @param position The position of the group in the listview.
     */
    public void callGroup(int position)
    {
        String name = listDB.get(position).getName();
        Intent groupView = new Intent(this,GroupActivity.class);
        int id = 0; //JUST SO IT IS COMPLETE.
        groupView.putExtra("ID",id);
        groupView.putExtra("GROUPNAME",name);
        startActivity(groupView);
    }

    /**
     * Doing a search over the current list. This function modifies
     * the view in such a way that only the related groups regarding
     * the search will appear.
     * @param view The current view of the activity.
     */
    public  void search(View view)
    {
        Intent search = new Intent(this,MyGroups.class);
        EditText searchTextView = (EditText) findViewById(R.id.searchTextView);
        String searched = searchTextView.getText().toString();
        search.putExtra("CODE_FACTION",searched);

        modifyList(searched);
    }

    /**
     * This function calls the OwnGroups class, displaying
     * only those groups which the user has created.
     * @param view The current view of the activity.
     */
    public void myOwnGroups(View view)
    {
        Intent myOwnGroups = new Intent(this,OwnGroups.class);
        startActivity(myOwnGroups);
    }

    /**
     * This function modifies the list for the search option.
     * Might be modified when the database is introduced.
     * --------------------------------------TO BE UPDATED
     * @param term The term that has been searched.
     *
     */
    public void modifyList(String term)
    {
        final ListView listview = (ListView) findViewById(R.id.myGroupList);
        listview.setAdapter(null);
        ArrayList<DataTypeObject> temp = new ArrayList<>();
        if(term.equals(""))
        {
            for(int i = 0 ; i < listDB.size(); i++)
            {
                temp.add(listDB.get(i));
            }
        }
        else
        {

            int termLength = term.length();

            for(int i = 0 ; i < listDB.size() ; i++)
            {
                DataTypeObject thisString = listDB.get(i);
                int thisLength = thisString.getName().length();
                if(termLength <= thisLength)
                {
                    for(int j = 0 ; j <= (thisLength - termLength) ;j++)
                    {
                        if(term.equals(thisString.getName().subSequence(j, j + termLength)))
                        {
                            temp.add(new DataTypeObject("Group",thisString.getName()));
                            j = thisLength + 1;
                        }
                    }
                }
            }

        }
        if(temp.size() == 0) temp.add(new DataTypeObject("Error","Nothing was found :(."));
        updateList(temp);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_my_groups, menu);
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
     * The group creation function gives access the the GroupCreationActivity
     * @param view The current view of the activity.
     */
    public void groupCreator(View view)
    {
        Intent groupCreation = new Intent(this,GroupCreationActivity.class);

        startActivity(groupCreation);
    }
}
