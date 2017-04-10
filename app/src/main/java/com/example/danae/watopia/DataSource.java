package com.example.danae.watopia;

import com.example.danae.watopia.model.QualityReport;

import java.util.List;

/**
 * Created by EunBin on 2017-03-27.
 */

public interface DataSource {
    QualityReport createReport(String name, String date, String location, String virus,
                               String contamination, String waterCondition);

    void deleteReport(QualityReport report);
    List<QualityReport> getAllReports();
    void updateReport(QualityReport report);
    QualityReport findReportByName(String name);

}
