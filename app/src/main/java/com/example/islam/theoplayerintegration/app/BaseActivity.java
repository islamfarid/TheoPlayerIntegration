package com.example.islam.theoplayerintegration.app;

import android.support.v7.app.AppCompatActivity;

/**
 * Created by "Islam Farid" on 10/18/2018.
 */

public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onDestroy() {
        ((TheoPlayerIntegrationAPP) getApplication()).mustDie(this);
        super.onDestroy();
    }
}
