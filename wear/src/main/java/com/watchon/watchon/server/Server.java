package com.watchon.watchon.server;

import android.util.Log;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.watchon.watchon.db.Data;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Class implementation of all valid server calls.
 */
public class Server {

    /**
     * Server URL
     */
    private static final String server = "http://app-hackthebrain.rhcloud.com/api/";

    public static final int SERVER_ACTION_SEND_DATA = 0;

    protected static final boolean sendData(Data data) throws IOException {
        boolean success = true;
        String json = new Gson().toJson(data, Data.class);
        String jsonResponse = HTTPHandler.postRequest(server + "/setData/", json);
        if (checkJSONError(jsonResponse)){
            success = false;
        }
        return success;
    }

    /**
     * Check JSON validity
     * @param json A JSON object as a string
     * @return The if the JSON is valid
     */
    private static final boolean checkJSONError(String json){
        return (json == null || json.equalsIgnoreCase("{}"));
    }

}