package com.example.islam.theoplayerintegration.data.local.assets;

import io.reactivex.Observable;

/**
 * Created by "Islam Farid" on 10/18/2018.
 */
public interface AssetsRepo {
    public <T> Observable<T> loadJSONFromAsset(final String jsonFileName, final Class<T> type);
}
