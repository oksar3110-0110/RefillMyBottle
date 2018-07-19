package com.refillmybottle.refilmybottle.ServicesHandler;

import java.sql.Date;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by abah on 13/07/18.
 */

public interface RequestInterfaces {
    @FormUrlEncoded
    @POST("index.php?do=login")
    Call<ResponseBody> loginRequest (
                        @Field("mail") String Username,
                        @Field("pass") String Password);

    @FormUrlEncoded
    @POST("index.php?register")
    Call<ResponseBody> registerrequest(
            @Field("namadpn") String namadpn,
            @Field("namablk") String namablk,
            @Field("mail") String mail,
            @Field("mail1") String mail1,
            @Field("pass") String pass,
            @Field("pass1") String pass1,
            @Field("tgl") String tgl,
            @Field("ngr") String ngr,
            @Field("prov") String prov,
            @Field("kot") String kot,
            @Field("jln") String jln,
            @Field("img") String img
    );

}
