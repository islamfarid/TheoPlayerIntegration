package com.example.islam.theoplayerintegration.data;

import io.reactivex.Observable;

/**
 * Created by "Islam Farid" on 10/18/2018.
 */

public interface TheoPlayerIntegrationRepository {
    public <T> Observable<T> loadJSONFromAsset(final String jsonFileName, final Class<T> type);
}
