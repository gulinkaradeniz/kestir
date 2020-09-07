package com.example.kestir;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.Date;
import java.util.List;

public class veri_tabani2 extends SQLiteOpenHelper {

    private static final String TABLE_NAME2 = "siparis_tablosu";
    private static final String DATABASE_NAME2 = "siparis_veritabani";

    public static final String ID2 = "_id";
    public static final String ISLEM = "islem";
    public static final String TARIH = "tarih";
    public static final String SAAT = "saat";
    public List<String> ArrayList;

    public veri_tabani2(Context context) {
        super(context, DATABASE_NAME2, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db2) {
        String createTableStatement = "CREATE TABLE " + TABLE_NAME2 + "(" + ID2 + " INTEGER PRIMARY KEY AUTOINCREMENT," + ISLEM + " TEXT," + TARIH + " TEXT," + SAAT + " TEXT)";
        db2.execSQL(createTableStatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db2, int i, int i1) {
        db2.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME2);
        onCreate(db2);

    }
    public long Ekle(String islem,String saat){
        SQLiteDatabase db2=this.getWritableDatabase();
        ContentValues cv=new ContentValues();

        cv.put(ISLEM,islem.trim());
        cv.put(SAAT,saat.trim());

        long id2=db2.insert(TABLE_NAME2,null,cv);

        db2.close();
        return id2;
    }
    public long Tarih_Ekle(İslemler tarih){
        SQLiteDatabase db2=this.getWritableDatabase();
        ContentValues cv=new ContentValues();

        cv.put(TARIH,İslemler.getTarih());

        long id2=db2.insert(TABLE_NAME2,null,cv);

        db2.close();
        return id2;
    }
    public long Saat_Ekle(String saat){
        SQLiteDatabase db2=this.getWritableDatabase();
        ContentValues cv=new ContentValues();

        cv.put(SAAT,saat.trim());

        long id2=db2.insert(TABLE_NAME2,null,cv);

        db2.close();
        return id2;
    }


    //public long İslemEkle(String ISLEM,String TARIH,String SAAT) {
    //SQLiteDatabase db=getWritableDatabase();
    //ContentValues cv=new ContentValues();

    //cv.put(ISLEM,islem_secimi.trim());
    //cv.put(MAIL,müsteri.getMail());
    //cv.put(TELEFON,müsteri.getTelefon());
    //cv.put(SIFRE,müsteri.getSifre());

    //long id=db.insert(TABLE_NAME,null,cv);

    //db.close();
    //return id;
}

