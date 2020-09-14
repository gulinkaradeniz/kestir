package com.example.kestir;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class veri_tabani2 extends SQLiteOpenHelper {

    private static final String TABLE_NAME2 = "siparis_tablosu";
    private static final String DATABASE_NAME2 = "siparis_veritabani";

    public static final String ID2 = "_id";
    public static final String ISLEM = "islem";
    public static final String TARIH = "tarih";
    public static final String SAAT = "saat";
    public static final String TELNO = "telno";
    public List<String> ArrayList;

    public veri_tabani2(Context context) {
        super(context, DATABASE_NAME2, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db2) {
        String createTableStatement = "CREATE TABLE " + TABLE_NAME2 + "(" + ID2 + " INTEGER PRIMARY KEY AUTOINCREMENT," + ISLEM + " TEXT," + TARIH + " DATE," + SAAT + " TEXT,"+ TELNO + " TEXT)";
        db2.execSQL(createTableStatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db2, int i, int i1) {
        db2.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME2);
        onCreate(db2);

    }
    public long Ekle(String islem, String saat, String tarih,String telno){
        SQLiteDatabase db2=this.getWritableDatabase();
        ContentValues cv=new ContentValues();

        cv.put(ISLEM,islem.trim());
        cv.put(SAAT,saat.trim());
        cv.put(TARIH,tarih.trim());
        cv.put(TELNO,telno.trim());

        long id2=db2.insert(TABLE_NAME2,null,cv);

        db2.close();
        return id2;
    }
    public List<String> VeriListele(String telno) {

        List<String>veriler=new ArrayList<String>();
        SQLiteDatabase db=this.getWritableDatabase();
        String[] sutunlar={ISLEM,SAAT,TARIH,TELNO};
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
        String[] sutunlar={ISLEM,SAAT,TARIH,TELNO};
        Cursor c=db.query(TABLE_NAME2,sutunlar,null, null,null,null,null);
        while (c.moveToNext())
        {
            veriler.add(c.getString(0)+"-"+c.getString(1)+"-"+c.getString(2)+"-"+c.getString(3));

        }

        return veriler;
    }
    public boolean Telno(String telno){
        SQLiteDatabase db=this.getReadableDatabase();
        //String query = "SELECT * FROM siparis_tablosu WHERE telefon = '"+telno+"'";
        Cursor c=db.rawQuery("SELECT * FROM siparis_tablosu WHERE telno like "+telno+"", null);
        c.moveToNext();
        int cursorcount =c.getCount();
        if(cursorcount>0){
            return true;
        }
        else{
            return false;}


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

