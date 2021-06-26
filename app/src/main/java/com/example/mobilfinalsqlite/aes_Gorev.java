package com.example.mobilfinalsqlite;

public class aes_Gorev {
    String aes_resim;
    String aes_gorev;
    int aes_onemDerecesi;
    int aes_hatirlat;


    public aes_Gorev(String aes_resim, String aes_gorev, int aes_onemDerecesi, int aes_hatirlat) {
        this.aes_resim = aes_resim;
        this.aes_gorev = aes_gorev;
        this.aes_onemDerecesi = aes_onemDerecesi;
        this.aes_hatirlat = aes_hatirlat;
    }

    public String getAes_resim() {
        return aes_resim;
    }

    public void setAes_resim(String aes_resim) {
        this.aes_resim = aes_resim;
    }

    public String getAes_gorev() {
        return aes_gorev;
    }

    public void setAes_gorev(String aes_gorev) {
        this.aes_gorev = aes_gorev;
    }

    public int getAes_onemDerecesi() {
        return aes_onemDerecesi;
    }

    public void setAes_onemDerecesi(int aes_onemDerecesi) {
        this.aes_onemDerecesi = aes_onemDerecesi;
    }

    public int getAes_hatirlat() {
        return aes_hatirlat;
    }

    public void setAes_hatirlat(int aes_hatirlat) {
        this.aes_hatirlat = aes_hatirlat;
    }
}
