package com.example.danae.watopia.model;

/**
 * Created by danae on 2/27/2017.
 */
/**
 * enum to represent various water types.
 */
public enum WaterType {
    BOTTLED("Bottled"),
    WELL("Well"),
    STREAM("Stream"),
    LAKE("Lake"),
    SPRING("Spring"),
    OTHER("Other");
    private String waterType;
    WaterType(String waterType) {
        this.waterType = waterType;
    }
    public String toString() {return "" + waterType;}
}
