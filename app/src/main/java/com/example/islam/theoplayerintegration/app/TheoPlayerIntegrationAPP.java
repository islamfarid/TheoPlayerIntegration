package com.example.islam.theoplayerintegration.app;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

/**
 * Created by "Islam Farid" on 10/18/2018.
 */

public class TheoPlayerIntegrationAPP extends Application {
    TheoPlayerIntegrationComponent mTheoPlayerIntegrationComponent;
    RefWatcher mRefWatcher;

    @Override
    public void onCreate() {
        super.onCreate();
        mRefWatcher = LeakCanary.install(this);
        mTheoPlayerIntegrationComponent = DaggerTheoPlayerIntegrationComponent.builder()
                .application(this)
                .build();

    }

    public TheoPlayerIntegrationComponent getTheoPlayerIntegrationComponentComponent() {
        return mTheoPlayerIntegrationComponent;
    }

    public void mustDie(Object object) {
        if (mRefWatcher != null) {
            mRefWatcher.watch(object);
        }
    }
}
