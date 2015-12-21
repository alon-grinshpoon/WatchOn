package com.watchon.watchon.server;

import com.watchon.watchon.db.Data;

import java.io.IOException;

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
        this.setMessage(e.getMessage().substring(e.getMessage().indexOf(")") + 1));
        this.setStatusCode(Integer.parseInt(e.getMessage().substring(e.getMessage().indexOf("(") + 1, e.getMessage().indexOf(")"))));
    }
}