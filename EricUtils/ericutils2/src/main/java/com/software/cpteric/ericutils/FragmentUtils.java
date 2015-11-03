/*
 * Copyright (c) 2015.  made by CptEric.The code, comments and names are under the Creative Commons license.
 */

package com.software.cpteric.ericutils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;

/**
 * Created by CptEric on 3/11/15.
 */

public class FragmentUtils {
    /**
     *
     * @param id the Layout Id where the fragment will be inserted (Framelayout, for example)
     * @param fragment the Fragment that you will add / replace on the id. it does not have to be of type Fragment, just Extend it and it'll work.
     * @param frgm the support fragment manager of your choice, this library uses support v4 :P
     */
    public static void replaceFragment(int id, Fragment fragment, FragmentManager frgm) {
        try{
            Log.e("FragmentUtils","Beginning fragment transaction");
            FragmentTransaction FT = frgm.beginTransaction();
            FT.replace(id, fragment);
            FT.commit();
            Log.e("FragmentUtils", "Success! fragment replaced!");
        }
        catch (Exception e){
            try{
                Log.e("FragmentUtils", "There was no fragment prior to the request. trying to add the fragment.");
                FragmentTransaction FT = frgm.beginTransaction();
                FT.add(id, fragment);
                FT.addToBackStack(null);
                FT.commit();
                Log.e("FragmentUtils", "Success! fragment added!");
            }
            catch (Exception c) {
                Log.e("FragmentUtils", "Failure. printing exception result:\n"+c.toString());
            }

        }

    }
}
