package com.example.demo;

public class gener {

    private int generid;

    private String generename;

    public gener() {
    }

    public gener(String generename) {
        this.generename = generename;
    }

    public gener(int generid, String generename) {
        this.generid = generid;
        this.generename = generename;
    }

    public int getGenerid() {
        return generid;
    }

    public void setGenerid(int generid) {
        this.generid = generid;
    }

    public String getGenerename() {
        return generename;
    }

    public void setGenerename(String generename) {
        this.generename = generename;
    }

    @Override
    public String toString() {
        return "gener{" +
                "generid=" + generid +
                ", generename='" + generename + '\'' +
                '}';
    }
}
