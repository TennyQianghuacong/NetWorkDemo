package com.tenny.networkdemo.network;

import com.tenny.networkdemo.entiy.GPSResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by TennyQ on 12/23/20
 */
public interface GPSService {

    @GET("pro/gps.json")
    Call<GPSResponse> requestGPS();

    @GET("users/{user}/repos")
    Call<String> listRepos(@Path("user") String user);

}
