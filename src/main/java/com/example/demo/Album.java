package com.example.demo;

public class Album {

    private int albumid;

    private String albumname;



    public int getAlbumid() {
        return albumid;
    }

    public void setAlbumid(int albumid) {
        this.albumid = albumid;
    }

    public String getAlbumname() {
        return albumname;
    }

    public void setAlbumname(String albumname) {
        this.albumname = albumname;
    }

    public Album(int albumid, String albumname) {
        this.albumid = albumid;
        this.albumname = albumname;
    }

    public Album(String albumname) {
        this.albumname = albumname;
    }

    @Override
    public String toString() {
        return "Album{" +
                "albumid=" + albumid +
                ", albumname='" + albumname + '\'' +
                '}';
    }
}