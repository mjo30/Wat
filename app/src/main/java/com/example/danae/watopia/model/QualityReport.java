package com.example.danae.watopia.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QualityReport {
    private static final List<QualityReport> qualityReports = new ArrayList<>();
    public static List<String> conditions = Arrays.asList("Safe", "Treatable", "Unsafe");
    private long number;
    private String location;
    private String waterCondition;
    private String name;
    private String date;
    private double virus;
    private double contamination;
    /**
     * empty constructor of quality report.
     */
    public QualityReport() {
    }
    /*
     * empty constructor for making chart
     */
    public QualityReport(String date, double contamination){}
    /**
     * constructs a QualityReport
     */
    public QualityReport(String date, long number, String name, String location,
                         String waterCondition, double virus, double contamination) {
        this.date = date;
        this.number = number;
        this.name = name;
        this.location = location;
        this.waterCondition = waterCondition;
        this.virus = virus;
        this.contamination = contamination;
    }

    public List<QualityReport> getQualityReports() {
        return qualityReports;
    }
    public String getWaterCondition() {
        return waterCondition;
    }

    public void setWaterCondition(String waterCondition) {
        this.waterCondition = waterCondition;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }
    public int getYear() {
        int year = 0;
        String temp;
        if (date != null) {
            temp = date.substring(0,4);
            year = Integer.parseInt(temp);
            return year;
        }
        return year;
    }
    public String getName() {
        return name;
    }

    public double getVirus() {
        return virus;
    }
    public void setVirus(double virus) {
        this.virus = virus;
    }
    public void setContamination(double contamination) {
        this.contamination = contamination;
    }
    public double getContamination() {
        return contamination;
    }
    public String toString() {
        return " / " + location;
    }


}
