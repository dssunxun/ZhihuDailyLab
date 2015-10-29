package com.renova.zhihudailylab.interactor.listener;

/**
 * Created by Renova on 2015/10/29.
 */
public interface BaseInterface {
    void onPreLoad();
    void onSuccess();
    void onFailure(String errorMsg);
}
