package com.example.myapplication.network;

import android.util.Log;
import android.widget.Toast;

import com.example.myapplication.GlobalApplication;
import com.example.myapplication.R;
import com.example.myapplication.listener.SuccessGetBondListListener;
import com.example.myapplication.listener.SuccessLoginListener;
import com.example.myapplication.listener.SuccessRegistrationListener;
import com.example.myapplication.model.BondTO;
import com.example.myapplication.model.LoginDTO;
import com.example.myapplication.model.User;
import com.example.myapplication.model.UserInfoTO;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitManager {

    private static String TAG = "Retrofit";
    //        final private String requestURL = "http://ec2-52-79-237-242.ap-northeast-2.compute.amazonaws.com:8080";
    final private String requestURL = "http://10.0.2.2:8080";
    private static RetrofitManager retrofitManager;
    private Retrofit retrofit;
    private BondManagementService service;
    private SuccessRegistrationListener mSuccessRegistrationListener;
    private SuccessLoginListener mSuccessLoginListener;
    private SuccessGetBondListListener mSuccessGetBondListListener;

    private RetrofitManager() {
        retrofit = new Retrofit.Builder().baseUrl(requestURL).addConverterFactory(GsonConverterFactory.create(new GsonBuilder().create())).build();
        service = retrofit.create(BondManagementService.class);
    }

    public static RetrofitManager getInstance() {
        if (retrofitManager == null) retrofitManager = new RetrofitManager();
//        userId = GlobalApplication.getGlobalContext().getSharedPreferences("user", MODE_PRIVATE).getLong("userId", -1);
        return retrofitManager;
    }

    public void setOnSuccessRegistrationListener(SuccessRegistrationListener mSuccessRegistrationListener) {
        this.mSuccessRegistrationListener = mSuccessRegistrationListener;
    }

    public void removeSuccessRegistrationListener() {
        this.mSuccessRegistrationListener = null;
    }

    public void setOnSuccessLoginListener(SuccessLoginListener mSuccessLoginListener) {
        this.mSuccessLoginListener = mSuccessLoginListener;
    }

    public void removeSuccessLoginListener() {
        this.mSuccessLoginListener = null;
    }

    public void setOnSuccessGetBondListListener(SuccessGetBondListListener mSuccessGetBondListListener) {
        this.mSuccessGetBondListListener = mSuccessGetBondListListener;
    }

    public void removeSuccessGetBondListListener() {
        this.mSuccessGetBondListListener = null;
    }

    private void logForErrorResponse(int errorCode, String errorMessage, String methodName) {
        Log.e(TAG, methodName + " Error Code: " + errorCode);
        Log.e(TAG, methodName + ": " + errorMessage);
    }

    private void logForFailureConnection(String errorMessage, String methodName) {
        Toast.makeText(GlobalApplication.getGlobalContext(), R.string.error_message_for_network_unavailable, Toast.LENGTH_LONG).show();
        Log.e(TAG, methodName + ": " + errorMessage);
    }

    public void register(User user) {
        final String methodName = "register";
        Call<JsonObject> req = service.register(user);
        req.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.isSuccessful()) {
                    if (mSuccessRegistrationListener != null) {
                        mSuccessRegistrationListener.onSuccessRegister();
                    }
                } else {
                    logForErrorResponse(response.code(), response.errorBody().toString(), methodName);
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                logForFailureConnection(t.getMessage(), methodName);
            }
        });
    }

    public void login(LoginDTO loginDTO) {
        final String methodName = "login";
        Call<UserInfoTO> req = service.login(loginDTO);
        req.enqueue(new Callback<UserInfoTO>() {
            @Override
            public void onResponse(Call<UserInfoTO> call, Response<UserInfoTO> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(GlobalApplication.getGlobalContext(), R.string.login_success_message, Toast.LENGTH_LONG).show();
                    Log.i(TAG, methodName + ": loginSuccess, user_id = " + response.body().getUserId());
                    if (mSuccessLoginListener != null) {
                        mSuccessLoginListener.onSuccessLogin(response.body().getUserId(), response.body().getName());
                    }
                } else {
                    Toast.makeText(GlobalApplication.getGlobalContext(), R.string.login_fail_message, Toast.LENGTH_LONG).show();
                    logForErrorResponse(response.code(), response.errorBody().toString(), methodName);
                }
            }

            @Override
            public void onFailure(Call<UserInfoTO> call, Throwable t) {
                logForFailureConnection(t.getMessage(), methodName);
            }
        });
    }

    public void getBondList(Long userId) {
        final String methodName = "getBondList";
        Call<List<BondTO>> req = service.getBondList(userId);
        req.enqueue(new Callback<List<BondTO>>() {
            @Override
            public void onResponse(Call<List<BondTO>> call, Response<List<BondTO>> response) {
                if (response.isSuccessful()) {
                    Log.i(TAG, methodName + "bond list size: " + response.body().size());
                    if (mSuccessGetBondListListener != null) {
                        mSuccessGetBondListListener.onSuccessGetBondList(response.body());
                    }
                } else {
                    Toast.makeText(GlobalApplication.getGlobalContext(), R.string.get_bondlist_fail_message, Toast.LENGTH_LONG).show();
                    logForErrorResponse(response.code(), response.errorBody().toString(), methodName);
                }
            }

            @Override
            public void onFailure(Call<List<BondTO>> call, Throwable t) {
                logForFailureConnection(t.getMessage(), methodName);
            }
        });
    }
}
