package com.jobportal.jobseeker.seeker.Global;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;


public class PrefConnect {
    public static final String PREF_NAME = "MY_PREF";
    public static final int MODE = Context.MODE_PRIVATE;


    public static final String USERID = "userid";
    public static final String USERNAME = "username";
    public static final String USEREMAIL = "usermail";
    public static final String USERADDRESS = "useraddress";
    public static final String USERMOBILENO = "userMobilNo";
    public static final String USERIMAGE = "userimage";
    public static final String USERIMAGENAME = "userimagename";







    public static void clearAllPrefs(Context context) {
        getEditor(context).clear().commit();
    }

    /**
     * @param context
     * @param key
     * @param value
     */
    public static void writeBoolean(Context context, String key, boolean value) {
        getEditor(context).putBoolean(key, value).commit();
    }

    /**
     * @param context
     * @param key
     * @param defValue
     * @return
     */
    public static boolean readBoolean(Context context, String key,
                                      boolean defValue) {
        return getPreferences(context).getBoolean(key, defValue);
    }

    /**
     * @param context
     * @param key
     * @param value
     */
    public static void writeInteger(Context context, String key, int value) {
        getEditor(context).putInt(key, value).commit();

    }

    /**
     * @param context
     * @param key
     * @param defValue
     * @return
     */
    public static int readInteger(Context context, String key, int defValue) {
        return getPreferences(context).getInt(key, defValue);
    }


    /**
     * @param context
     * @param key
     * @param value
     */
    public static void writeString(Context context, String key, String value) {
        getEditor(context).putString(key, value).commit();

    }

    /**
     * @param context
     * @param key
     * @param defValue
     * @return
     */
    public static String readString(Context context, String key, String defValue) {
        return getPreferences(context).getString(key, defValue);
    }

    /**
     * @param context
     * @param key
     * @param value
     */
    public static void writeFloat(Context context, String key, float value) {
        getEditor(context).putFloat(key, value).commit();
    }

    /**
     * @param context
     * @param key
     * @param defValue
     * @return
     */
    public static float readFloat(Context context, String key, float defValue) {
        return getPreferences(context).getFloat(key, defValue);
    }

    /**
     * @param context
     * @param key
     * @param value
     */
    public static void writeLong(Context context, String key, long value) {
        getEditor(context).putLong(key, value).commit();
    }

    /**
     * @param context
     * @param key
     * @param defValue
     * @return
     */
    public static long readLong(Context context, String key, long defValue) {
        return getPreferences(context).getLong(key, defValue);
    }

    /**
     * @param context
     * @return
     */
    public static SharedPreferences getPreferences(Context context) {
        return context.getSharedPreferences(PREF_NAME, MODE);
    }

    /**
     * @param context
     * @return
     */
    public static Editor getEditor(Context context) {
        return getPreferences(context).edit();
    }

}
