package com.renova.zhihudailylab.presenter.impl;

import com.renova.zhihudailylab.entities.LatestNews;
import com.renova.zhihudailylab.executor.MainThreadExecutor;
import com.renova.zhihudailylab.interactor.LatestNewsInteractor;
import com.renova.zhihudailylab.interactor.impl.LatestNewsInteractorImpl;
import com.renova.zhihudailylab.interactor.listener.OnLatestNewsListener;
import com.renova.zhihudailylab.presenter.LatestNewsPresenter;
import com.renova.zhihudailylab.view.ShowLatestNewsView;

/**  latest news presenter
 * Created by Renova on 2015/10/30.
 */
public class LatestNewsPresenterImpl  implements LatestNewsPresenter,OnLatestNewsListener{


    private LatestNewsInteractor latestNewsInteractor;
    private ShowLatestNewsView showLatestNewsView;

    public LatestNewsPresenterImpl(ShowLatestNewsView showLatestNewsView) {
        this.showLatestNewsView = showLatestNewsView;
        latestNewsInteractor = new LatestNewsInteractorImpl();
    }

    @Override
    public void onResume() {
        latestNewsInteractor.getLatestNews(this);
    }

    @Override
    public void setLatestNews(final LatestNews latestNews) {
                showLatestNewsView.setDailyNews(latestNews.getStories());
                showLatestNewsView.setTopNews(latestNews.getTop_stories());
    }

    @Override
    public void onPreLoad() {
        MainThreadExecutor.getInstance().execute(new Runnable() {
            @Override
            public void run() {
                showLatestNewsView.showProgress();
            }
        });
    }

    @Override
    public void onSuccess() {
        MainThreadExecutor.getInstance().execute(new Runnable() {
            @Override
            public void run() {
                showLatestNewsView.hideProgress();
            }
        });

    }

    @Override
    public void onFailure(final String errorMsg) {
        MainThreadExecutor.getInstance().execute(new Runnable() {
            @Override
            public void run() {
                showLatestNewsView.showFailureMsg(errorMsg);
            }
        });
    }
}
