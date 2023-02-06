package com.example.demo;

public class Aritist {

    private int aritistid;

    private String artisitname;


    public Aritist(String artisitname) {
        this.artisitname = artisitname;
    }

    public Aritist(int aritistid, String artisitname) {
        this.aritistid = aritistid;
        this.artisitname = artisitname;
    }

    public int getAritistid() {
        return aritistid;
    }

    public void setAritistid(int aritistid) {
        this.aritistid = aritistid;
    }

    public String getArtisitname() {
        return artisitname;
    }

    public void setArtisitname(String artisitname) {
        this.artisitname = artisitname;
    }

    @Override
    public String toString() {
        return "Aritist{" +
                "aritistid=" + aritistid +
                ", artisitname='" + artisitname + '\'' +
                '}';
    }
}
