package com.brianpcharles.communitree;

import android.app.Application;
import android.content.Context;

import io.realm.Realm;

/**
 * Created by bcharles on 1/5/17.
 */

public class CTApp extends Application {

    private static Context sContext;

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);

        sContext = this.getBaseContext();
    }

    public static Context getContext() {
        return sContext;
    }
}
