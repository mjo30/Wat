package com.example.danae.watopia.model;

public enum WaterType {
    BOTTLED("Bottled"),
    WELL("Well"),
    STREAM("Stream"),
    LAKE("Lake"),
    SPRING("Spring"),
    OTHER("Other");
    private final String waterType;
    WaterType(String waterType) {
        this.waterType = waterType;
    }
    public String toString() {return "" + waterType;}
}
