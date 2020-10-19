package com.example.kestir;

public class Islem {
    private String Islem1;
    private String Islem_saati;
    private String Fiyat;

    //Yapıcı metod

    public Islem(String islem1, String islem_saati, String fiyat) {
        Islem1 = islem1;
        Islem_saati = islem_saati;
        Fiyat = fiyat;
    }

    //set metoduyla değer ataması yaptık
    public void setIslem1(String islem1) {
        Islem1 = islem1;
    }

    public void setIslem_saati(String islem_saati) {
        Islem_saati = islem_saati;
    }
    public void setfiyat(String fiyat) {
        Fiyat = fiyat;
    }

    //get metoduyla değerleri getirdik
    public String getIslem1() {
        return Islem1;
    }

    public String getIslem_saati() {
        return Islem_saati;
    }

    public String getfiyat() {
        return Fiyat;
    }
}

