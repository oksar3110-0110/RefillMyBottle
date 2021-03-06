package com.refillmybottle.refilmybottle.response;

import com.google.gson.annotations.SerializedName;
import com.refillmybottle.refilmybottle.model.States;

import java.util.List;

/**
 * Created by abah on 24/07/18.
 */

public class response_state {
    @SerializedName("status")
    private int status;
    @SerializedName("data")
    private List<ItemState> data;
    @SerializedName("msg")
    private String msg;

    public void setData(List<ItemState> data) {
        this.data = data;
    }

    public List<ItemState> getData() {
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
