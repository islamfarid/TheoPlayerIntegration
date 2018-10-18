package com.example.islam.theoplayerintegration.app;

import android.app.Application;
import android.content.Context;

import com.example.islam.theoplayerintegration.data.TheoPlayerIntegrationRepository;
import com.example.islam.theoplayerintegration.data.TheoPlayerIntegrationRepositoryImp;
import com.example.islam.theoplayerintegration.data.local.assets.AssetsRepo;
import com.example.islam.theoplayerintegration.data.local.assets.AssetsRepoImp;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by "Islam Farid" on 10/18/2018.
 */
@Module
public class TheoPlayerIntegrationModule {
    @Provides
    @Singleton
    Context provideContext(Application application) {
        return application.getApplicationContext();
    }
    @Singleton
    @Provides
    AssetsRepo provideAssetsDataSource(Application application) {
        return new AssetsRepoImp(application.getApplicationContext());
    }

    @Singleton
    @Provides
    TheoPlayerIntegrationRepository provideTheoPlayerRepository(Application application, AssetsRepo assetsRepo) {
        return new TheoPlayerIntegrationRepositoryImp(application.getApplicationContext(), assetsRepo);
    }


}
