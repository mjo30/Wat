package com.example.danae.watopia;

/**
 * Created by Soyeon on 3/12/2017.
 */

public class Location {

    private double _latitude;
    private double _longitude;
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
