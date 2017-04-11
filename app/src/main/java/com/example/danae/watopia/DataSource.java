package com.example.danae.watopia;

import com.example.danae.watopia.model.QualityReport;

import java.util.List;


interface DataSource {
    QualityReport createReport(String name, String date, String location, String virus,
                               String contamination, String waterCondition);

    void deleteReport(QualityReport report);
    List<QualityReport> getAllReports();

    // --Commented out by Inspection (4/11/2017 1:36 AM):QualityReport findReportByName(String name);

}
