package com.example.danae.watopia;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;

import com.example.danae.watopia.model.QualityReport;



public class ReportDataBase implements DataSource {
    private SQLiteDatabase database;
    private final ReportDbHelper helper;
    public ReportDataBase(Context context) {
        helper = new ReportDbHelper(context);
        open();
    }
// --Commented out by Inspection START (4/11/2017 1:41 AM):
//    public ReportDataBase() {
//        open();
//    }
// --Commented out by Inspection STOP (4/11/2017 1:41 AM)
    private void open() throws SQLException{
        database = helper.getWritableDatabase();
    }
// --Commented out by Inspection START (4/11/2017 1:41 AM):
//    public void close() {
//        helper.close();
//    }
// --Commented out by Inspection STOP (4/11/2017 1:41 AM)
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



    public QualityReport findReportByName(String name) {
        return WaterReportDAO.findByName(database, name);
    }

}
