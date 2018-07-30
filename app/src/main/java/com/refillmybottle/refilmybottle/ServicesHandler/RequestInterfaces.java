package com.refillmybottle.refilmybottle.ServicesHandler;

import com.refillmybottle.refilmybottle.response.RelationResponse;
import com.refillmybottle.refilmybottle.response.ResponseCity;
import com.refillmybottle.refilmybottle.response.ResponseCountry;
import com.refillmybottle.refilmybottle.response.TypesResponse;
import com.refillmybottle.refilmybottle.response.response_state;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by abah on 13/07/18.
 */

public interface RequestInterfaces {
    @FormUrlEncoded
    @POST("water?do=login")
    Call<ResponseBody> loginRequest (
                        @Field("mail") String Username,
                        @Field("pass") String Password);

    @FormUrlEncoded
    @POST("water?do=register")
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

    @FormUrlEncoded
    @POST("water?do=geo")
    Call<ResponseCountry> getCountry(@Field("abc") String abc);

    @GET("water?do=relation")
    Call<RelationResponse> getRelationData();

    @GET("water?do=types")
    Call<TypesResponse> getTypesData();

    @FormUrlEncoded
    @POST("water?do=geo")
    Call<response_state> getState(@Field("state") String State);

    @FormUrlEncoded
    @POST("water?do=geo")
    Call<ResponseCity> getCity(@Field("city") String city);

}
