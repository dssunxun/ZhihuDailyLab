package com.renova.zhihudailylab.utils;

import com.facebook.stetho.okhttp.StethoInterceptor;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * OKHTTP工具类
 * Created by Renova on 2015/10/29.
 */
public class OkHttpUtils {
    private static volatile OkHttpUtils INSTANCE = null;
    private OkHttpClient mOkHttpClient;
    public static OkHttpUtils getInstance() {
        if (INSTANCE == null) {
            synchronized (OkHttpUtils.class) {
                if (INSTANCE == null) {
                    INSTANCE = new OkHttpUtils();
                }
            }
        }
        return INSTANCE;
    }

    private OkHttpUtils() {
        if (mOkHttpClient == null) {
            mOkHttpClient = new OkHttpClient();
        }
        mOkHttpClient.setConnectTimeout(10, TimeUnit.SECONDS);

        mOkHttpClient.networkInterceptors().add(new StethoInterceptor());

    }

    public Response execute(Request request)  {
        try {

            return   mOkHttpClient.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public  void enqueue(Request request, Callback responseCallback){
        mOkHttpClient.newCall(request).enqueue(responseCallback);
    }
}
