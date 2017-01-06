package com.brianpcharles.communitree.models;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

/**
 * Created by bcharles on 1/5/17.
 */

public class SessionManager {

    SharedPreferences prefs;

    SharedPreferences.Editor editor;

    public final static String CTAPP_KEY = "CTAPP";
    public final static String LOGIN_KEY = "LOGIN";
    public final static String USER_KEY = "USER";

    public SessionManager(Context context) {
        prefs = context.getSharedPreferences(CTAPP_KEY, Context.MODE_PRIVATE);
        editor = prefs.edit();
    }

    public void login(User user) {
        editor.putBoolean(LOGIN_KEY, true);
        editor.putString(USER_KEY, user.getUserID());
    }

    public void logout() {
        editor.putBoolean(LOGIN_KEY, false);
        editor.remove(USER_KEY);
    }
}
