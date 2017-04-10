package com.example.danae.watopia;

import com.example.danae.watopia.model.QualityReport;
import com.example.danae.watopia.model.WaterReport;

import java.util.List;

/**
 * Created by Minky on 2017-04-02.
 */

public interface DataReportSource {
    WaterReport createReport(String name, String date, String latitude, String longitude,
                             String type, String waterCondition);

    void deleteReport(WaterReport report);
    List<WaterReport> getAllReports();
    void updateReport(WaterReport report);
    WaterReport findReportByName(String name);
}
