/*
 * Copyright (c) 2015.  made by CptEric.The code, comments and names are under the Creative Commons liscence.
 */

package com.software.cpteric.ericutils;

import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;

/**
 * Created by useit on 3/11/15.
 */
public class MapUtils {
    public static LatLng getMidPoint(LatLng one, LatLng two) {//[(a+c)/2,(b+d)/2]
        double a = one.latitude;
        double b = one.longitude;
        double c = two.latitude;
        double d = two.longitude;
        return new LatLng(((a + c) / 2), ((b + d) / 2));
    }
    public static GoogleMap getMapFrom(FragmentActivity activity,Fragment mapFragment,int mapLayoutResourceId) {
        SupportMapFragment frag = getMapFragment(activity, mapFragment, mapLayoutResourceId);
        if(frag != null) {
            return frag.getMap();
        }
        else {
            return null;
        }
    }
    private static SupportMapFragment getMapFragment(FragmentActivity a,Fragment b,int id) {
        FragmentManager fm = null;

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
            fm = a.getSupportFragmentManager();
        } else {
            fm = b.getChildFragmentManager();
        }
        SupportMapFragment fragment = (SupportMapFragment) fm.findFragmentById(id);
        if (fragment != null) {
            return fragment;
        }
        else {
            return null;
        }
    }
}
