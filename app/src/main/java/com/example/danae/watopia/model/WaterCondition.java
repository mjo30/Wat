package com.example.danae.watopia.model;

/**
 * Created by danae on 2/27/2017.
 */
/**
 * enum to represent various water conditions.
 */
public enum WaterCondition {
    WASTE("Waste"),
    TRETABLECLEAR("Treatable-Clear"),
    TREATABLEMUDDY("Treatable-Muddy"),
    PORTABLE("Portable");
    private String waterCondition;
    WaterCondition(String waterCondition) {this.waterCondition = waterCondition;}
    public String toString() {return "" + waterCondition;}
}
