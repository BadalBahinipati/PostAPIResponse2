package com.example.postapiresponse2;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseData {
    @SerializedName("status")
    @Expose
    private final int statusCode;

    @SerializedName("statusDesc")
    @Expose
    private final String description;

    @SerializedName("message")
    @Expose
    private final String responseMsg;


    public ResponseData(int statusCode, String description, String responseMsg) {
        this.statusCode = statusCode;
        this.description = description;
        this.responseMsg = responseMsg;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getDescription() {
        return description;
    }

    public String getResponseMsg() {
        return responseMsg;
    }

}
