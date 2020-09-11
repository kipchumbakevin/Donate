package com.donate.donate.networking;

import com.donate.donate.models.MessageModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;

public interface JsonPlaceHolderInterface {
    @FormUrlEncoded
    @POST("api/stk")
    Call<MessageModel> initiate(
            @Field("phone") String phone,
            @Field("amount") String am
    );
}
