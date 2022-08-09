package com.example.postapiresponse2;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PassData {
    @SerializedName("userName")
    @Expose
    private String userName;

    @SerializedName("deviceSlNo")
    @Expose
    private String deviceSlNo;

    @SerializedName("bankName")
    @Expose
    private String bankName;

    public PassData(String userName, String deviceSlNo, String bankName) {
        this.userName = userName;
        this.deviceSlNo = deviceSlNo;
        this.bankName = bankName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDeviceSlNo() {
        return deviceSlNo;
    }

    public void setDeviceSlNo(String deviceSlNo) {
        this.deviceSlNo = deviceSlNo;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
}
