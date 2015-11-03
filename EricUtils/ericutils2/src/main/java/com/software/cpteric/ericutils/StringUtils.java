/*
 * Copyright (c) 2015.  made by CptEric.The code, comments and names are under the Creative Commons liscence.
 */

package com.software.cpteric.ericutils;

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
}
