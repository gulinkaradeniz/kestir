package com.example.kestir;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;


//Veri tabanı oluşumu
public class veri_tabani<SIFRE> extends SQLiteOpenHelper {

    private static final String TABLE_NAME = "müsteri_tablosu";
    private static final String DATABASE_NAME = "müsteri_veritabani";

    public static final String ID ="_id" ;
    public static final String AD = "ad_soyad";
    public static final String MAIL ="mail";
    public static final String TELEFON ="telefon";
    public static final String SIFRE ="sifre";

    public List<String> ArrayList;

    public veri_tabani(Context context) {
        super(context,DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement ="CREATE TABLE " +TABLE_NAME+"(" +ID+" INTEGER PRIMARY KEY AUTOINCREMENT," +AD+" TEXT," +MAIL+" TEXT," +TELEFON+" TEXT," +SIFRE+" TEXT)";
        db.execSQL(createTableStatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);

    }

    public long KayitEkle(Müsteri müsteri) {
        SQLiteDatabase db=getWritableDatabase();
        ContentValues cv=new ContentValues();

        cv.put(AD,müsteri.getAdsoyad());
        cv.put(MAIL,müsteri.getMail());
        cv.put(TELEFON,müsteri.getTelefon());
        cv.put(SIFRE,müsteri.getSifre());

        long id=db.insert(TABLE_NAME,null,cv);

        db.close();
        return id;
    }

    public List<Müsteri> TümKayitlariGetir() {

        SQLiteDatabase db=this.getReadableDatabase();
        String[] sutunlar=new String[]{AD,MAIL,TELEFON,SIFRE};
        Cursor c=db.query(TABLE_NAME,sutunlar,null,null,null,null,null);
        int adsirano=c.getColumnIndex(AD);
        int mailsirano=c.getColumnIndex(MAIL);
        int telefonsirano=c.getColumnIndex(TELEFON);
        int sifresirano=c.getColumnIndex(SIFRE);

        List<Müsteri> müsteriList=new ArrayList<Müsteri>();
        for(c.moveToFirst();!c.isAfterLast();c.moveToNext()){
            Müsteri müsteri=new Müsteri();
            müsteri.setAdsoyad(c.getString(adsirano));
            müsteri.setMail(c.getString(mailsirano));
            müsteri.setTelefon(c.getString(telefonsirano));
            müsteri.setSifre(c.getString(sifresirano));

            müsteriList.add(müsteri);
            db.close();
        }

        return müsteriList;
    }
    public Cursor getTumKayitlarCursor(){
        SQLiteDatabase db=this.getReadableDatabase();
        String[] sutunlar=new String[]{ID,AD,MAIL,TELEFON,SIFRE};
        Cursor cursor=db.query(TABLE_NAME,sutunlar,null,null,null,null,null);

        return cursor;
    }
    public boolean checkUser(String telefon, String sifre) {
        String[] columns = {ID};
        SQLiteDatabase db = this.getReadableDatabase();
        String selection = TELEFON + " = ?" + " AND " + SIFRE+ " = ?";
        String[] selectionArgs = {telefon, sifre};
        Cursor cursor = db.query(TABLE_NAME, //Table to query
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


