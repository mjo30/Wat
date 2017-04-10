package com.example.danae.watopia.model;


import com.example.danae.watopia.Location;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Created by Minky and Eunbin on 2017-03-01.
 */

public class WaterReport {
    public static ArrayList<WaterReport> reportList = new ArrayList<WaterReport>();
    public static List<String> types = Arrays.asList("Bottled", "Well", "Steam",
            "Lake", "Spring", "Other");
    public static List<String> conditions = Arrays.asList("Waste", "Treatable-Clear",
            "Treatable-Muddy", "Potable");
    private long number;
    private Location _location;
    private String latitude;
    private String longitude;
    private String waterCondition;
    private String waterType;
    private String name;
    private String date;
    /**
     * empty constructor for WaterReport object
     */
    public WaterReport(){
    }
    /**
     * constructor for WaterReport object
     */
    public WaterReport(String name, String date, String latitude,
                       String longitude, String waterCondition, String waterType, long number) {
        this.date = date;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.waterCondition = waterCondition;
        this.waterType = waterType;
        this.number = number;
        Location newLocation = new Location(Double.parseDouble(latitude), Double.parseDouble(longitude));
        _location = newLocation;
    }
    public List<WaterReport> getReportList() {
        return reportList;
    }
    /**
     * @return string of water condition
     */
    public String getWaterCondition() {
        return waterCondition;
    }
    /**
     * @return a string of the water report's number and the name
     */
    public String toString() {
        return ") " + date;
    }
    public String getWaterType() {
        return waterType;
    }
    public String getDate() {
        return date;
    }
    public void setWaterCondition(String waterCondition) {
        this.waterCondition = waterCondition;
    }

    public void setWaterType(String waterType) {
        this.waterType = waterType;
    }

    public Location getLocation() {
        return _location;
    }

    public void setLocation(Location location) {
        _location = location;
    }
    public void setNumber(long number) {this.number = number;}
    public long getNumber() {
        return number;
    }
    public String getName() {return name; }
    public void setName(String name) {
        this.name = name;
    }

    public void setDate(String date) {
        this.date = date;
    }
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
    public double getLatitude() { return Double.parseDouble(latitude); }
    public double getLongitude() { return Double.parseDouble(longitude); }
    /**
     * retrieves the latitude data of a double and changes it to a string.
     * @return the latitude string.
     */
    public String get_sLat() {
        Double dLat = _location.getLatitude();
        String sLat = dLat.toString();
        return sLat;
    }
    /**
     * retrieves the longitude data of a double and changes it to a string.
     * @return the longitude string.
     */
    public String get_sLong() {

        Double dLong = _location.getLongitude();
        String sLong = dLong.toString();
        return sLong;
    }

}
