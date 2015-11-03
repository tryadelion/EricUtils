/*
 * Copyright (c) 2015.  made by CptEric.The code, comments and names are under the Creative Commons liscence.
 */

package com.software.cpteric.ericutils;

import android.graphics.Bitmap;

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
    public Bitmap[] SliceBitmapIntoPieces(Bitmap source,int pieces){
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
}
