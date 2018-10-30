package com.example.aps.listacompras;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static String DATABASE_NAME = "compras";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE = "products";
    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String QTY = "quantity";
    private static final String VALUE = "value";

    private static final String CREATE_TABLE = "CREATE TABLE "
            + TABLE + "(" + ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + NAME + " TEXT, "
            + QTY + " INT, "
            + VALUE +"  );";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

        Log.d("table", CREATE_TABLE);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS '" + TABLE + "'");
        onCreate(db);
    }

    public long addStudentDetail(String student) {
        SQLiteDatabase db = this.getWritableDatabase();
        // Creating content values
        ContentValues values = new ContentValues();
        values.put(ID, student);
        // insert row in students table
        long insert = db.insert(TABLE, null, values);

        return insert;
    }

    public ArrayList<String> getProducstsList() {
        ArrayList<String> studentsArrayList = new ArrayList<String>();
        String name="";
        String selectQuery = "SELECT  * FROM " + TABLE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                name = c.getString(c.getColumnIndex(ID));
                // adding to Students list
                studentsArrayList.add(name);
            } while (c.moveToNext());
            Log.d("array", studentsArrayList.toString());
        }
        return studentsArrayList;
    }
}