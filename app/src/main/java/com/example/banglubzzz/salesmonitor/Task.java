package com.example.banglubzzz.salesmonitor;

/**
 * Created by BangLubzzz on 12/1/2017.
 */

public class Task {
    String gambar;

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getMap() {
        return map;
    }

    public void setMap(String map) {
        this.map = map;
    }

    String judul;
    String map;

    public Task(String gambar, String judul, String map) {
        this.gambar = gambar;
        this.judul = judul;
        this.map = map;
    }


}
