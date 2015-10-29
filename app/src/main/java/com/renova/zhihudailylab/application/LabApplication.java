package com.renova.zhihudailylab.application;

import android.app.Application;

import com.facebook.stetho.Stetho;
import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;

/**
 * init
 * Created by Renova on 2015/10/29.
 */
public class LabApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initialize(Stetho
                .newInitializerBuilder(this)
                .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                .enableWebKitInspector(
                        Stetho.defaultInspectorModulesProvider(this))
                .build());
        Logger
                .init()               // default PRETTYLOGGER or use just init()
                .setMethodCount(3)            // default 2
                .setLogLevel(LogLevel.FULL);  // default LogLevel.FULL
    }


}
