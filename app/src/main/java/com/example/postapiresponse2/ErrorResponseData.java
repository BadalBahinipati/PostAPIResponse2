package com.example.postapiresponse2;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ErrorResponseData {
    @SerializedName("status")
    @Expose
    private int errorStatusCode;

    @SerializedName("errorMessage")
    @Expose
    private String errorMsg;

    public ErrorResponseData() {

        this.errorMsg = errorMsg;
        this.errorStatusCode = errorStatusCode;
    }

    public int getErrorStatusCode() {
        return errorStatusCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }
}

