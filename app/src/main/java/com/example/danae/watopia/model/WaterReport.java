package com.example.danae.watopia.model;


import com.example.danae.watopia.Location;

import java.util.ArrayList;


public class WaterReport {
    private static final ArrayList<WaterReport> reportList = new ArrayList<>();
// --Commented out by Inspection START (4/11/2017 1:41 AM):
// --Commented out by Inspection START (4/11/2017 1:41 AM):
////    public static List<String> types = Arrays.asList("Bottled", "Well", "Steam",
////            "Lake", "Spring", "Other");
//// --Commented out by Inspection STOP (4/11/2017 1:41 AM)
//    public static List<String> conditions = Arrays.asList("Waste", "Treatable-Clear",
//            "Treatable-Muddy", "Potable");
// --Commented out by Inspection STOP (4/11/2017 1:41 AM)
    private long number;
    private Location _location;
    private String latitude;
    private String longitude;
    private String waterCondition;
    private String waterType;
    private String date;
    /**
     * empty constructor for WaterReport object
     */
    public WaterReport(){
    }
// --Commented out by Inspection START (4/11/2017 1:41 AM):
// --Commented out by Inspection START (4/11/2017 1:41 AM):
////    /**
////     * constructor for WaterReport object
////     */
////    public WaterReport(String name, String date, String latitude,
////                       String longitude, String waterCondition, String waterType, long number) {
////        this.date = date;
////        this.name = name;
////        this.latitude = latitude;
////        this.longitude = longitude;
////        this.waterCondition = waterCondition;
////        this.waterType = waterType;
////        this.number = number;
////        _location = new Location(Double.parseDouble(latitude), Double.parseDouble(longitude));
////    }
//// --Commented out by Inspection STOP (4/11/2017 1:41 AM)
//    public List<WaterReport> getReportList() {
//        return reportList;
//    }
// --Commented out by Inspection STOP (4/11/2017 1:41 AM)
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

// --Commented out by Inspection START (4/11/2017 1:42 AM):
//    public Location getLocation() {
//        return _location;
//    }
// --Commented out by Inspection STOP (4/11/2017 1:42 AM)

// --Commented out by Inspection START (4/11/2017 1:42 AM):
//    public void setLocation(Location location) {
//        _location = location;
//    }
// --Commented out by Inspection STOP (4/11/2017 1:42 AM)
    public void setNumber(long number) {this.number = number;}
    public long getNumber() {
        return number;
    }
    // --Commented out by Inspection (4/11/2017 1:42 AM):public String getName() {return name; }
    public void setName(String name) {
//        String name1 = name;
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
// --Commented out by Inspection START (4/11/2017 1:42 AM):
//    /**
//     * retrieves the latitude data of a double and changes it to a string.
//     * @return the latitude string.
//     */
//    public String get_sLat() {
//        Double dLat = _location.getLatitude();
//        return dLat.toString();
//    }
// --Commented out by Inspection STOP (4/11/2017 1:42 AM)
// --Commented out by Inspection START (4/11/2017 1:42 AM):
//    /**
//     * retrieves the longitude data of a double and changes it to a string.
//     * @return the longitude string.
//     */
//    public String get_sLong() {
//
//        Double dLong = _location.getLongitude();
//        return dLong.toString();
//    }
// --Commented out by Inspection STOP (4/11/2017 1:42 AM)

}
