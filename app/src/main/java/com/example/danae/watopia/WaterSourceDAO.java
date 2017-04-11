package com.example.danae.watopia;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.danae.watopia.model.WaterReport;

import java.util.ArrayList;
import java.util.List;

class WaterSourceDAO  {
        //Database table column names
    private static final String TABLE_NAME = "SourceReport";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_DATE = "date";
    private static final String COLUMN_LATITUDE = "latitude";
    private static final String COLUMN_LONGITUDE = "longitude";
    private static final String COLUMN_TYPE = "water_type";
    private static final String COLUMN_CONDITION = "water_condition";
    private static final String[] allColumns = {WaterSourceDAO.COLUMN_DATE, WaterSourceDAO.COLUMN_ID,
                WaterSourceDAO.COLUMN_NAME, WaterSourceDAO.COLUMN_LATITUDE,
                WaterSourceDAO.COLUMN_LONGITUDE, WaterSourceDAO.COLUMN_TYPE, WaterSourceDAO.COLUMN_CONDITION};
        private static final int ID_NUMBER = 1;
        private static final int NAME_NUMBER = 2;
        private static final int DATE_NUMBER = 0;
        private static final int LATITUDE_NUMBER = 3;
        private static final int LONGITUDE_NUMBER = 4;
        private static final int TYPE_NUMBER = 5;
        private static final int CONDITION_NUMBER = 6;



        // Database creation SQL statement
        private static final String DATABASE_CREATE = "create table "
                + TABLE_NAME
                + "("
                + COLUMN_ID + " integer primary key autoincrement, "
                + COLUMN_NAME + " text not null, "
                + COLUMN_DATE + " text not null, "
                + COLUMN_LATITUDE + " text not null, "
                + COLUMN_LONGITUDE + " text not null, "
                + COLUMN_TYPE + " text not null, "
                + COLUMN_CONDITION + " text not null"
                + ");";
        public static void onCreate(SQLiteDatabase database) {
            database.execSQL(DATABASE_CREATE);
        }

        public static void onUpgrade(SQLiteDatabase database, int oldVersion,
                                     int newVersion) {
            Log.w(WaterSourceDAO.class.getName(), "Upgrading database from version "
                    + oldVersion + " to " + newVersion
                    + ", which will destroy all old data");
            database.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
            onCreate(database);
        }
        public static WaterReport create(SQLiteDatabase database, String name, String date,
                                         String latitude,
                                         String longitude, String type, String condition) {
            ContentValues values = new ContentValues();
            values.put(COLUMN_NAME, name);
            values.put(COLUMN_DATE, date);
            values.put(COLUMN_LATITUDE, latitude);
            values.put(COLUMN_LONGITUDE, longitude);
            values.put(COLUMN_TYPE, type);
            values.put(COLUMN_CONDITION, (condition));
            long insertId = database.insert(TABLE_NAME, null,
                    values);

            Log.d("APP", "Inserted Water Report: " + insertId);

            Cursor cursor = database.query(TABLE_NAME,
                    allColumns, COLUMN_ID + " = " + insertId, null,
                    null, null, null);

            cursor.moveToFirst();

            WaterReport report = cursorToWaterReport(cursor);
            cursor.close();
            return report;
        }
        private static WaterReport cursorToWaterReport(Cursor cursor) {
            WaterReport report = new WaterReport();
            report.setName(cursor.getString(NAME_NUMBER));
            report.setDate(cursor.getString(DATE_NUMBER));
            report.setNumber(cursor.getLong(ID_NUMBER));
            report.setLatitude(cursor.getString(LATITUDE_NUMBER));
             report.setLongitude(cursor.getString(LONGITUDE_NUMBER));
            report.setWaterCondition(cursor.getString(CONDITION_NUMBER));
            report.setWaterType(cursor.getString(TYPE_NUMBER));
            return report;
        }

        public static List<WaterReport> getAllReports(SQLiteDatabase database) {
            List<WaterReport> reports = new ArrayList<>();
            Cursor cursor = database.query(TABLE_NAME,
                    allColumns, null, null, null, null, null);

            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                WaterReport report = cursorToWaterReport(cursor);
                reports.add(report);
                cursor.moveToNext();
            }
            // make sure to close the cursor
            cursor.close();

            Log.d("APP", "All Students: " + reports.toString());

            return reports;
        }

        public static void delete(SQLiteDatabase database, WaterReport report) {
            long id = report.getNumber();
            database.delete(TABLE_NAME, COLUMN_ID + " = " + id, null);
        }

        public static WaterReport findByName(SQLiteDatabase database, String name) {
            String query = "SELECT * FROM " + TABLE_NAME + " WHERE " + COLUMN_NAME + " ='" + name;

            Cursor  cursor = database.rawQuery(query,null);

            WaterReport report = null;

            if (cursor != null) {
                cursor.moveToFirst();

                report = cursorToWaterReport(cursor);

                cursor.close();

            }



            return report;
        }
// --Commented out by Inspection START (4/11/2017 1:40 AM):
//        public static WaterReport findByDate(SQLiteDatabase database, String date) {
//            String query = "SELECT * FROM " + TABLE_NAME + " WHERE " + COLUMN_DATE + " ='" + date;
//            Cursor  cursor = database.rawQuery(query,null);
//            WaterReport report = null;
//
//            if (cursor != null) {
//                cursor.moveToFirst();
//
//                report = cursorToWaterReport(cursor);
//
//                cursor.close();
//
//            }
//
//
//
//            return report;
//        }
// --Commented out by Inspection STOP (4/11/2017 1:40 AM)
//    public static List<WaterReport> getAllByMajor(SQLiteDatabase database, String major) {
//        String query = "SELECT * FROM " + TABLE_NAME + " WHERE " + COLUMN_MAJOR + " ='" + major;
//
//        Cursor  cursor = database.rawQuery(query,null);
//
//        List<Student> students = new ArrayList<>();
//
//        if (cursor != null) {
//            cursor.moveToFirst();
//
//            while (!cursor.isAfterLast()) {
//                Student student = cursorToStudent(cursor);
//                students.add(student);
//                cursor.moveToNext();
//            }
//
//            cursor.close();
//        }
//
//        return students;
//
//    }
    }


