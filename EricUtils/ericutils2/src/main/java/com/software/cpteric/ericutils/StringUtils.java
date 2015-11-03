/*
 * Copyright (c) 2015.  made by CptEric.The code, comments and names are under the Creative Commons liscence.
 */

package com.software.cpteric.ericutils;

import android.util.Base64;

/**
 * Created by useit on 3/11/15.
 */
public class StringUtils {
    public static boolean isValid(String text) {
        if(text == null){
            return false;
        }
        if(text != null && text.equalsIgnoreCase("")){
            return true;
        }
        return false;
    }

    public static String getBase64FromString(String string) {
        return Base64.encodeToString(string.getBytes(), Base64.DEFAULT);
    }

    public static String getStringFromBase64(String base64) {
        byte[] str = Base64.decode(base64, Base64.DEFAULT);
        return str.toString();
    }
}
