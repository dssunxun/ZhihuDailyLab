package com.renova.zhihudailylab.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.Toast;

import com.orhanobut.logger.Logger;
import com.renova.zhihudailylab.R;
import com.renova.zhihudailylab.api.GetLatestNewsApi;
import com.renova.zhihudailylab.entities.LatestNews;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.btn)
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn)
     void test() {
        Toast.makeText(this, "click", Toast.LENGTH_SHORT)
                .show();
        new Thread(new Runnable() {
            @Override
            public void run() {
                LatestNews latestNews = GetLatestNewsApi.getLatestNews();
                Logger.d(latestNews.toString());
            }
        }).start();
    }
}
