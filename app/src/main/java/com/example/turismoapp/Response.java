package com.example.turismoapp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Response {

    @SerializedName("error")
    @Expose
    String error;

    @SerializedName("succesfull")
    @Expose
    String succesfull;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getSuccesfull() {
        return succesfull;
    }

    public void setSuccesfull(String succesfull) {
        this.succesfull = succesfull;
    }
}
