package com.example.danae.watopia;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.danae.watopia.model.QualityReport;

import java.util.ArrayList;
import java.util.List;


// This is a database written with sqlite.
class WaterReportDAO {
    //Database table column names
    private static final String TABLE_NAME = "WaterReport";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_DATE = "date";
    private static final String COLUMN_LOCATION = "location";
//    public static final String COLUMN_LATITUDE = "latitude";
//    public static final String COLUMN_LONGITUDE = "longitude";
    //public static final String COLUMN_TYPE = "water type";
    private static final String COLUMN_CONDITION = "water_condition";
    private static final String COLUMN_VIRUS = "water_virus";
    private static final String COLUMN_CONTAMINATION = "water_contamination";
    private static final String[] allColumns = {WaterReportDAO.COLUMN_DATE, WaterReportDAO.COLUMN_ID,
            WaterReportDAO.COLUMN_NAME, WaterReportDAO.COLUMN_LOCATION,
             WaterReportDAO.COLUMN_CONDITION, WaterReportDAO.COLUMN_VIRUS, WaterReportDAO.COLUMN_CONTAMINATION};
    private static final int ID_NUMBER = 1;
    private static final int NAME_NUMBER = 2;
    private static final int DATE_NUMBER = 0;
    private static final int LOCATION_NUMBER = 3;
    //private static final int LONGITUDE_NUMBER = 4;
    private static final int VIRUS_NUMBER = 5;
    private static final int CONDITION_NUMBER = 4;
    private static final int CONTAMINATION_NUMBER = 6;


    // Database creation SQL statement
    private static final String DATABASE_CREATE = "create table "
            + TABLE_NAME
            + "("
            + COLUMN_ID + " integer primary key autoincrement, "
            + COLUMN_NAME + " text not null, "
            + COLUMN_DATE + " text not null, "
            + COLUMN_LOCATION + " text not null, "
            + COLUMN_CONDITION + " text not null, "
            + COLUMN_VIRUS + " text not null, "
            + COLUMN_CONTAMINATION + " text not null"
            + ");";
    public static void onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE);
    }
    
    public static void onUpgrade(SQLiteDatabase database, int oldVersion,
                                 int newVersion) {
        Log.w(WaterReportDAO.class.getName(), "Upgrading database from version "
                + oldVersion + " to " + newVersion
                + ", which will destroy all old data");
        database.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(database
                );
    }
    
    // retrieves data from qualityReport page and adds report to the database
    public static QualityReport create(SQLiteDatabase database, String name, String date,
                                       String location,
                                       String virus, String contamination, String condition) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, name);
        values.put(COLUMN_DATE, date);
        values.put(COLUMN_LOCATION, location);
        values.put(COLUMN_CONDITION, (condition));
        values.put(COLUMN_CONTAMINATION, Double.parseDouble(contamination));
        values.put(COLUMN_VIRUS, Double.parseDouble(virus));
        long insertId = database.insert(TABLE_NAME, null,
                values);

        Log.d("APP", "Inserted Water Report: " + insertId);

        Cursor cursor = database.query(TABLE_NAME,
                allColumns, COLUMN_ID + " = " + insertId, null,
                null, null, null);

        cursor.moveToFirst();

        QualityReport report = cursorToWaterReport(cursor);
        cursor.close();
        return report;
    }
    
    // moves cursor to quality report that enables user to view report that he / she selected
    private static QualityReport cursorToWaterReport(Cursor cursor) {
        QualityReport report = new QualityReport();
        report.setName(cursor.getString(NAME_NUMBER));
        report.setDate(cursor.getString(DATE_NUMBER));
        report.setNumber(cursor.getLong(ID_NUMBER));
//        report.setLatitude(cursor.getString(LATITUDE_NUMBER));
//        report.setLongitude(cursor.getString(LONGITUDE_NUMBER));
        report.setLocation(cursor.getString(LOCATION_NUMBER));
        report.setContamination(cursor.getDouble(CONTAMINATION_NUMBER));
        report.setWaterCondition(cursor.getString(CONDITION_NUMBER));
        report.setVirus(cursor.getDouble(VIRUS_NUMBER));
        return report;
    }
    
    // gets all the report from the database to create a list of reports
    public static List<QualityReport> getAllReports(SQLiteDatabase database) {
        List<QualityReport> reports = new ArrayList<>();
        Cursor cursor = database.query(TABLE_NAME,
                allColumns, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            QualityReport report = cursorToWaterReport(cursor);
            reports.add(report);
            cursor.moveToNext();
        }
        // make sure to close the cursor
        cursor.close();

        Log.d("APP", "All Students: " + reports.toString());

        return reports;
    }
    
    // deletes a report from database
    public static void delete(SQLiteDatabase database, QualityReport report) {
        long id = report.getNumber();
        database.delete(TABLE_NAME, COLUMN_ID + " = " + id, null);
    }
    
    // enables user to find quality report by name
    public static QualityReport findByName(SQLiteDatabase database, String name) {
        String query = "SELECT * FROM " + TABLE_NAME + " WHERE " + COLUMN_NAME + " ='" + name;

        Cursor  cursor = database.rawQuery(query,null);

        QualityReport report = null;

        if (cursor != null) {
            cursor.moveToFirst();

            report = cursorToWaterReport(cursor);

            cursor.close();

        }



        return report;
    }

// --Commented out by Inspection START (4/11/2017 1:42 AM):
//    /**
//     * finds the report by date
//     * @param database database of the report
//     * @param date date of the report published
//     * @return quality report that one was searching
//     */
//    public static QualityReport findByDate(SQLiteDatabase database, String date) {
//        String query = "SELECT * FROM " + TABLE_NAME + " WHERE " + COLUMN_DATE + " ='" + date;
//        Cursor  cursor = database.rawQuery(query,null);
//        QualityReport report = null;
//
//        if (cursor != null) {
//            cursor.moveToFirst();
//
//            report = cursorToWaterReport(cursor);
//
//            cursor.close();
//
//        }
//
//
//
//        return report;
//    }
// --Commented out by Inspection STOP (4/11/2017 1:42 AM)
}
