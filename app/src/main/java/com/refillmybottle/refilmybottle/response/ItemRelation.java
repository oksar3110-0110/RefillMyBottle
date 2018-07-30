package com.refillmybottle.refilmybottle.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by abah on 30/07/18.
 */

public class ItemRelation {
    @SerializedName("nama")
    private String nama;

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
}
