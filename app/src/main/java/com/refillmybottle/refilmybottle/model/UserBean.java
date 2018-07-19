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

class UserBean {
    @SerializedName("email")
    private String email;
    @SerializedName("photo")
    private String photo;
    @SerializedName("namadpn")
    private String namadpn;
    @SerializedName("namablk")
    private String namablk;
    @SerializedName("profil")
    private ProfilBean profil;
    @SerializedName("status")
    private StatusBean status;

    public static List<UserBean> arrayUserBeanFromData(String str, String key) {

        try {
            JSONObject jsonObject = new JSONObject(str);
            Type listType = new TypeToken<ArrayList<UserBean>>() {
            }.getType();

            return new Gson().fromJson(jsonObject.getString(str), listType);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new ArrayList();


    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getNamadpn() {
        return namadpn;
    }

    public void setNamadpn(String namadpn) {
        this.namadpn = namadpn;
    }

    public String getNamablk() {
        return namablk;
    }

    public void setNamablk(String namablk) {
        this.namablk = namablk;
    }

    public ProfilBean getProfil() {
        return profil;
    }

    public void setProfil(ProfilBean profil) {
        this.profil = profil;
    }

    public StatusBean getStatus() {
        return status;
    }

    public void setStatus(StatusBean status) {
        this.status = status;
    }
}
