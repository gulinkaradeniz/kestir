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
    //private Object Müsteri;

    public veri_tabani(Context context) {
        super(context,DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement ="CREATE TABLE " +TABLE_NAME+"(" +ID+" INTEGER PRIMARY KEY AUTOINCREMENT," +AD+" TEXT," +MAIL+" TEXT," +TELEFON+" TEXT," +SIFRE+" INT)";
        db.execSQL(createTableStatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);

    }

    public boolean KayitEkle(Musteri musteri) {
        SQLiteDatabase db=getWritableDatabase();
        ContentValues cv=new ContentValues();

        cv.put(AD, musteri.getAdsoyad());
        cv.put(MAIL, musteri.getMail());
        cv.put(TELEFON, musteri.getTelefon());
        cv.put(SIFRE, musteri.getSifre());

        long id=db.insert(TABLE_NAME,null,cv);
        if(id==-1) return false;
        else return true;
    }

    public boolean Telefon_sifre(String telefon,String sifre){
        SQLiteDatabase db=this.getReadableDatabase();
        String query = "SELECT * FROM müsteri_tablosu WHERE telefon = '"+telefon+"' AND sifre = '"+sifre+"'";
        Cursor c=db.rawQuery(query, null);
        c.moveToFirst();
        int cursorcount =c.getCount();
        if(cursorcount>0){
            return true;
        }
        else{
            return false;}

    }
    public boolean Telefonno(String telefon){
        SQLiteDatabase db=this.getReadableDatabase();
        String query = "SELECT * FROM müsteri_tablosu WHERE telefon = '"+telefon+"'";
        Cursor c=db.rawQuery(query, null);
        c.moveToFirst();
        int cursorcount =c.getCount();
        if(cursorcount>0){
            return true;
        }
        else{
            return false;}


    }
    public boolean Sifreyenile(String telefon,String sifreyenile){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(SIFRE,sifreyenile);
        db.update(TABLE_NAME,cv,"TELEFON = ?",new String[]{telefon});
        return true;
    }





    public List<Musteri> TümKayitlariGetir() {

        SQLiteDatabase db=this.getReadableDatabase();
        String[] sutunlar=new String[]{AD,MAIL,TELEFON,SIFRE};
        Cursor c=db.query(TABLE_NAME,sutunlar,null,null,null,null,null);
        int adsirano=c.getColumnIndex(AD);
        int mailsirano=c.getColumnIndex(MAIL);
        int telefonsirano=c.getColumnIndex(TELEFON);
        int sifresirano=c.getColumnIndex(SIFRE);

        List<Musteri> musteriList =new ArrayList<Musteri>();
        for(c.moveToFirst();!c.isAfterLast();c.moveToNext()){
            Musteri musteri =new Musteri();
            musteri.setAdsoyad(c.getString(adsirano));
            musteri.setMail(c.getString(mailsirano));
            musteri.setTelefon(c.getString(telefonsirano));
            musteri.setSifre(c.getString(sifresirano));

            musteriList.add(musteri);
            db.close();
        }

        return musteriList;
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


