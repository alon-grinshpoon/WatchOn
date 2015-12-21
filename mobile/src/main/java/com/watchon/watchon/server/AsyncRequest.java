package com.watchon.watchon.server;

import android.os.AsyncTask;

import com.watchon.watchon.db.Data;

import java.io.IOException;

/**
 * An implementation of an asynchronous operation used to create server calls.
 */
public class AsyncRequest extends AsyncTask<Object, Void, AsyncResult> {

    /* The calling class object for this asynchronous request */
    AsyncResponse sendResponseTo;

    /* Constructor */
    public AsyncRequest(AsyncResponse sendResponseTo){
        this.sendResponseTo = sendResponseTo;
    }

    @Override
    protected AsyncResult doInBackground(Object... objects) {

        // Define result
        AsyncResult result = new AsyncResult();

        // Get server action (Always the first parameter)
        int serverAction = (int) objects[0];

        // Define parameters
        Data data;

        // Perform server action
        switch (serverAction){

            case Server.SERVER_ACTION_SEND_DATA:
                // Parse parameter
                data = (Data) objects[1];
                // Run server action
                try {
                    boolean success = Server.sendData(data);
                    // Configure result
                    data = result.getData();
                } catch (IOException e) {
                    // Configure result as error
                    result.catchException(e);
                }
                break;
            default:
                break;
        }

        return result;
    }

    protected void onPostExecute(AsyncResult result) {
        sendResponseTo.handleResult(result);
    }
}
