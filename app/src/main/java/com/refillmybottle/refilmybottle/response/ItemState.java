package com.refillmybottle.refilmybottle.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by abah on 26/07/18.
 */

public class ItemState {
    @SerializedName("state")
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
