package com.example.kestir;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.Editable;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class islemler_veri_tabani extends SQLiteOpenHelper {
    private static final String TABLE_NAME = "islemler_tablosu";
    private static final String DATABASE_NAME = "islemler_veritabani";

    public static final String ID = "_id";
    public static final String ISLEMLER = "islemler";
    public static final String ISLEMSAATI = "islemsaati";
    public static final String FIYAT = "fiyat";


    public islemler_veri_tabani(Context context) {
        super(context,DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String TABLE = "CREATE TABLE " + TABLE_NAME + "(" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"+ISLEMLER+" TEXT,"+ ISLEMSAATI + " TEXT,"+ FIYAT + " DOUBLE)";
        db.execSQL(TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);

    }
    public boolean IslemEkle(Islem islem) {
        SQLiteDatabase db2=getWritableDatabase();
        ContentValues cv=new ContentValues();

        cv.put(ISLEMLER, islem.getIslem1());
        cv.put(ISLEMSAATI, islem.getIslem_saati());
        cv.put(FIYAT, islem.getfiyat());


        long id=db2.insert(TABLE_NAME,null,cv);
        if(id==-1) return false;
        else return true;
    }
    public List<String> İslemListele() {

        List<String>veriler=new ArrayList<String>();
        SQLiteDatabase db=this.getWritableDatabase();
        String[] sutunlar={ID,ISLEMLER,ISLEMSAATI,FIYAT};
        Cursor c=db.query(TABLE_NAME,sutunlar,null,null ,null,null,null);
        while (c.moveToNext())
        {
            veriler.add(c.getString(0)+"-"+c.getString(1)+"-"+c.getString(2)+"-"+c.getString(3)+" TL");

        }

        return veriler;
    }
    public void verisil(long id)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        db.delete(TABLE_NAME,ID+"="+id,null);
        db.close();
    }
    public Boolean update_islemler(String a, String b, String c, long id){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(ISLEMLER,a);
        cv.put(ISLEMSAATI,b);
        cv.put(FIYAT,c);
        db.update(TABLE_NAME, cv, ID + "=" + id, null);
        return true;
    }
    public boolean IslemKontrol(String islem){
        SQLiteDatabase db=this.getReadableDatabase();
        String query = "SELECT * FROM islemler_tablosu WHERE islem = '"+islem+"'";
        Cursor c=db.rawQuery(query, null);
        c.moveToFirst();
        int cursorcount =c.getCount();
        if(cursorcount>0){
            return true;
        }
        else{
            return false;}
    }
    public List<String> İslemSaatiListele(String islemler) {

        List<String>veriler=new ArrayList<String>();
        SQLiteDatabase db=this.getWritableDatabase();
        String[] sutunlar={ID,ISLEMLER,ISLEMSAATI};
        Cursor c=db.query(TABLE_NAME,sutunlar,ISLEMLER+"=?", new String[]{String.valueOf(islemler)},null,null,null);
        while (c.moveToNext())
        {
            veriler.add(c.getString(2));

        }

        return veriler;
    }
    public List<String> İslemListele2() {

        List<String>veriler=new ArrayList<String>();
        SQLiteDatabase db=this.getWritableDatabase();
        String[] sutunlar={ID,ISLEMLER,ISLEMSAATI,FIYAT};
        Cursor c=db.query(TABLE_NAME,sutunlar,null,null ,null,null,null);
        while (c.moveToNext())
        {
            veriler.add(c.getString(1)+"-"+c.getString(3)+" TL");

        }

        return veriler;
    }
}
