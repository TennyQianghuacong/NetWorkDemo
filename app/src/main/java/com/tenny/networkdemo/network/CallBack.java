package com.tenny.networkdemo.network;

/**
 * Created by TennyQ on 12/23/20
 */
public interface CallBack<T> {

    void success(T result);

    void failed(String errorMsg);

}
