package com.example.demo;
import java.sql.*;
import java.util.ArrayList;
import java.util.*;


public class song
{
    public song(Album albumid, Aritist artisitid, gener generid, int songid, String songname, String songpath, double duration) {
        Albumid = albumid;
        Artisitid = artisitid;
        this.generid = generid;
        this.songid = songid;
        this.songname = songname;
        this.songpath = songpath;
        this.duration = duration;
    }

    private  Album Albumid;

   private  Aritist Artisitid;

   private  gener  generid;

    private int songid;

    private String songname;

    private String songpath;

    private double duration;



    public song() {

    }

    public song(int songid) {
        this.songid = songid;
    }

    public Album getAlbumid() {
        return Albumid;
    }

    public void setAlbumid(Album albumid) {
        Albumid = albumid;
    }

    public Aritist getArtisitid() {
        return Artisitid;
    }

    public void setArtisitid(Aritist artisitid) {
        Artisitid = artisitid;
    }

    public gener getGenerid() {
        return generid;
    }

    public void setGenerid(gener generid) {
        this.generid = generid;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public int getSongid() {
        return songid;
    }

    public void setSongid(int songid) {
        this.songid = songid;
    }

    public String getSongname() {
        return songname;
    }

    public void setSongname(String songname) {
        this.songname = songname;
    }

    public String getSongpath() {
        return songpath;
    }

    public void setSongpath(String songpath) {
        this.songpath = songpath;
    }

    @Override
    public String toString() {
        return "song{" +
                "Albumid=" + Albumid +
                ", Artisitid=" + Artisitid +
                ", generid=" + generid +
                ", songid=" + songid +
                ", songname='" + songname + '\'' +
                ", songpath='" + songpath + '\'' +
                ", duration=" + duration +
                '}';
    }
}

