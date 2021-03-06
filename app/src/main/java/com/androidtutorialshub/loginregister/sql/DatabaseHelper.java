package com.androidtutorialshub.loginregister.sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.androidtutorialshub.loginregister.model.User;
import com.androidtutorialshub.loginregister.model.Userdetails;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "UserManager.db";

    // User table name
    private static final String TABLE_USER = "user";
    private static final String TABLE_Userdetails = "userdetails";


    // User Table Columns names
    private static final String COLUMN_USER_ID = "user_id";
    private static final String COLUMN_USER_NAME = "user_name";
    private static final String COLUMN_USER_EMAIL = "user_email";
    private static final String COLUMN_USER_PASSWORD = "user_password";
    private static final String COLUMN_USER_FLATNO = "user_flatno";
    private static final String COLUMN_USER_ADDRESS = "user_address";

    // User Table_Userdisplay Columns names
    private static final String COLUMN_UD_ID = "ud_id";
    public static final String COLUMN_Username = "udname";
    public static final String COLUMN_UD_EMAIL = "email";
    public static final String COLUMN_FlatNumber = "flatnumber";
    public static final String COLUMN_bill_ep1 = "ep1_bill";
    public static final String COLUMN_bill_ep2 = "ep2_bill";
    public static final String COLUMN_bill_ep3 = "ep3_bill";
    public static final String COLUMN_bill_flat = "flat_bill";
    public static final String COLUMN_usage_ep1 = "ep1_usage";
    public static final String COLUMN_usage_ep2 = "ep2_usage";
    public static final String COLUMN_usage_ep3 = "ep3_usage";
    public static final String COLUMN_usage_flat = "flat_usage";



    // create table sql query
    private String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_USER + "("
            + COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_USER_NAME + " TEXT,"
            + COLUMN_USER_EMAIL + " TEXT," + COLUMN_USER_PASSWORD + " TEXT," + COLUMN_USER_FLATNO + " TEXT," + COLUMN_USER_ADDRESS + " TEXT);";


    private String CREATE_Userdetails_TABLE = "CREATE TABLE " + TABLE_Userdetails + "("
            + COLUMN_UD_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_Username + " TEXT,"
            + COLUMN_UD_EMAIL + " TEXT,"
            + COLUMN_FlatNumber + " TEXT,"
            + COLUMN_bill_ep1 + " INTEGER,"
            + COLUMN_bill_ep2 + " INTEGER,"
            + COLUMN_bill_ep3 + " INTEGER,"
            + COLUMN_bill_flat + " INTEGER,"
            + COLUMN_usage_ep1 + " INTEGER,"
            + COLUMN_usage_ep2 + " INTEGER,"
            + COLUMN_usage_ep3 + " INTEGER,"
            + COLUMN_usage_flat + " INTEGER);";

    // drop table sql query
    private String DROP_USER_TABLE = "DROP TABLE IF EXISTS " + TABLE_USER;


    /**
     * Constructor
     * 
     * @param context
     */
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USER_TABLE);
        db.execSQL(CREATE_Userdetails_TABLE);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        //Drop User Table if exist
        db.execSQL(DROP_USER_TABLE);


        // Create tables again
        onCreate(db);

    }

    /**
     * This method is to create user record
     *
     * @param user
     */
    public void addUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_USER_NAME, user.getName());
        values.put(COLUMN_USER_EMAIL, user.getEmail());
        values.put(COLUMN_USER_PASSWORD, user.getPassword());
        values.put(COLUMN_USER_FLATNO, user.getFlatno());
        values.put(COLUMN_USER_ADDRESS, user.getAddress());

        // Inserting Row
        db.insert(TABLE_USER, null, values);
        db.close();
    }


    public void addUserdetails(Userdetails userdetails) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_Username,"Sanki");
        values.put(COLUMN_UD_EMAIL, "sankeerthana.mv@gmail.com");
        values.put(COLUMN_FlatNumber, "204");
        values.put(COLUMN_bill_ep1, 10);
        values.put(COLUMN_bill_ep2, 20);
        values.put(COLUMN_bill_ep3, 30);
        values.put(COLUMN_bill_flat,80);
        values.put(COLUMN_usage_ep1, 40);
        values.put(COLUMN_usage_ep2, 50);
        values.put(COLUMN_usage_ep3, 60);
        values.put(COLUMN_usage_flat, 70);

        // Inserting Row
        db.insert(TABLE_Userdetails, null, values);
        db.close();
    }

    /**
     * This method is to fetch all user and return the list of user records
     *
     * @return list
     */
    public List<User> getAllUser() {
        // array of columns to fetch
        String[] columns = {
                COLUMN_USER_ID,
                COLUMN_USER_EMAIL,
                COLUMN_USER_NAME,
                COLUMN_USER_PASSWORD,
                COLUMN_USER_FLATNO,
                COLUMN_USER_ADDRESS

        };



        // sorting orders
        String sortOrder =
                COLUMN_USER_NAME + " ASC";
        List<User> userList = new ArrayList<User>();

        SQLiteDatabase db = this.getReadableDatabase();


        // query the user table
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id,user_name,user_email,user_password FROM user ORDER BY user_name;
         */
        Cursor cursor = db.query(TABLE_USER, //Table to query
                columns,    //columns to return
                null,        //columns for the WHERE clause
                null,        //The values for the WHERE clause
                null,       //group the rows
                null,       //filter by row groups
                sortOrder); //The sort order


        // Traversing through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                User user = new User();
                user.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(COLUMN_USER_ID))));
                user.setName(cursor.getString(cursor.getColumnIndex(COLUMN_USER_NAME)));
                user.setEmail(cursor.getString(cursor.getColumnIndex(COLUMN_USER_EMAIL)));
                user.setPassword(cursor.getString(cursor.getColumnIndex(COLUMN_USER_PASSWORD)));
                user.setFlatno(cursor.getString(cursor.getColumnIndex(COLUMN_USER_FLATNO)));
                user.setAddress(cursor.getString(cursor.getColumnIndex(COLUMN_USER_ADDRESS)));
                // Adding user record to list
                userList.add(user);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        // return user list
        return userList;
    }

    /**
     * This method to update user record
     *
     * @param user
     */
    public void updateUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_USER_NAME, user.getName());
        values.put(COLUMN_USER_EMAIL, user.getEmail());
        values.put(COLUMN_USER_PASSWORD, user.getPassword());
        values.put(COLUMN_USER_FLATNO, user.getFlatno());
        values.put(COLUMN_USER_ADDRESS, user.getAddress());

        // updating row
        db.update(TABLE_USER, values, COLUMN_USER_ID + " = ?",
                new String[]{String.valueOf(user.getId())});
        db.close();
    }

    /**
     * This method is to delete user record
     *
     * @param user
     */
    public void deleteUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        // delete user record by id
        db.delete(TABLE_USER, COLUMN_USER_ID + " = ?",
                new String[]{String.valueOf(user.getId())});
        db.close();
    }

    /**
     * This method to check user exist or not
     *
     * @param email
     * @return true/false
     */
    public boolean checkUser(String email) {

        // array of columns to fetch
        String[] columns = {
                COLUMN_USER_ID
        };
        SQLiteDatabase db = this.getReadableDatabase();

        // selection criteria
        String selection = COLUMN_USER_EMAIL + " = ?";

        // selection argument
        String[] selectionArgs = {email};

        // query user table with condition
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id FROM user WHERE user_email = 'jack@androidtutorialshub.com';
         */
        Cursor cursor = db.query(TABLE_USER, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                      //filter by row groups
                null);                      //The sort order
        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();

        if (cursorCount > 0) {
            return true;
        }

        return false;
    }

    /**
     * This method to check user exist or not
     *
     * @param email
     * @param password
     * @return true/false
     */
    public boolean checkUser(String email, String password) {

        // array of columns to fetch
        String[] columns = {
                COLUMN_USER_ID
        };
        SQLiteDatabase db = this.getReadableDatabase();
        // selection criteria
        String selection = COLUMN_USER_EMAIL + " = ?" + " AND " + COLUMN_USER_PASSWORD + " = ?";

        // selection arguments
        String[] selectionArgs = {email, password};

        // query user table with conditions
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id FROM user WHERE user_email = 'jack@androidtutorialshub.com' AND user_password = 'qwerty';
         */
        Cursor cursor = db.query(TABLE_USER, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                       //filter by row groups
                null);                      //The sort order

        int cursorCount = cursor.getCount();

        cursor.close();
        db.close();
        if (cursorCount > 0) {
            return true;
        }

        return false;
    }
}
