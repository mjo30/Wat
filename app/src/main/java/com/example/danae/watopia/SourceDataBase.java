package com.example.danae.watopia;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.danae.watopia.model.QualityReport;
import com.example.danae.watopia.model.WaterReport;

import java.util.List;

/**
 * Created by Minky on 2017-04-02.
 */

public class SourceDataBase implements DataReportSource {
    private SQLiteDatabase database;
    private SourceDbHelper helper;
    public SourceDataBase(Context context) {
        helper = new SourceDbHelper(context);
        open();
    }
    public SourceDataBase() {
        open();
    }
    private void open() throws SQLException {
        database = helper.getWritableDatabase();
    }
    public void close() {
        helper.close();
    }
    //create(SQLiteDatabase database, String name, String date,String location,String virus, String condition, String contamination) {
    @Override
    public WaterReport createReport(String name, String date, String latitude, String longitude,
                             String type, String waterCondition) {
        return WaterSourceDAO.create(database, name, date,
                latitude, longitude, type, waterCondition);
    }

    @Override
    public void deleteReport(WaterReport report) {
        WaterSourceDAO.delete(database, report);
    }
    //    @Override
//    public int count(){
//        return WaterReportDAO.count(database);
//    }
    @Override
    public List<WaterReport> getAllReports() {
        return WaterSourceDAO.getAllReports(database);
    }

    @Override
    public void updateReport(WaterReport report) {

    }


    @Override
    public WaterReport findReportByName(String name) {
        return WaterSourceDAO.findByName(database, name);
    }

}
