package com.example.batoi_61;

public class batoi_vanTai {
    private int id;
    private String bks, tenchuxe, hangxe,trongtai, htkinhdoanh;

    public batoi_vanTai() {
    }

    public batoi_vanTai(int id, String bks, String tenchuxe, String hangxe, String trongtai, String htkinhdoanh) {
        this.id = id;
        this.bks = bks;
        this.tenchuxe = tenchuxe;
        this.hangxe = hangxe;
        this.trongtai = trongtai;
        this.htkinhdoanh = htkinhdoanh;
    }

    public batoi_vanTai(String bks, String tenchuxe, String hangxe, String trongtai, String htkinhdoanh) {
        this.bks = bks;
        this.tenchuxe = tenchuxe;
        this.hangxe = hangxe;
        this.trongtai = trongtai;
        this.htkinhdoanh = htkinhdoanh;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBks() {
        return bks;
    }

    public void setBks(String bks) {
        this.bks = bks;
    }

    public String getTenchuxe() {
        return tenchuxe;
    }

    public void setTenchuxe(String tenchuxe) {
        this.tenchuxe = tenchuxe;
    }

    public String getHangxe() {
        return hangxe;
    }

    public void setHangxe(String hangxe) {
        this.hangxe = hangxe;
    }

    public String getTrongtai() {
        return trongtai;
    }

    public void setTrongtai(String trongtai) {
        this.trongtai = trongtai;
    }

    public String getHtkinhdoanh() {
        return htkinhdoanh;
    }

    public void setHtkinhdoanh(String htkinhdoanh) {
        this.htkinhdoanh = htkinhdoanh;
    }
}
