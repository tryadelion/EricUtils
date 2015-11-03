/*
 * Copyright (c) 2015.  made by CptEric.The code, comments and names are under the Creative Commons liscence.
 */

package com.software.cpteric.ericutils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

import java.io.ByteArrayOutputStream;

/**
 * Created by useit on 3/11/15.
 */
public class BitmapUtils {
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
}
