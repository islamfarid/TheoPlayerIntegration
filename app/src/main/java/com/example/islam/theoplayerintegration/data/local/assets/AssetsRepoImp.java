package com.example.islam.theoplayerintegration.data.local.assets;

import android.content.Context;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

/**
 * Created by "Islam Farid" on 10/18/2018.
 */

public class AssetsRepoImp implements AssetsRepo {
    private Context mContext;

    @Inject
    public AssetsRepoImp(Context context) {
        mContext = context;
    }

    /**
     * @param jsonFileName
     * @param type
     * @param <T>
     * @return
     */
    @Override
    public <T> Observable<T> loadJSONFromAsset(final String jsonFileName, final Class<T> type) {
        return Observable.create(new ObservableOnSubscribe<T>() {
            @Override
            public void subscribe(ObservableEmitter<T> emitter) {
                String json = null;
                try {
                    InputStream is = mContext.getAssets().open(jsonFileName);
                    int size = is.available();
                    byte[] buffer = new byte[size];
                    is.read(buffer);
                    is.close();
                    json = new String(buffer, "UTF-8");
                    Gson gson = new Gson();
                    emitter.onNext(gson.fromJson(json, type));
                    emitter.onComplete();
                } catch (IOException ex) {
                    emitter.onError(ex);
                }
            }
        });

    }
}
