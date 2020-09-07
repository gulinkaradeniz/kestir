package com.example.kestir;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class veri_tabani extends SQLiteOpenHelper {

    private static final String CUSTOMER_TABLE = "CUSTOMER_TABLE";
    private static final String COL_CUSTOMER_NAME = "CUSTOMER_NAME";
    private static final String COL_CUSTOMER_ISLEM = "CUSTOMER_ISLEM";
    private static final String COL_CUSTOMER_TARIH ="CUSTOMER_TARIH" ;
    private static final String COL_CUSTOMER_SAAT ="CUSTOMER_SAAT";
    private static final String COL_CUSTOMER_ID ="CUSTOMER_ID" ;

    public veri_tabani(Context context) {
        super(context,"customer.db ", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement ="CREATE TABLE " +CUSTOMER_TABLE+"(" +COL_CUSTOMER_ID+" INTEGER PRIMARY KEY AUTOINCREMENT," +COL_CUSTOMER_NAME+" TEXT," +COL_CUSTOMER_ISLEM+" BOOL," +COL_CUSTOMER_TARIH+" TEXT," +COL_CUSTOMER_SAAT+" TEXT)";
        db.execSQL(createTableStatement);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }
    public boolean addOne(CustomerModel customerModel){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(COL_CUSTOMER_NAME,customerModel.getName());
        cv.put(COL_CUSTOMER_ISLEM,customerModel.isActive_islem());
        cv.put(COL_CUSTOMER_TARIH,customerModel.getTarih());
        cv.put(COL_CUSTOMER_SAAT,customerModel.isActive_saat());

        long insert=db.insert(CUSTOMER_TABLE,null,cv);
        if (insert==-1){
            return false;
        }
        else{
            return true;
        }

    }
}
