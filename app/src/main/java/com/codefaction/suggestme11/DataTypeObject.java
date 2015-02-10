package com.codefaction.suggestme11;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sebastian on 05/01/2015. Code Faction.
 * This is how the objects will gain information from the Database
 * I added this in order to keep things together
 * This will properly work when the database is available
 *
 * --------------------------------------------------TO BE UPDATED
 *
 * NOT FOR RE-USE. ALL RIGHTS RESERVED.
 */
public class DataTypeObject {
    //*** CODE FACTION |-|-| SUGGEST ME ***//

    /*
    Basic information for data gathering.
     */

    private String type;
    private String id;

    /*
    Updated information fields.
     */

    private String name;

    /*
    Groups
     */

    /*
    Suggestions
     */

    private int likes;
    private int dislikes;
    private boolean flagged;

    /*
    Result of information gathering.
    Success or Failure. 0 or 1.
     */

    private String result;

    /**
     * The following constructor has been built in the purpose of data gathering.
     * Do not use other methods (that might imply updating) alone.
     *
     * @param type The type of the object that requires more information.
     * @param id The id of the object that requires more information.
     */
    public DataTypeObject(String type, String id)
    {
        this.type = type;
        this.id = id;
        this.name = name;
        likes = Tags.NULL;
        dislikes = Tags.NULL;
        flagged = Tags.FALSE;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getID() {
        return id;
    }

    public void update()
    {
        //At this point the object accesses the database for more information
        //I will skip this part because the database is not yet available
        //However I do need to fill this up with random variables.
    }

    public void setResult(String result)
    {
        this.result = result;
    }

    /*public String requestLogin(Activity currentActivity, String username, String password)
    {
        ConnectorLogin task = new ConnectorLogin(Tags.LOGIN_URL,username,password,this);
        try
        {
            result = task.execute().get();
        }
        catch(Exception e)
        {
            Log.v("Exception at task.execute.get",result);
            result = "FAILURE";
        }
        return result;
    }*/
}



