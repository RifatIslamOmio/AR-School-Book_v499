package com.ece.nsu.spring2021.cse499.arschoolbook.utils.sharedPreferences;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * abstract class to be extended by classes for
 * each individual SharedPreference
 */
public abstract class SharedPrefsUtil {

    private String mSharedPreferenceId;
    private Context mContext;

    public SharedPrefsUtil(String mSharedPreferenceId, Context mContext) {
        this.mSharedPreferenceId = mSharedPreferenceId;
        this.mContext = mContext;
    }

    protected SharedPreferences getSharedPreference(){

        return mContext.getSharedPreferences(mSharedPreferenceId, Context.MODE_PRIVATE);
    }

    /**
     * Method to save String data to shared preferences
     * @param key shared preference key
     * @param data string data
     */
    protected void saveStringData(String key, String data) {

        getSharedPreference().edit().putString(key, data).apply();
    }

    protected String getStringData(String key, String defaultValue) {

        return getSharedPreference().getString(key, defaultValue);
    }

    /**
     * Method to save boolean data to shared preferences
     * @param key shared preference key
     * @param data boolean data
     */
    protected void saveBooleanData(String key, boolean data) {

        getSharedPreference().edit().putBoolean(key, data).apply();
    }
    protected boolean getBooleanData(String key, boolean defaultValue) {

        return getSharedPreference().getBoolean(key, defaultValue);
    }

    /**
     * Method contains redundant code for storing String to a
     * SharedPreference String Set
     * @param key shared preference key
     * @param data string data to append
     */
    protected void appendDataToList(String key, String data){

        Set<String> dataSet =
                getSharedPreference().getStringSet(key, new HashSet<>());

        dataSet.add(data);

        getSharedPreference().edit()
                .putStringSet(key, dataSet).apply();
    }

    /**
     * Method contains redundant code for reading list of String
     * from a SharedPreference String Set
     * @param key shared preference key
     */
    protected ArrayList<String> getListOfData(String key){

        Set<String> dataSet =
                getSharedPreference().getStringSet(key, new HashSet<>());

        ArrayList<String> dataList = new ArrayList<>(dataSet.size());

        dataList.addAll(dataSet);

        return dataList;
    }

    /**
     * Method contains redundant code to remove String
     * from a SharedPreference String Set
     * @param key shared preference key
     * @param data string data to remove
     */
    protected void removeDataFromList(String key, String data){

        Set<String> dataSet =
                getSharedPreference().getStringSet(key, new HashSet<>());

        dataSet.remove(data);

        getSharedPreference().edit()
                .putStringSet(key, dataSet).apply();
    }

    /**
     * Method contains redundant code to check if
     * String exists in Sharedpreference
     * @param key key of the shared preference
     * @param data data to be searched
     * @return if data exists or not
     */
    protected boolean doesDataExistInList(String key, String data){

        Set<String> dataSet =
                getSharedPreference().getStringSet(key, new HashSet<>());

        return dataSet.contains(data);
    }

    public String getmSharedPreferenceId() {
        return mSharedPreferenceId;
    }

    public void setmSharedPreferenceId(String mSharedPreferenceId) {
        this.mSharedPreferenceId = mSharedPreferenceId;
    }

    public Context getmContext() {
        return mContext;
    }

    public void setmContext(Context mContext) {
        this.mContext = mContext;
    }
}
