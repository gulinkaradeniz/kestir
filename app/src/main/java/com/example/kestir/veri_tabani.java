package com.example.kestir;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Config;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


//Veri tabanı oluşumu
public class veri_tabani<SIFRE> extends SQLiteOpenHelper {

    private static final String TABLE_NAME = "musteri_tablosu";
    private static final String TABLE_NAME2 = "siparis_tablosu";
    private static final String TABLE_NAME3 = "geldi_tablosu";
    private static final String DATABASE_NAME = "veritabani";

    public static final String ID ="_id" ;
    public static final String AD = "ad_soyad";
    public static final String MAIL ="mail";
    public static final String TELEFON ="telefon";
    public static final String SIFRE ="sifre";

    public static final String ID2 = "_id2";
    public static final String ISLEM = "islem";
    public static final String TARIH = "tarih";
    public static final String SAAT = "saat";
    public static final String TELNO = "telno";
    public static final String DURUM = "durum";
    public static final String IPTAL = "iptal";

    public static final String ID3 ="_id" ;
    public static final String VERI3 = "veri3";

    public veri_tabani(Context context) {
        super(context,DATABASE_NAME, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String TABLE1 ="CREATE TABLE " +TABLE_NAME+"(" +ID+" INTEGER PRIMARY KEY AUTOINCREMENT," +AD+" TEXT," +MAIL+" TEXT," +TELEFON+" TEXT," +SIFRE+" INT)";
        String TABLE2 = "CREATE TABLE " + TABLE_NAME2 + "(" + ID2 + " INTEGER PRIMARY KEY AUTOINCREMENT," + ISLEM + " TEXT," + TARIH + " DATE," + SAAT + " TEXT,"+ TELNO + " TEXT,"+ DURUM + " BOOLEAN,"+ IPTAL + " BOOLEAN)";
        String TABLE3 = "CREATE TABLE " + TABLE_NAME3 + "(" + ID3 + " INTEGER PRIMARY KEY AUTOINCREMENT,"+VERI3+" TEXT)";
        db.execSQL(TABLE1);
        db.execSQL(TABLE2);
        db.execSQL(TABLE3);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME2);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME3);
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
        String query = "SELECT * FROM musteri_tablosu WHERE telefon = '"+telefon+"' AND sifre = '"+sifre+"'";
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
        String query = "SELECT * FROM musteri_tablosu WHERE telefon = '"+telefon+"'";
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
    public List<String> Veriler2() {
        List<String>veriler=new ArrayList<String>();
        SQLiteDatabase db=this.getWritableDatabase();
        String[] sutunlar={AD,MAIL,TELEFON,SIFRE};
        Cursor c=db.query(TABLE_NAME,sutunlar,null, null,null,null,null);
        while (c.moveToNext())
        {
            veriler.add(c.getString(0)+"-"+c.getString(2));

        }

        return veriler;
    }
    //2.tablo için
    public long Ekle(String islem, String saat, String tarih, String telno, Boolean durum, Boolean iptal){
        SQLiteDatabase db2=this.getWritableDatabase();
        ContentValues cv=new ContentValues();

        cv.put(ISLEM,islem.trim());
        cv.put(SAAT,saat.trim());
        cv.put(TARIH,tarih.trim());
        cv.put(TELNO,telno.trim());
        cv.put(DURUM,durum.booleanValue());
        cv.put(IPTAL,iptal.booleanValue());

        long id2=db2.insert(TABLE_NAME2,null,cv);

        db2.close();
        return id2;
    }
    public List<String> VeriListele(String telno) {

        List<String>veriler=new ArrayList<String>();
        SQLiteDatabase db=this.getWritableDatabase();
        String[] sutunlar={ISLEM,SAAT,TARIH,TELNO,DURUM,IPTAL};
        Cursor c=db.query(TABLE_NAME2,sutunlar,TELNO+"=?", new String[]{String.valueOf(telno)},null,null,null);
        while (c.moveToNext())
        {
            veriler.add(c.getString(0)+"-"+c.getString(1)+"-"+c.getString(2));

        }

        return veriler;
    }
    public List<String> VeriListele2() {

        List<String>veriler=new ArrayList<String>();
        SQLiteDatabase db=this.getWritableDatabase();
        String query = "SELECT * FROM siparis_tablosu INNER JOIN musteri_tablosu ON musteri_tablosu.telefon=siparis_tablosu.telno AND durum=true AND iptal=true";
        Cursor c=db.rawQuery(query, null);
        while (c.moveToNext())
        {
            veriler.add(c.getString(0)+"-"+c.getString(8)+"-"+c.getString(10)+"-"+c.getString(1)+"-"+c.getString(2)+"-"+c.getString(3));

        }

        return veriler;
    }
    Cursor readAllData(){
        String query = "SELECT * FROM siparis_tablosu INNER JOIN musteri_tablosu ON musteri_tablosu.telefon=siparis_tablosu.telno";
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=null;
        if(db != null){
            cursor=db.rawQuery(query,null);
        }
        return cursor;

    }
    public List<String> VeriListele3(String date) {

        List<String>veriler=new ArrayList<String>();
        SQLiteDatabase db=this.getWritableDatabase();
        String[] sutunlar={ISLEM,SAAT,TARIH,TELNO,DURUM,IPTAL};
        Cursor c=db.query(TABLE_NAME2,sutunlar,TARIH+"=?", new String[]{String.valueOf(date)},null,null,null);
        while (c.moveToNext())
        {
            veriler.add(c.getString(1));

        }

        return veriler;
    }
    public boolean TarihKontrol(String tarih){
        SQLiteDatabase db=this.getReadableDatabase();
        String query = "SELECT * FROM siparis_tablosu WHERE tarih = '"+tarih+"'";
        Cursor c=db.rawQuery(query, null);
        c.moveToFirst();
        int cursorcount =c.getCount();
        if(cursorcount>0){
            return true;
        }
        else{
            return false;}
    }
    public boolean TarihSaatKontrol(String tarih,String saat){
        SQLiteDatabase db=this.getReadableDatabase();
        String query = "SELECT * FROM siparis_tablosu WHERE tarih = '"+tarih+"'AND saat = '"+saat+"'";
        Cursor c=db.rawQuery(query, null);
        c.moveToFirst();
        int cursorcount =c.getCount();
        if(cursorcount>0){
            return true;
        }
        else{
            return false;}
    }
    public void verisil(long id)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        db.delete(TABLE_NAME2,ID+"="+id,null);
        db.close();
    }
    //3.tablo
    public Boolean update1(boolean b,long id){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(DURUM,b);
        db.update(TABLE_NAME2, cv, ID2 + "=" + id, null);
        return true;
    }
    public Boolean update2(boolean b,long id){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(IPTAL,b);
        db.update(TABLE_NAME2, cv, ID2 + "=" + id, null);
        return true;
    }


    public long GeldiEkle(String j){
        SQLiteDatabase db2=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(VERI3,j);
        long id2=db2.insert(TABLE_NAME3,null,cv);
        db2.close();
        return id2;
    }
    public List<String> VeriListeleGeldi() {

        List<String>veriler=new ArrayList<String>();
        SQLiteDatabase db=this.getWritableDatabase();
        String[] sutunlar={VERI3};
        Cursor c=db.query(TABLE_NAME3,sutunlar,null,null ,null,null,null);
        while (c.moveToNext())
        {
            veriler.add(c.getString(0));

        }

        return veriler;
    }

}


