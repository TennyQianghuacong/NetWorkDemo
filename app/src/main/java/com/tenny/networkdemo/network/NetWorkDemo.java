package com.tenny.networkdemo.network;

import android.util.Log;

import com.tenny.networkdemo.entiy.GPSEntity;
import com.tenny.networkdemo.entiy.GPSResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by TennyQ on 12/23/20
 */
public class NetWorkDemo {

    public static final String TAG = "NetWorkDemo";

    private Retrofit retrofit;

    private CallBack<GPSEntity> callBack;

    public NetWorkDemo(CallBack<GPSEntity> callBack) {
        this.callBack = callBack;
    }

    private Retrofit getRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://8.129.87.47/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;
    }

    public void request() {
        if (retrofit == null) {
            retrofit = getRetrofit();
        }

        GPSService gpsService = retrofit.create(GPSService.class);

        gpsService.requestGPS().enqueue(new Callback<GPSResponse>() {
            @Override
            public void onResponse(Call<GPSResponse> call, Response<GPSResponse> response) {
                Log.d(TAG, response.body().toString());
                if (callBack != null) {
                    if (response.body() != null && response.body().getGPS() != null) {
                        callBack.success(response.body().getGPS());
                    } else {
                        callBack.failed("数据为空");
                    }
                }
            }

            @Override
            public void onFailure(Call<GPSResponse> call, Throwable t) {
                Log.d(TAG, t.getMessage());
                if (callBack != null) {
                    callBack.failed(t.getMessage());
                }
            }
        });
    }

    public void release() {
        callBack = null;
    }

}
