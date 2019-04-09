package com.example.myapplication.network;

import com.example.myapplication.model.BondTO;
import com.example.myapplication.model.LoginDTO;
import com.example.myapplication.model.User;
import com.example.myapplication.model.UserInfoTO;
import com.google.gson.JsonObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface BondManagementService {
    @Headers({"Content-Type:application/json"})

    @POST("/users")
    Call<JsonObject> register(@Body User user);

    @POST("/login")
    Call<UserInfoTO> login(@Body LoginDTO loginDTO);

    @GET("/bonds/{id}")
    Call<List<BondTO>> getBondList(@Path("id") Long userId);
}
