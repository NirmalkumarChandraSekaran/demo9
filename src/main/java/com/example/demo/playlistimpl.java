package com.example.demo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class playlistimpl {
    ArrayList<song> songs=null;

    Scanner sc=new Scanner(System.in);

    songimpl so=new songimpl();

    playsong playsong=new playsong();
    Connecter con = new Connecter();


    public void createplaylist(int userid,String pLName)
    {
        con.getConnection();
        int u=0;
        int i=0;
        try {
            Statement str =con.getConnection().createStatement();

           str.executeUpdate("insert into playlist(playlistname,userid) value('"+pLName+"','"+userid+"')");
            ResultSet resultSet=str.executeQuery("select * from playlist where playlistname='"+pLName+"'");
            while(resultSet.next())
            {
                i = resultSet.getInt("playlistid");
                u=resultSet.getInt("userid");
            }
            System.out.println("New playlist created");
            System.out.println("Enter how many songs you want to add");
            int count=sc.nextInt();

            while(count>0)
            {
                System.out.println("Enter the songid");
                int s = sc.nextInt();
                str = con.getConnection().createStatement();
                str.executeUpdate("insert into playlistsong(playlistid,songid) value('" + i + "','" + s + "')");
                count--;
            }
            System.out.println("song succesfully inserted");
            }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }



public void insertsongintoplaylist()
{
        try {
            Statement str = con.getConnection().createStatement();
            System.out.println("Enter the playlistid you want to insert song in it");
            int k=sc.nextInt();
            ResultSet resultSet = str.executeQuery("select * from playlist Where playlistid="+k);
            while (resultSet.next())
            {
                k = resultSet.getInt("playlistid");
            }
            System.out.println("Enter how many songs you want to add");
            int count = sc.nextInt();
            while (count > 0) {
                System.out.println("Enter the songid");
                int s = sc.nextInt();

                str.executeUpdate("insert into playlistsong(playlistid,songid) value('" + k + "','" + s + "')");

                System.out.println("song succesfully inserted");

                count--;
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
    }




    public ArrayList<playlist> viewplaylist()
    {
        ArrayList<playlist> playlists=new ArrayList<>();
        con.getConnection();
        playlist playlist=null;
        Statement str= null;

        try {
            str = con.getConnection().createStatement();
            ResultSet resultSet = str.executeQuery("select *  from  playlist");

            while (resultSet.next()) {

                playlist = new playlist();
                playlist.setPlaylistid(resultSet.getInt("playlistid"));
                playlist.setPlaylistname(resultSet.getString("playlistname"));
                playlist.setUserid(new User(resultSet.getInt("userid")));
                playlists.add(playlist);
            }
//            System.out.println(playlists);
        }
            catch (SQLException e) {
                e.printStackTrace();
            }
        return playlists;}

            public void displayplaylist(ArrayList<playlist> getting)
            {


                    System.out.printf("|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
                    System.out.println();
                    System.out.printf("|Playlistid"+"|       PlaylistName          |"+"          Userid     |");
                    System.out.println();
                    for(int i=0;i<getting.size();i++)
                    {
                        System.out.printf("|  "+getting.get(i).getPlaylistid()+"       |       "+getting.get(i).getPlaylistname()+"                  |           "  +getting.get(i).getUserid().getUserid()+"        |");
                        System.out.println();
                    }
                    System.out.printf("|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
                    System.out.println();




            }


              public ArrayList<song> displayfunctionplaylist()
              {
                  ArrayList<song> playsong1=new ArrayList<>();
                 System.out.println("Enter the playlistid you want to play");
                 int j=sc.nextInt();

                  Statement str= null;
                  try
                  {
                      str = con.getConnection().createStatement();

                  ResultSet resultSet = str.executeQuery("select songid from playlistsong  where playlistid="+j);

                 song song=null;
                while (resultSet.next())
                {

                    int i = resultSet.getInt("songid");
                    Statement strm = con.getConnection().createStatement();
                    ResultSet resultSet1 = strm.executeQuery("select * from song where songid='" + i + "'");
                    while (resultSet1.next())
                    {
                        song = new song();
                        song.setSongid(resultSet1.getInt("songid"));
                        song.setSongname(resultSet1.getString("songname"));
                        song.setSongpath(resultSet1.getString("songpath"));
                        playsong1.add(song);

                    }
                }
                } catch (SQLException e)
                      {
                          throw new RuntimeException(e);
                      }

        return playsong1;}


      public void displaysongid(ArrayList<song> get)
      {
          System.out.printf("|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
          System.out.println();
          System.out.printf("|songid"+"|       songName          |"+"          songpath     |");
          System.out.println();
          for(int i=0;i<get.size();i++)
          {
              System.out.printf("|  "+get.get(i).getSongid()+"|       "+get.get(i).getSongname()+"                  |           "  +get.get(i).getSongpath()+"        |");
              System.out.println();
          }
          System.out.printf("|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
          System.out.println();


      }
    public void play(ArrayList<song> play)
    {
        int check;
        do {
            System.out.println("Enter 1 for playallsong");
            System.out.println("Enter 2 for only one song");
            System.out.println("Enter 3 for end page");
            int w=sc.nextInt();

            switch(w)
            {
                case 1:
                    playsong.playallsongs(play);
                    break;
                case 2:
                    System.out.println("Enter the songid");
                    int songid=sc.nextInt();
                    playsong.playsong(songid);
                    break;
                case 3:
                    System.out.println("End page");
                    break;
                default:
                    System.out.println("enter between 1 and 2");
            }
            System.out.println("if you want to continue enter 1 or else enter any number");
            check=sc.nextInt();
        }while(check==1);

    }







}



