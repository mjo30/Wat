package com.example.danae.watopia;

import com.example.danae.watopia.model.WaterReport;

import java.util.List;


interface DataReportSource {
    WaterReport createReport(String name, String date, String latitude, String longitude,
                             String type, String waterCondition);

    void deleteReport(WaterReport report);
    List<WaterReport> getAllReports();

    // --Commented out by Inspection (4/11/2017 1:36 AM):WaterReport findReportByName(String name);
}
