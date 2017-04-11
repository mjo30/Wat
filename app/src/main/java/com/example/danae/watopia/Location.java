package com.example.danae.watopia;



public class Location {

    private final double _latitude;
    private final double _longitude;
    /**
     * public constructor for Location object.
     */
    public Location(double lat, double longit) {
        _latitude = lat;
        _longitude = longit;
    }
    /**
     * This method returns latitude of the location instance
     * @return latitude of the location instance
     */
    public double getLatitude() { return _latitude; }
    
    /**
     * This method returns longitude of the location instance
     * @return longitude of the location instance
     */
    public double getLongitude() { return _longitude; }

}
