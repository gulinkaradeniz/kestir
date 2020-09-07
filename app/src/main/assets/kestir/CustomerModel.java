package com.example.kestir;

public class CustomerModel {
    private String tarih;
    private boolean isActive_saat;
    private int id;
    private String name;
    private boolean isActive_islem;

    public CustomerModel (int id,String name,boolean isActive_islem,String tarih,boolean isActive_saat){
        this.id=id;
        this.name=name;
        this.isActive_islem=isActive_islem;
        this.tarih=tarih;
        this.isActive_saat=isActive_saat;
    }
    public CustomerModel () {
    }
    @Override
    public String toString() {
        return "CustomerModel{" +
                "tarih='" + tarih + '\'' +
                ", isActive_saat=" + isActive_saat +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", isActive_islem=" + isActive_islem +
                '}';
    }

    public String getTarih() {
        return tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }

    public boolean isActive_saat() {
        return isActive_saat;
    }

    public void setActive_saat(boolean active_saat) {
        isActive_saat = active_saat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive_islem() {
        return isActive_islem;
    }

    public void setActive_islem(boolean active_islem) {
        isActive_islem = active_islem;
    }
}


