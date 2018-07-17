package com.refillmybottle.refilmybottle.ServicesHandler;

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
    @POST("do=login")
    Call<ResponseBody> loginRequest (
                        @Field("mail") String mail,
                        @Field("pass") String pass);


}
