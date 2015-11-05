package com.renova.zhihudailylab.view;

import com.renova.zhihudailylab.entities.LatestNews;

import java.util.List;

/**
 * Created by Renova on 2015/10/30.
 */
public interface ShowLatestNewsView  {
    void showProgress();
    void setTopNews(List<LatestNews.TopStorie> topNews );
    void setDailyNews(List<LatestNews.Storie> dailyNews);
    void hideProgress();
    void showFailureMsg(String msg);
}
