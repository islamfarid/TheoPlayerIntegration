package com.example.islam.theoplayerintegration.data;

import android.content.Context;

import com.example.islam.theoplayerintegration.data.local.assets.AssetsRepo;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by "Islam Farid" on 10/18/2018.
 */

public class TheoPlayerIntegrationRepositoryImp implements TheoPlayerIntegrationRepository {
    private AssetsRepo mAssetsRepo;
    private Context context;
    @Inject
    public TheoPlayerIntegrationRepositoryImp(Context context,  AssetsRepo assetsRepo) {
        this.context = context;
        this.mAssetsRepo = assetsRepo;
    }
    @Override
    public <T> Observable<T> loadJSONFromAsset(String jsonFileName, Class<T> type) {
        return mAssetsRepo.loadJSONFromAsset(jsonFileName,type);
    }
}
