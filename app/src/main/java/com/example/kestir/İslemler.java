package com.example.kestir;

public class İslemler {
    private static String Tarih;
    private String İslem;
    //private String Tarih;
    private String Saat;

    public İslemler(String tarih) {
        //Yapıcı metod
    }

    public İslemler(String islem, String tarih, String saat) {
        İslem = islem;
        Tarih = tarih;
        Saat = saat;
    }

    public String getIslem() {
        return İslem;
    }

    public void setIslem(String islem) {
        İslem = islem;
    }

    public static String getTarih() {
        return Tarih;
    }

    public void setTarih(String tarih) {
        Tarih = tarih;
    }

    public String getSaat() {
        return Saat;
    }

    public void setSaat(String saat) {
        Saat = saat;
    }
}