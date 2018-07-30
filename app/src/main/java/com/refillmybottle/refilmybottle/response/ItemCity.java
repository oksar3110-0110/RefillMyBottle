package com.refillmybottle.refilmybottle.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by abah on 26/07/18.
 */

public class ItemCity {
    @SerializedName("city")
    private String city;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
