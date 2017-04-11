package com.example.danae.watopia.model;


public enum WaterCondition {
    WASTE("Waste"),
    TRETABLECLEAR("Treatable-Clear"),
    TREATABLEMUDDY("Treatable-Muddy"),
    PORTABLE("Portable");
    private final String waterCondition;
    WaterCondition(String waterCondition) {this.waterCondition = waterCondition;}
    public String toString() {return "" + waterCondition;}
}
