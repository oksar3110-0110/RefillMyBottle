package com.refillmybottle.refilmybottle.ServicesHandler;

import android.app.VoiceInteractor;

import okhttp3.Request;

/**
 * Created by abah on 13/07/18.
 */

public class Utils {
    public static final String BASE_URL = "http://botol.virkill.url.ph/";

    public static RequestInterfaces getApiServices(){
        return RetrofitClient.getClient(BASE_URL).create(RequestInterfaces.class);
    }
}
