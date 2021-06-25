package com.example.mobilfinalsqlite;

public class Gorev {
    String resim;
    String gorev;
    int onemDerecesi;
    int hatirlat;


    public Gorev(String resim, String gorev, int onemDerecesi, int hatirlat) {
        this.resim = resim;
        this.gorev = gorev;
        this.onemDerecesi = onemDerecesi;
        this.hatirlat = hatirlat;
    }

    public String getResim() {
        return resim;
    }

    public void setResim(String resim) {
        this.resim = resim;
    }

    public String getGorev() {
        return gorev;
    }

    public void setGorev(String gorev) {
        this.gorev = gorev;
    }

    public int getOnemDerecesi() {
        return onemDerecesi;
    }

    public void setOnemDerecesi(int onemDerecesi) {
        this.onemDerecesi = onemDerecesi;
    }

    public int getHatirlat() {
        return hatirlat;
    }

    public void setHatirlat(int hatirlat) {
        this.hatirlat = hatirlat;
    }
}
