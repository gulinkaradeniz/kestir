package com.example.kestir;

import androidx.annotation.Nullable;

public class Musteri {
    private String Adsoyad;
    private String Mail;
    private String Telefon;
    private String Sifre;


    //Yapıcı metod
    public Musteri() {
        //Yapıcı metod
    }

    public Musteri(String adsoyad, String mail, String telefon, String sifre) {
        Adsoyad = adsoyad;
        Mail = mail;
        Telefon = telefon;
        Sifre = sifre;
    }

    //set metoduyla değer ataması yaptık
    public void setAdsoyad(String adsoyad) {
        Adsoyad = adsoyad;
    }

    public void setMail(String mail) {
        Mail = mail;
    }

    public void setTelefon(String telefon) {
        Telefon = telefon;
    }

    public void setSifre(String sifre) {
        Sifre = sifre;
    }

    //get metoduyla değerleri getirdik
    public String getAdsoyad() {
        return Adsoyad;
    }

    public String getMail() {
        return Mail;
    }

    public String getTelefon() {
        return Telefon;
    }

    public String getSifre() {
        return Sifre;
    }
}

