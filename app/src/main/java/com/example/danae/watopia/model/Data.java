package com.example.danae.watopia.model;

/**
 * Created by danae on 3/29/2017.
 */

public class Data implements Comparable {
    public int x;
    public double y;
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
    public int compareTo(Object o) {
        Data d = (Data) o;
        return x - d.x;

    }
}
