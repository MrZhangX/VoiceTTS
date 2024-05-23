package com.iflytek.business;

import android.content.Context;
import android.content.SharedPreferences;

public class SpeechConfig {
    public static final String KEY_SPEAKER_SETTING = "speaker_setting";
    public static final String PREFER_NAME = "com.iflytek.speechconfig";
    private static SpeechConfig mInstance = null;
    private SharedPreferences mPreferences = null;

    public static SpeechConfig getConfig(Context context) {
        if (mInstance == null) {
            mInstance = new SpeechConfig(context);
        }
        return mInstance;
    }

    private SpeechConfig(Context context) {
        this.mPreferences = context.getSharedPreferences(PREFER_NAME, 0);
    }

    public static long getLong(Context context, String key, long defValue) {
        return getConfig(context).getLong(key, defValue);
    }

    public static void putLong(Context context, String key, long value) {
        getConfig(context).putLong(key, value);
    }

    public static boolean getBoolean(Context context, String key, boolean defValue) {
        return getConfig(context).getBoolean(key, defValue);
    }

    public static void putBoolean(Context context, String key, boolean value) {
        getConfig(context).putBoolean(key, value);
    }

    public static String getString(Context context, String key, String defValue) {
        return getConfig(context).getString(key, defValue);
    }

    public static void putString(Context context, String key, String value) {
        getConfig(context).putString(key, value);
    }

    public void putString(String key, String value) {
        SharedPreferences.Editor localEditor = this.mPreferences.edit();
        localEditor.putString(key, value);
        localEditor.commit();
    }

    public String getString(String key, String defValue) {
        return this.mPreferences.getString(key, defValue);
    }

    public void putBoolean(String key, boolean value) {
        SharedPreferences.Editor localEditor = this.mPreferences.edit();
        localEditor.putBoolean(key, value);
        localEditor.commit();
    }

    public boolean getBoolean(String key, boolean defValue) {
        return this.mPreferences.getBoolean(key, defValue);
    }

    public void putLong(String key, long value) {
        SharedPreferences.Editor localEditor = this.mPreferences.edit();
        localEditor.putLong(key, value);
        localEditor.commit();
    }

    public long getLong(String key, long defValue) {
        return this.mPreferences.getLong(key, defValue);
    }
}
