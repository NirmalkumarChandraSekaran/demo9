package com.example.demo;

public class playlist {

    private int playlistid;

    private String playlistname;

    private User userid;

    public playlist(int playlistid, String playlistname, User userid) {
        this.playlistid = playlistid;
        this.playlistname = playlistname;
        this.userid = userid;
    }


    public playlist() {
    }

    public playlist(int playlistid) {
        this.playlistid = playlistid;
    }

    public int getPlaylistid() {
        return playlistid;
    }

    public void setPlaylistid(int playlistid) {
        this.playlistid = playlistid;
    }

    public String getPlaylistname() {
        return playlistname;
    }

    @Override
    public String toString() {
        return "playlist{" +
                "playlistid=" + playlistid +
                ", playlistname='" + playlistname + '\'' +
                ", userid=" + userid +
                '}';
    }

    public User getUserid() {
        return userid;
    }

    public void setUserid(User userid) {
        this.userid = userid;
    }

    public void setPlaylistname(String playlistname) {
        this.playlistname = playlistname;
    }






}
