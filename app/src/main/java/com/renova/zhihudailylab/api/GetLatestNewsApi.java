package com.renova.zhihudailylab.api;

import android.text.TextUtils;

import com.google.gson.Gson;
import com.renova.zhihudailylab.Constants;
import com.renova.zhihudailylab.base.BaseApi;
import com.renova.zhihudailylab.entities.LatestNews;

import java.io.IOException;

/**
 * 获取最新新闻
 * Created by Renova on 2015/10/29.
 */
public class GetLatestNewsApi extends BaseApi {

    public static String getLatestNews()
    {
        String news= "";

        try {
            news=doGetMethodGetJsonResponse(Constants.LATEST_NEWS_URL);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return news;



    }
}
