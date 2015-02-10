package com.codefaction.suggestme11;

import java.util.ArrayList;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.simple.*;

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
public class DataTypeObject
{
    //*** CODE FACTION |-|-| SUGGEST ME ***//

    final static private String GROUP = "Group";
    final static private String SUGGESTION = "Suggestion";
    final static private String UPDATE = "Update";
    final static private String LIST = "List";
    final static private String ERROR = "ERROR";
    final static private int NULL = 0;
    final static private String NOTSPECIFIED = "Not Specified";
    final static private String CODE_FACTION = "Code Faction";
    final static private Integer NONE = 0;
    final static private boolean FALSE = false;
    final static private boolean TRUE = true;
    final static private String TEXT_SUGGESTION = "Text Suggestion";
    final static private String DEBATE = "Debate";
    final static private String SURVEY = "Survey";
    final static private String OPEN = "Open";
    final static private String CLOSED = "Closed";
    private String type;
    private int id; private String label;
    private String name; private String information;
    private String informationData; private String informationDetails;
    private int likes; private int dislikes;
    private boolean flagged; private boolean newInstance;
    private String commonInterest;
    private ArrayList<Integer> parents; private ArrayList<Integer> children;

    private HttpClient client = new DefaultHttpClient();

    public DataTypeObject()
    {
        type = new String(); label = new String();
        type = "ERROR"; label = CODE_FACTION;
        id = NULL; name = NOTSPECIFIED; information = NOTSPECIFIED;
        informationData = NOTSPECIFIED; informationDetails = NOTSPECIFIED;
        likes = NULL; dislikes = NULL; flagged = FALSE; newInstance = TRUE;
        commonInterest = NOTSPECIFIED;
        parents = new ArrayList<Integer>(); parents.add(NONE);
        children = new ArrayList<Integer>(); children.add(NONE);
    }

    /**
     * The following constructor has been built just for testing!
     * Do not use other methods (that might imply updating)
     * Not recommended
     * @param type The type of the tested object
     * @param name The name of the tested object
     */
    public DataTypeObject(String type,String name)
    {
        label = new String();
        this.type = type; label = CODE_FACTION;
        id = NULL; this.name = name; information = NOTSPECIFIED;
        informationData = NOTSPECIFIED; informationDetails = NOTSPECIFIED;
        likes = NULL; dislikes = NULL; flagged = FALSE; newInstance = TRUE;
        commonInterest = NOTSPECIFIED;
    }
    public void setType(int typeNumber)
    {
        if(typeNumber==0) type = GROUP;
        if(typeNumber==1) type = SUGGESTION;
        if(typeNumber==2) type = UPDATE;
        if(typeNumber==3) type = LIST;
        else type = ERROR;
    }
    public void setType(String type)
    {
        this.type = type;
    }
    public void setID(int ID)
    {
        this.id = ID;
    }

    /**
     * This method is a combination of the setType and setID methods
     * This set methods are the ones that handle the only information
     * that the user possess in his device. The type and object.
     * Knowing the type and object the other details can be filled in
     * using the database.
     * @param typeNumber The type of the object in form of an integer
     * @param ID The ID of the object in form of an integer
     *
     *           ---------------------------------------TO BE UPDATED
     */
    public void setObject(int typeNumber, int ID)
    {
        if(typeNumber==0) type = GROUP;
        if(typeNumber==1) type = SUGGESTION;
        if(typeNumber==2) type = UPDATE;
        if(typeNumber==3) type = LIST;
        else type = ERROR;

        this.id = ID;
        update();

    }
    public void setObject(String type, int ID)
    {
        this.type = type;
        this.id = ID;
        update();

    }
    public void setViewed()
    {
        newInstance = FALSE;
    }
    public String getName() { return name; }
    public String getType()
    {
        return type;
    }
    public int getID()
    {
        return id;
    }
    public void update()
    {
        JSONObject jData = new JSONObject();

        jData.put("type",type);
        jData.put("id",id);

        String data = jData.toString();
        System.out.println(data);

        try
        {
            HttpPost request = new HttpPost(/**sebs script on local server*/);

        }
    }
    public String toString()
    {
        return name;
    }
}


