package com.example.islam.theoplayerintegration.app;

import android.app.Application;

import com.example.islam.theoplayerintegration.data.TheoPlayerIntegrationRepository;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

/**
 * Created by "Islam Farid" on 10/18/2018.
 */
@Singleton
@Component(modules = {TheoPlayerIntegrationModule.class})
public interface TheoPlayerIntegrationComponent {
    TheoPlayerIntegrationRepository getTheoPlayerIntegrationRepository();

    void inject(TheoPlayerIntegrationAPP app);

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        TheoPlayerIntegrationComponent build();
    }
}
