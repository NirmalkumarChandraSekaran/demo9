package com.example.demo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class songimpl extends  song {


    public songimpl(Album albumid, Aritist artisitid, gener generid, int songid, String songname, String songpath, double duration) {
        super(albumid, artisitid, generid, songid, songname, songpath, duration);
    }

    playsong playsong=new playsong();
    Connecter con = new Connecter();
    ArrayList<song> songArrayList = null;

    Scanner scanner=new Scanner(System.in);

    public songimpl() {

    }

    public ArrayList<song> getallsongs() {

        songArrayList = new ArrayList<song>();
        song song = null;

        try {
            Statement str;
            str = con.getConnection().createStatement();
            ResultSet rs = str.executeQuery("select * from song s,artisit a,album al,gener g where s.artisitid=a.artisitid and s.albumid=al.albumid and s.generid=g.generid;");
            song = new song();
            while (rs.next()) {
                song = new song();
                song.setSongid(rs.getInt("songid"));
                song.setSongname(rs.getString("songname"));
                song.setSongpath(rs.getString("songpath"));
                song.setDuration(rs.getDouble("duration"));
                song.setArtisitid(new Aritist(rs.getInt("Artisitid"), rs.getString("Artisitname")));
                song.setAlbumid(new Album(rs.getInt("Albumid"), rs.getString("Albumname")));
                song.setGenerid(new gener(rs.getInt("generid"), rs.getString("genername")));
                songArrayList.add(song);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return songArrayList;}

    public void playsong(ArrayList<song> songs)
    {
        int check;
        do {
            System.out.println("Enter 1 for playallsong");
            System.out.println("Enter 2 for only one song");
            System.out.println("Enter 3 for end page");
            int w=scanner.nextInt();

            switch(w)
            {
                case 1:
                    playsong.playallsongs(songs);
                    break;
                case 2:
                    System.out.println("Enter the songid");
                    int songid=scanner.nextInt();
                    playsong.playsong(songid);
                    break;
                case 3:
                    System.out.println("End page");
                    break;
                default:
                    System.out.println("enter between 1 and 2");
            }
            System.out.println("if you want to continue enter 1 or else enter any number");
            check=scanner.nextInt();
        }while(check==1);

    }


    public void display(ArrayList<song> getting)
    {
        System.out.printf("|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
        System.out.println();
        System.out.printf("|songid"+"|       songname                    |"+"                  songpath                  |"+"duration|"+"     Artisitname   |     "+"Albumname     |   "+"genername   |");
        System.out.println();
        for(int i=0;i<getting.size();i++)
        {
            System.out.printf("|  "+getting.get(i).getSongid()+"   |   "+getting.get(i).getSongname()+"          |" +getting.get(i).getSongpath()+"|  "+getting.get(i).getDuration()+  "  |"+getting.get(i).getArtisitid().getArtisitname()+"|"+getting.get(i).getAlbumid().getAlbumname()+"|"+getting.get(i).getGenerid().getGenerename()+"|");
            System.out.println();
        }
        System.out.printf("|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
        System.out.println();

    }

    public ArrayList<song> searchsongsbyArtisit(String Artist) {
        Statement str;

        ArrayList<song> artisit = new ArrayList<>();
        song song = null;

        try {
            str = con.getConnection().createStatement();
            ResultSet resultSet = str.executeQuery("select * from song s,artisit a where s.artisitid=a.artisitid and a.artisitname like'" + Artist + "%" + "'");
            while (resultSet.next()) {
                song = new song();
                song.setSongid(resultSet.getInt("songid"));
                song.setSongname(resultSet.getString("songname"));
                song.setSongpath(resultSet.getString("songpath"));
                song.setDuration(resultSet.getDouble("Duration"));
                song.setArtisitid(new Aritist(resultSet.getInt("Artisitid"), resultSet.getString("Artisitname")));

                artisit.add(song);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return artisit; }
    public void displayselectefromartisit(ArrayList<song> getting)
    {
        System.out.printf("|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
        System.out.println();
        System.out.printf("|songid"+"|       songname                    |"+"                  songpath                  |"+"duration|"+"     Artisitname   |     ");
        System.out.println();
        for(int i=0;i<getting.size();i++)
        {
            System.out.printf("|  "+getting.get(i).getSongid()+"   |   "+getting.get(i).getSongname()+"          |" +getting.get(i).getSongpath()+"|  "+getting.get(i).getDuration()+  "  |"+getting.get(i).getArtisitid().getArtisitname()+"|");
            System.out.println();
        }
        System.out.printf("|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
        System.out.println();

    }

    public void playbyArtisit (ArrayList<song> g)
    {
        int check;
        do {
            System.out.println("Enter 1 for playallsong");
            System.out.println("Enter 2 for only one song");
            System.out.println("Enter 3  for end ");
            int w=scanner.nextInt();


            switch(w)
            {
                case 1:
                    playsong.playallsongs(g);
                    break;
                case 2:
                    System.out.println("Enter the songid");
                    int songid=scanner.nextInt();
                    playsong.playsong(songid);
                    break;
                case 3:
                    System.out.println("End page");
                    break;
                default:
                    System.out.println("enter between 1 and 2");
            }
            System.out.println("if you want to continue press1 or press any other number to exit");
            check=scanner.nextInt();
        }while(check==1);
    }



    public ArrayList<song> searchsongbyAlbum(String Album) {
        ArrayList<song> album = new ArrayList<>();
        song song = null;
        Statement str;

        try {
            str = con.getConnection().createStatement();
            ResultSet resultSet = str.executeQuery("select * from song s,album al where  s.albumid=al.albumid and al.albumname like'" + Album + "%" + "'");
            while (resultSet.next()) {
                song = new song();
                song.setSongid(resultSet.getInt("songid"));
                song.setSongname(resultSet.getString("songname"));
                song.setSongpath(resultSet.getString("songpath"));
                song.setDuration(resultSet.getDouble("Duration"));
                song.setAlbumid(new Album(resultSet.getInt("Albumid"), resultSet.getString("Albumname")));
                album.add(song);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return album; }
    public void displayselectefromalbum (ArrayList<song> getting)
    {
        System.out.printf("|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
        System.out.println();
        System.out.printf("|songid"+"|       songname                    |"+"                  songpath                  |"+"duration|"+"     Albumname   |     ");
        System.out.println();
        for(int i=0;i<getting.size();i++)
        {
            System.out.printf("|  "+getting.get(i).getSongid()+"   |   "+getting.get(i).getSongname()+"          |" +getting.get(i).getSongpath()+"|  "+getting.get(i).getDuration()+  "  |"+getting.get(i).getAlbumid().getAlbumname()+"|");
            System.out.println();
        }
        System.out.printf("|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
        System.out.println();

    }

    public void playbyAlbum (ArrayList<song> g)
    {
        int check;
        do {
            System.out.println("Enter 1 for playallsong");
            System.out.println("Enter 2 for only one song");
            System.out.println("Enter 3  for end ");
            int w = scanner.nextInt();


            switch (w) {
                case 1:
                    playsong.playallsongs(g);
                    break;
                case 2:
                    System.out.println("Enter the songid");
                    int songid = scanner.nextInt();
                    playsong.playsong(songid);
                    break;
                case 3:
                    System.out.println("End page");
                    break;
                default:
                    System.out.println("enter between 1 and 2");
            }
            System.out.println("if you want to continue press1 or press any other number to exit");
            check = scanner.nextInt();
        } while (check == 1);
    }
    public ArrayList<song> searchsongbygenere(String gener) {
        ArrayList<song> genere = new ArrayList<>();
        song song = null;
        Statement str;

        try {
            str = con.getConnection().createStatement();
            ResultSet resultSet = str.executeQuery("select * from song s,gener g where s.generid=g.generid and g.genername like'" + gener + "%" + "'");
            while (resultSet.next()) {
                song = new song();
                song.setSongid(resultSet.getInt("songid"));
                song.setSongname(resultSet.getString("songname"));
                song.setSongpath(resultSet.getString("songpath"));
                song.setDuration(resultSet.getDouble("Duration"));
                song.setGenerid(new gener(resultSet.getInt("generid"), resultSet.getString("genername")));
                genere.add(song);

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return genere;}
    public void displaybygenere (ArrayList<song> getting)
    {
        System.out.printf("|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
        System.out.println();
        System.out.printf("|songid"+"|       songname                    |"+"                  songpath                  |"+"duration|"+"genername   |");
        System.out.println();
        for(int i=0;i<getting.size();i++)
        {
            System.out.printf("|  "+getting.get(i).getSongid()+"   |   "+getting.get(i).getSongname()+"          |" +getting.get(i).getSongpath()+"|  "+getting.get(i).getDuration()+  "  |"+getting.get(i).getGenerid().getGenerename()+"|");
            System.out.println();
        }
        System.out.printf("|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------|");
        System.out.println();

    }
    public void playsongbygenere(ArrayList<song> h)
    {
        int check;
        do
        {
            System.out.println("Enter 1 for playallsong");
            System.out.println("Enter 2 for only one song");
            System.out.println("Enter 3 for end page");
            int w=scanner.nextInt();

            switch(w)
            {
                case 1:
                    playsong.playallsongs(h);
                    break;
                case 2:
                    System.out.println("Enter the songid");
                    int songid=scanner.nextInt();
                    playsong.playsong(songid);
                    break;
                case 3:
                    System.out.println("End page");
                    break;
                default:
                    System.out.println("enter between 1 and 2");
            }
            System.out.println("if you want to continue press 1");
            check=scanner.nextInt();
        }while(check==1);

    }





}



