/*
 * Copyright (c) 2015.  made by CptEric.The code, comments and names are under the Creative Commons liscence.
 */

package com.software.cpteric.ericutils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by useit on 3/11/15.
 * * Updated by CptEric on 07/01/16.
 */
public class NetworkUtils {
    private static ConnectivityManager connectivity;
    public static boolean isNetworkAvailable(Context context) {
        connectivity = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity == null) {

        } else {
            NetworkInfo[] info = connectivity.getAllNetworkInfo();
            if (info != null) {
                for (int i = 0; i < info.length; i++) {
                    if (info[i].getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * This method checks if your current network type should be fast or not.
     * <p>
     * For more information, check: http://developer.android.com/reference/android/telephony/TelephonyManager.html
     * @param context 
     * @return true if the current connection is high speed (3G,4G or WiFi). False otherwise.
     */
    public static boolean isHighSpeedConnection(Context context) {
        NetworkInfo info = connectivity.getActiveNetworkInfo();
        int type = info.getType();
        int subType = info.getSubtype();

        if(type==ConnectivityManager.TYPE_WIFI){
            return true; // Assume WiFi is fast.
        }
        else if(type==ConnectivityManager.TYPE_MOBILE){
            switch(subType){
            case TelephonyManager.NETWORK_TYPE_1xRTT:
            case TelephonyManager.NETWORK_TYPE_CDMA:
                return false; // 50-100 kbps super slow.
            case TelephonyManager.NETWORK_TYPE_EDGE:
            case TelephonyManager.NETWORK_TYPE_GPRS:
                return false; // 50-100 kbps 2G network, also slow.
            case TelephonyManager.NETWORK_TYPE_HSDPA:
            case TelephonyManager.NETWORK_TYPE_HSPA:
            case TelephonyManager.NETWORK_TYPE_HSUPA:
            case TelephonyManager.NETWORK_TYPE_UMTS:
            case TelephonyManager.NETWORK_TYPE_HSPAP: // API level 13
                return true; // 2-14 Mbps 3G network, fast.
            case TelephonyManager.NETWORK_TYPE_LTE: // API level 11
                return true; // 10+ Mbps 4G!
            // Unknown
            case TelephonyManager.NETWORK_TYPE_UNKNOWN:
            default:
                return false;
            }
        }
        else{
            return false;
        }
    }

    /**
     *
     * @param context describes the context of the execution.
     * @param searchFirst if true, it will force a scan, else, it will use the current device scan.
     * @return the list of SSID's in the network.
     */
    public static List<String> getWifiSSIDs(Context context,Boolean searchFirst){
        WifiManager mgr = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        List<ScanResult> results;
        List<String> returnValues = new ArrayList<>();
        if(searchFirst){
            mgr.startScan();
            results = mgr.getScanResults();
        }else{
            results = mgr.getScanResults();
        }
        for(ScanResult r : results){
            returnValues.add(r.SSID);
        }
        return returnValues;
    }
}
