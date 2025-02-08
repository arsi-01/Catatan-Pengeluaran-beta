package com.jovanovic.stefan.sqlitetutorial;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;
import androidx.annotation.Nullable;

class MyDatabaseHelper extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "Catatan.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "Pengeluaran";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_PENGELUARAN = "barang_jasa";
    private static final String COLUMN_DESKRIPSI = "deskripsi";
    private static final String COLUMN_HARGA = "harga";

    MyDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME +
                " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_PENGELUARAN + " TEXT, " +
                COLUMN_DESKRIPSI + " TEXT, " +
                COLUMN_HARGA + " INTEGER);";

        try{
            db.execSQL(query);
        }catch(SQLException e){
            Log.e("SQLiteException", "Error creating table: "+ e.getMessage());
            Toast.makeText(context, "Failed to create table: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        try{
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        }catch(SQLException e){
            Log.e("SQLiteException", "Error upgrading table: "+ e.getMessage());
            Toast.makeText(context, "Failed to upgrade table: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        onCreate(db);
    }

    void addExpense(String barangJasa, String deskripsi, int harga){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_PENGELUARAN, barangJasa);
        cv.put(COLUMN_DESKRIPSI, deskripsi);
        cv.put(COLUMN_HARGA, harga);
        long result = db.insert(TABLE_NAME, null, cv);
        if(result == -1){
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Added Successfully!", Toast.LENGTH_SHORT).show();
        }
    }

    Cursor readAllData(){
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

    void updateData(String row_id, String barangJasa, String deskripsi, String harga){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_PENGELUARAN, barangJasa);
        cv.put(COLUMN_DESKRIPSI, deskripsi);
        cv.put(COLUMN_HARGA, harga);

        long result = db.update(TABLE_NAME, cv, "_id=?", new String[]{row_id});
        if(result == -1){
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Updated Successfully!", Toast.LENGTH_SHORT).show();
        }
    }

    void deleteOneRow(String row_id){
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(TABLE_NAME, "_id=?", new String[]{row_id});
        if(result == -1){
            Toast.makeText(context, "Failed to Delete.", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Successfully Deleted.", Toast.LENGTH_SHORT).show();
        }
    }

    void deleteAllData(){
        SQLiteDatabase db = this.getWritableDatabase();

        try{
            db.execSQL("DELETE FROM " + TABLE_NAME);
            db.execSQL("DELETE FROM sqlite_sequence WHERE name = '" + TABLE_NAME + "'");
        }catch(SQLException e){
            Log.e("SQLiteException", "Error deleting table: "+ e.getMessage());
            Toast.makeText(context, "Failed to delete table: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
