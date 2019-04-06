package com.example.myapplication.network;

import com.example.myapplication.model.User;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface BondManagementService {
    @Headers({"Content-Type:application/json"})

    @POST("/users")
    Call<JsonObject> register(@Body User user);
}
