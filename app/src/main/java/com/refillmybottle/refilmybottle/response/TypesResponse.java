package com.refillmybottle.refilmybottle.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by abah on 30/07/18.
 */

public class TypesResponse {
    @SerializedName("status")
    private int status;
    @SerializedName("data")
    private List<ItemTypes> data;
    @SerializedName("msg")
    private String msg;

    public void setData(List<ItemTypes> data) {
        this.data = data;
    }

    public List<ItemTypes> getData() {
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
