package com.codefaction.suggestme11;

/**
 * Created by Sebastian on 10/02/2015.
 */
public class Tags
{
    /*
    Links.
     */

    final static public String CODE_FACTION = "http://192.168.137.1/codefaction/suggestme/";
    final static public  String LOGIN_URL = "http://10.8.178.229/codefaction/suggestme/login.php";
    final static public String MY_GROUPS_IDS = "http://10.8.178.229/codefaction/suggestme/mygroupsidretriever.php";
    //final static public String LOGIN_URL = "http://10.111.199.217/codefaction/suggestme/login.php";
    final static public String MY_GROUPS_S_INFO = "http://10.8.178.229/codefaction/suggestme/groupsmallinfo.php";


    /*
    Main data types
     */

    final static public String GROUP = "Group";
    final static public String SUGGESTION = "Suggestion";
    final static public String UPDATE = "Update";
    final static public String LIST = "List";
    final static public String REQUEST = "Request";
    final static public String ERROR = "ERROR";

    /*
    Main attributes
     */

    final static public int NULL = 0;
    final static public String NOT_SPECIFIED = "Not Specified";
    final static public Integer NONE = 0;
    final static public boolean FALSE = false;
    final static public boolean TRUE = true;

    /*
    Suggestion tags
     */

    final static public String TEXT_SUGGESTION = "Text Suggestion";
    final static public String DEBATE = "Debate";
    final static public String SURVEY = "Survey";

    /*
    Group tags
     */
    final static public String OPEN = "Open";
    final static public String CLOSED = "Closed";

    /*
    JSON parsing
     */

    final static public String ERROR_OCCURRANCE = "An error has occurred.";
    final static public String TAG_SUCCESS = "success";
    final static public String TAG_FAILURE = "failure";
    final static public String TAG_MESSAGE = "message";
    final static public String TAG_GROUPID = "GroupID";
    final static public String TAG_POSTS = "posts";
    final static public String TAG_NAME = "Name";
}
