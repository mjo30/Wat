package com.example.danae.watopia;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;

import com.example.danae.watopia.model.QualityReport;

/**
 * Created by danae on 3/27/2017.
 */

public class ReportDataBase implements DataSource {
    private SQLiteDatabase database;
    private ReportDbHelper helper;
    public ReportDataBase(Context context) {
        helper = new ReportDbHelper(context);
        open();
    }
    public ReportDataBase() {
        open();
    }
    private void open() throws SQLException{
        database = helper.getWritableDatabase();
    }
    public void close() {
        helper.close();
    }
//create(SQLiteDatabase database, String name, String date,String location,String virus, String condition, String contamination) {
    @Override
    public QualityReport createReport(String name, String date, String location, String virus,
                                      String contamination, String waterCondition) {
        return WaterReportDAO.create(database, name, date,
                location, virus, contamination, waterCondition);
    }

    @Override
    public void deleteReport(QualityReport report) {
        WaterReportDAO.delete(database, report);
    }
//    @Override
//    public int count(){
//        return WaterReportDAO.count(database);
//    }
    @Override
    public List<QualityReport> getAllReports() {
        return WaterReportDAO.getAllReports(database);
    }

    @Override
    public void updateReport(QualityReport report) {

    }


    @Override
    public QualityReport findReportByName(String name) {
        return WaterReportDAO.findByName(database, name);
    }

}
