package com.coding.collegeproject.bankwork;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SqliteDatabase extends SQLiteOpenHelper {
    private	static final int DATABASE_VERSION =	5;
    private	static final String	DATABASE_NAME = "crypto";
    private	static final String TABLE_CRYPTO = "crypto";

    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_NAME = "cryptoname";
    private static final String COLUMN_BS = "Buyprice";
    private static final String COLUMN_SS="Sellprice";
    public SqliteDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String	CREATE_CRYPTO_TABLE = "CREATE	TABLE " + TABLE_CRYPTO + "(" + COLUMN_ID + " INTEGER PRIMARY KEY," + COLUMN_NAME + " TEXT," + COLUMN_BS + " INTEGER," + COLUMN_SS+" INTEGER "+")";
        db.execSQL(CREATE_CRYPTO_TABLE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CRYPTO);
        onCreate(db);
    }
}
