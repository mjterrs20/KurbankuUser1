package com.example.asus.kurbankuuser.Model;

public class Bayar{
    private String nama;
    private String norek;
    private String jumlah;
    private String transfer;
    private int mPosition;
    private String mKey;

    public int getmPosition() {
        return mPosition;
    }

    public void setmPosition(int mPosition) {
        this.mPosition = mPosition;
    }

    public Bayar (int position){
        mPosition = position;
    }

    public Bayar (String nama,String norek,String jumlah,String transfer){
        this.nama = nama;
        this.norek = norek;
        this.jumlah = jumlah;
        this.transfer = transfer;
    }



    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNorek() {
        return norek;
    }

    public void setNorek(String norek) {
        this.norek = norek;
    }

    public String getJumlah() {
        return jumlah;
    }

    public void setJumlah(String jumlah) {
        this.jumlah = jumlah;
    }

    public String getTransfer() {
        return transfer;
    }

    public void setTransfer(String transfer) {
        this.transfer = transfer;
    }

    public String getmKey() {
        return mKey;
    }

    public void setmKey(String mKey) {
        this.mKey = mKey;
    }


}
