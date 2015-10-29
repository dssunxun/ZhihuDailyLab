package com.renova.zhihudailylab.executor;

import android.os.Handler;
import android.os.Looper;

/**
 * 获取UI线程的Singleton
 * Created by Renova on 2015/10/29.
 */
public class MainThreadExecutor {
    private static MainThreadExecutor ourInstance = new MainThreadExecutor();
    private Handler handler;
    public static MainThreadExecutor getInstance() {
        return ourInstance;
    }

    private MainThreadExecutor() {
        this.handler = new Handler(Looper.getMainLooper());
    }

    public void execute(Runnable runnable) {
        handler.post(runnable);
    }
    public void executeDelayed(Runnable runnable,long delayMillis)
    {
        handler.postDelayed(runnable,delayMillis);
    }
    public void removeAll() {
        handler.removeCallbacksAndMessages(null);
    }
}
