package com.refillmybottle.refilmybottle.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by abah on 26/07/18.
 */

public class ItemCountry {
    @SerializedName("country")
    private String country;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
