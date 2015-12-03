/*
 * Copyright (c) 2015.  made by CptEric.The code, comments and names are under the Creative Commons liscence.
 */

package com.software.cpteric.ericutils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

import java.io.ByteArrayOutputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by useit on 03/11/15.
 * Updated by Mauker1 on 03/12/15.
 */
public final class BitmapUtils {

    private static final String LOG_TAG = BitmapUtils.class.getCanonicalName();
    
    // Hide this shit.
    private BitmapUtils() { }

    /**
     *
     * @param source the bitmap to be butchered, sliced, killed and packed into an array.
     * @param pieces the total number of resulting pieces you want. 9, 8, 4, 5, 6,100.... the higher, the heavyer the workload required.
     * @return
     */
    public Bitmap[] sliceBitmapIntoPieces(Bitmap source,int pieces){
        Bitmap[] bmp= new Bitmap[pieces];
        pieces = Integer.parseInt(String.valueOf(Math.sqrt(pieces)));
        int k=0;
        int width=source.getWidth();
        int height=source.getHeight();
        for(int i=0;i<pieces;i++){
            for(int j=0;j<pieces;j++){
                bmp[k]= Bitmap.createBitmap(source, (width * j) / pieces, (i * height) / pieces, width / pieces, height / pieces);
            }

        }
        return bmp;
    }

    public static String getBase64FromBitmap(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        return Base64.encodeToString(byteArray, Base64.DEFAULT);
    }

    public static Bitmap getBitmapFromBase64(String base64) {
        byte[] decodedString = Base64.decode(base64, Base64.DEFAULT);
        Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
        return decodedByte;
    }

    public static boolean saveBitmapToFile(File dir, String fileName, Bitmap bm,
                                Bitmap.CompressFormat format, int quality) {

        File imageFile = new File(dir,fileName);

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(imageFile);

            bm.compress(format,quality,fos);

            fos.close();

            return true;
        }
        catch (IOException e) {
            Log.e(LOG_TAG, e.getMessage());
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e1) {
                    Log.e(LOG_TAG, "Couldn't close FileOutputStream!");
                    Log.e(LOG_TAG, e1.getMessage());
                }
            }
        }

        return false;
    }
}
