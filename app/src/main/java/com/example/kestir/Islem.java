package com.example.kestir;

import androidx.annotation.Nullable;

public class Islem {
    private String Islem1;
    private String Islem_saati;

    //Yapıcı metod
    public Islem() {
        //Yapıcı metod
    }

    public Islem(String islem1, String islem_saati) {
        Islem1 = islem1;
        Islem_saati = islem_saati;
    }

    //set metoduyla değer ataması yaptık
    public void setIslem1(String islem1) {
        Islem1 = islem1;
    }

    public void setIslem_saati(String islem_saati) {
        Islem_saati = islem_saati;
    }

    //get metoduyla değerleri getirdik
    public String getIslem1() {
        return Islem1;
    }

    public String getIslem_saati() {
        return Islem_saati;
    }
}

