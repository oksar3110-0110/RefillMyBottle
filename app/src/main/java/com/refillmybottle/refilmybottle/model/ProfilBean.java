package com.refillmybottle.refilmybottle.model;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by abah on 19/07/18.
 */

class ProfilBean {
    @SerializedName("tgl")
    private String tgl;
    @SerializedName("negara")
    private String negara;
    @SerializedName("prov")
    private String prov;
    @SerializedName("kota")
    private String kota;
    @SerializedName("jln")
    private String jln;

    public static List<ProfilBean> arrayProfilBeanFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<ProfilBean>>() {
            }.getType();

            return new Gson().fromJson(jsonObject.getString(str), listType);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new ArrayList();


    }

    public String getTgl() {
        return tgl;
    }

    public void setTgl(String tgl) {
        this.tgl = tgl;
    }

    public String getNegara() {
        return negara;
    }

    public void setNegara(String negara) {
        this.negara = negara;
    }

    public String getProv() {
        return prov;
    }

    public void setProv(String prov) {
        this.prov = prov;
    }

    public String getKota() {
        return kota;
    }

    public void setKota(String kota) {
        this.kota = kota;
    }

    public String getJln() {
        return jln;
    }

    public void setJln(String jln) {
        this.jln = jln;
    }
}
