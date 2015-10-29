package com.renova.zhihudailylab.interactor;

import com.renova.zhihudailylab.interactor.listener.OnLatestNewsListener;

/**
 * 最新新闻
 * Created by Renova on 2015/10/29.
 */
public interface LatestNewsInteractor {
    void getLatestNews(OnLatestNewsListener latestNewsListener);
}
