package com.renova.zhihudailylab.ui;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.renova.zhihudailylab.R;
import com.renova.zhihudailylab.adapter.LatestNewsAdapter;
import com.renova.zhihudailylab.entities.LatestNews;
import com.renova.zhihudailylab.executor.MainThreadExecutor;
import com.renova.zhihudailylab.presenter.LatestNewsPresenter;
import com.renova.zhihudailylab.presenter.impl.LatestNewsPresenterImpl;
import com.renova.zhihudailylab.view.ShowLatestNewsView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements ShowLatestNewsView{

    private LatestNewsPresenter presenter;

    @Bind(R.id.my_recycler_view)
    RecyclerView recyclerview;
    private ProgressDialog waitDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        TabLayout tabs = (TabLayout) findViewById(R.id.tabs);
        tabs.addTab(tabs.newTab()
                .setText("Tab 1"));
        tabs.addTab(tabs.newTab()
                .setText("Tab 2"));
        tabs.addTab(tabs.newTab()
                .setText("Tab 3"));
        presenter = new LatestNewsPresenterImpl(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerview.setLayoutManager(linearLayoutManager);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    @Override
    public void showProgress() {
        waitDialog = new ProgressDialog(this);
        waitDialog.setMessage("请等待......");
        waitDialog.setIndeterminate(true);
        waitDialog.setCanceledOnTouchOutside(false);
        waitDialog.show();
    }

    @Override
    public void setTopNews(List<LatestNews.TopStorie> topNews) {

    }

    @Override
    public void setDailyNews(final List<LatestNews.Storie> dailyNews) {
        Log.d("MainActivity", dailyNews.toString());

        MainThreadExecutor.getInstance().execute(new Runnable() {
            @Override
            public void run() {
                LatestNewsAdapter adapter = new LatestNewsAdapter(MainActivity.this, dailyNews);

                recyclerview.setAdapter(adapter);

                recyclerview.setHasFixedSize(true);

            }
        });

    }

    @Override
    public void hideProgress() {
        if (waitDialog!=null)
        {
            waitDialog.dismiss();
        }
    }

    @Override
    public void showFailureMsg(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT)
                .show();
    }
}
