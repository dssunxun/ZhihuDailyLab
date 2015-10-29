package com.renova.zhihudailylab.interactor.impl;

import com.google.gson.Gson;
import com.renova.zhihudailylab.api.GetLatestNewsApi;
import com.renova.zhihudailylab.base.BaseApi;
import com.renova.zhihudailylab.entities.LatestNews;
import com.renova.zhihudailylab.executor.ThreadExecutor;
import com.renova.zhihudailylab.interactor.LatestNewsInteractor;
import com.renova.zhihudailylab.interactor.listener.OnLatestNewsListener;

/**
 *
 * Created by Renova on 2015/10/29.
 */
public class LatestNewsInteractorImpl implements LatestNewsInteractor {
    @Override
    public void getLatestNews(OnLatestNewsListener latestNewsListener) {
        ThreadExecutor.getInstance().execute(new LatestNewsRunnable(latestNewsListener));
    }


    private class LatestNewsRunnable implements Runnable
    {
        OnLatestNewsListener listener;

        public LatestNewsRunnable(
                OnLatestNewsListener listener) {
            this.listener = listener;
        }

        @Override
        public void run() {
            listener.onPreLoad();
            String latestNews = GetLatestNewsApi.getLatestNews();
            boolean responseSuccessful = BaseApi.isResponseSuccessful(latestNews);

            if (responseSuccessful) {
                Gson gson = new Gson();
                LatestNews latestNewsEntity = gson.fromJson(latestNews, LatestNews.class);
                listener.setLatestNews(latestNewsEntity);
                listener.onSuccess();
            }
            else
            {
                listener.onFailure(latestNews);
            }
        }
    }

}
