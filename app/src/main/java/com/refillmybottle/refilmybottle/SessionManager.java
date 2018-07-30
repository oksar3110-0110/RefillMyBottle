package com.refillmybottle.refilmybottle;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by abah on 19/07/18.
 */

public class SessionManager {

    public static final String SESSION_REFILL = "sessionREFILL";
    public static final String SESSION_EMAIL = "sessionEMAIL";
    public static final String SESSION_NMDP = "sessionNMDP";
    public static final String SESSION_NMBK = "sessionNMBK";
    public static final String SESSION_PHOTO = "sessionFOTO";
    public static final String SESSION_DOB = "sessionDOB";
    public static final String SESSION_COUNTRY = "sessionCOUNTRY";
    public static final String SESSION_REGION = "sessionREGION";
    public static final String SESSION_CITY = "sessionCITY";
    public static final String SESSION_STREET = "sessionSTREET";
    public static final String SESSION_UPLOAD_IMAGE_REG = "sessionIMAGE_REG";
    public static final String SESSION_STATUS = "sessionSTATUS";

    SharedPreferences session;
    SharedPreferences.Editor sessionEditor;

    public SessionManager(Context context){
        session = context.getSharedPreferences(SESSION_REFILL, Context.MODE_PRIVATE);
        sessionEditor = session.edit();
    }

    public void saveSessionStr(String keySP, String value){
        sessionEditor.putString(keySP, value);
        sessionEditor.commit();
    }
    public void saveSessionInt(String keySp, int value){
        sessionEditor.putInt(keySp, value);
        sessionEditor.commit();
    }
    public void saveSessionBoolean(String keySp, boolean value){
        sessionEditor.putBoolean(keySp, value);
        sessionEditor.commit();
    }

    public String getSessionNmbk() {
        return session.getString(SESSION_NMBK, "");
    }

    public String getSessionNmdp(){
        return session.getString(SESSION_NMDP, "");
    }

    public String getSessionEmail() {
        return session.getString(SESSION_EMAIL, "");
    }

    public String getSessionPhoto(){
        return session.getString(SESSION_PHOTO, "");
    }

    public String getSessionDob(){
        return session.getString(SESSION_DOB, "");
    }

    public String getSessionCountry(){
        return session.getString(SESSION_COUNTRY, "");
    }

    public String getSessionRegion(){
        return session.getString(SESSION_REGION, "");
    }

    public String getSessionCity(){
        return session.getString(SESSION_CITY, "");
    }

    public String getSessionStreet(){
        return session.getString(SESSION_STREET, "");
    }

    public boolean getSessionStatus(){
        return session.getBoolean(SESSION_STATUS, false);
    }

    public String getSessionUploadImageReg() {
        return session.getString(SESSION_UPLOAD_IMAGE_REG, "");
    }
}
