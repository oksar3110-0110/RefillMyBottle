package com.refillmybottle.refilmybottle.response;

import android.content.ClipData;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by abah on 26/07/18.
 */

public class ResponseCountry {
    @SerializedName("status")
    private int status;
    @SerializedName("data")
    private List<ItemCountry> data;
    @SerializedName("msg")
    private String msg;

    public void setData(List<ItemCountry> data) {
        this.data = data;
    }

    public List<ItemCountry> getData() {
        return data;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
}
