package com.watchon.watchon.server;

import android.graphics.Bitmap;

import com.watchon.watchon.db.Data;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * An implementation of an result of a asynchronous operation used to parse server responses.
 */
public class AsyncResult {

    private Data data;

    private boolean error = false;
    private String message = "";
    private int statusCode = 200;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public boolean errored() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    /**
     * Parses a caught exception into this result.
     * @param e A caught IO exception
     */
    public void catchException(IOException e){
        this.setError(true);
        this.setMessage(e.getMessage());
        this.setStatusCode(100);
    }
}