package com.refillmybottle.refilmybottle.ServicesHandler;

import android.app.VoiceInteractor;

import okhttp3.Request;

/**
 * Created by abah on 13/07/18.
 */

public class Utils {
//    public static final String BASE_URL = "http://botol.dzen1010.ga/index.php/";
    public static final String BASE_URL = "http://192.168.1.20/htdocs/magang/index.php/";

    public static RequestInterfaces getApiServices(){
        return RetrofitClient.getClient(BASE_URL).create(RequestInterfaces.class);
    }
}
