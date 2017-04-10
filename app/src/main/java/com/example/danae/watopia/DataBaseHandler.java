package com.example.danae.watopia;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.danae.watopia.model.RegisteredUsers;
/**
 * Created by Minky on 2017-02-22.
 */

public class DataBaseHandler extends SQLiteOpenHelper{

    public DataBaseHandler(Context context, Object name, Object factory, int version) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    String password;
    private SQLiteDatabase db;
    private static final int DATABASE_VERSION = 1;
    private static String DATABASE_NAME = "login.db";
    private static final String TABLE_REGISTER = "register";
    public static final String KEY_ID = "ID";
    public static final String KEY_NAME = "name";
    public static final String KEY_PASSWORD = "password";
    public static final String KEY_STANDING = "standing";
    public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_REGISTER + " (" + KEY_ID + " TEXT, " + KEY_NAME + " TEXT, " + KEY_PASSWORD + " TEXT, " + KEY_STANDING + ")";
    /**
     * Creates the table to store user data
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }
    /**
     * Called when the database needs to be upgraded.
     * allows dropping and addition of tables.
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_REGISTER);

        onCreate(db);
    }
    /**
     * Creates a register to store various user data
     */
    void addRegister(RegisteredUsers user) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_ID, user.getEmail());
        values.put(KEY_NAME, user.getName());
        values.put(KEY_PASSWORD, user.getPassword());
        values.put(KEY_STANDING, user.getStanding().toString());

        db.insert(TABLE_REGISTER, null, values);
        db.close();
    }
    /**
     * Deletes a user entry from the table when given the username as a parameter.
     */
    void deleteEntry(String username) {
        db.delete(TABLE_REGISTER, KEY_ID + " = " + username, null);
    }
    /**
     * returns the name of the user when given the username as a parameter.
     * @return name
     */
    String getName(String username) {
        String name = "";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_REGISTER, null, "ID = ?", new String[]{username}, null,null,null);
        if (cursor.getCount() >= 1 && cursor.moveToFirst()) {
            name = cursor.getString(cursor.getColumnIndex(KEY_NAME));
        }
        return name;
    }
    /**
     * returns the standing(user type) of the user when given the username as a parameter.
     * @return standing
     */
    String getKeyStanding(String username) {
        String standing = "";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_REGISTER, null, "ID = ?", new String[]{username},null,null,null);
        if (cursor.getCount() >= 1 && cursor.moveToFirst()) {
            standing = cursor.getString(cursor.getColumnIndex(KEY_STANDING));
        }
        return standing;
    }
    /**
     * returns the password of the user when given the username as a parameter.
     */
    String getRegister(String username) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_REGISTER, null, "ID = ?", new String[]{username},null,null,null);

        if (cursor.getCount() < 1) {
            cursor.close();
            return "NOT EXIST";
        } else if (cursor.getCount() >= 1 && cursor.moveToFirst()) {
            password = cursor.getString(cursor.getColumnIndex(KEY_PASSWORD));
            cursor.close();
        }
        return password;
    }
    /**
     * returns the name of the database.
     * @return String
     */
    public String getDataBaseName() {
        return DATABASE_NAME;
    }
    /**
     * returns the KeyID.
     * @return KEY_ID
     */
    public static String getKeyId() {
        return KEY_ID;
    }
    /**
     * returns the table registers in a string format.
     * @return TABLE_REGISTER
     */
    public static String getTableContacts() {
        return TABLE_REGISTER;
    }
    /**
     * returns the database's version.
     * @return DATABASE_VERSION
     */
    public static int getDatabaseVersion() {
        return DATABASE_VERSION;
    }
}
