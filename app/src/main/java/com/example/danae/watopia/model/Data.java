package com.example.danae.watopia.model;


import android.support.annotation.NonNull;

public class Data implements Comparable {
    public final int x;
    public final double y;
    /**
     * constructor for Data
     */
    public Data(int px, double py) {
        x = px;
        y = py;
    }
    /**
     *@return the number indicating which object is greater.
     */
    @Override
    public int compareTo(@NonNull Object o) {
        Data d = (Data) o;
        return x - d.x;

    }
}
