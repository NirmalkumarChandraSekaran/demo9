package com.example.demo;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class playsong {
    song playsong = new song();

    Connecter co = new Connecter();
    Scanner sc = new Scanner(System.in);

    public void playallsongs(ArrayList<song> song) {
        String response = "";
        for (song s : song) {
            String filename = s.getSongpath();
            File file = new File(filename);
            try {
                AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
                Clip clip = AudioSystem.getClip();
                clip.open(audioStream);
                System.out.println("Song name" + s.getSongname());
                do {
                    System.out.println("Enter your Choice for " + s.getSongname() + ";");
                    System.out.println("P=play,S=stop,R=reset,N=next,Q=quit,L=repeat");
                    response = sc.nextLine();
                    response = response.toUpperCase();
                    switch (response) {
                        case ("P"):
                            clip.start();
                            break;
                        case ("S"):
                            clip.stop();
                            break;
                        case ("R"):
                            clip.setMicrosecondPosition(0);
                            break;
                        case ("N"):
                            clip.close();
                            break;
                        case ("Q"):
                            clip.close();
                            break;
                        case ("L"):
                            clip.loop(1);
                            break;

                        default:
                            System.out.println("Not a valid response");
                    }

                } while (!(response.equals("Q") || response.equals("q") || response.equals("N") || response.equals("n")));
                if (response.equals("Q") || response.equals("q"))
                {
                    System.out.println("Byee");
                    break;
                }
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                e.printStackTrace();
            }

        }
        System.out.println("bye all song played");
    }

    public void playsong(int songid) {

        try {
            Statement str = co.getConnection().createStatement();
            ResultSet resultSet = str.executeQuery("select * from song where songid='" + songid + "'");
//           ResultSet resultSet2 = str.executeQuery("select songname from song where songid='" + songid + "'");
            while (resultSet.next())
            {
                String songurl = resultSet.getString("songpath");
                String songname = resultSet.getString("songname");
                String response = "";
                File file = new File(songurl);
                AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
                Clip clip = AudioSystem.getClip();
                clip.open(audioStream);
                System.out.println("Song name"+songname );
                do {
                    System.out.println("Enter your Choice for " +songname+ ";\nP=play,S=stop,R=reset,N=next,Q=quit L=Repeat");
                    response = sc.nextLine();
                    response = response.toUpperCase();
                    switch (response) {
                        case ("P"):
                            clip.start();
                            break;
                        case ("S"):
                            clip.stop();
                            break;
                        case ("R"):
                            clip.setMicrosecondPosition(0);
                            break;
                        case ("N"):
                            clip.close();
                            break;
                        case ("Q"):
                            clip.close();
                            break;
                        case ("L"):
                            clip.loop(1);
                            break;
                        default:
                            System.out.println("Not a valid response");
                            break;

                    }

                } while (!(response.equals("Q") || response.equals("q") || response.equals("N") || response.equals("n")));
                if (response.equals("Q") || response.equals("q"))break;
                {
                    System.out.println("bye");
                }



            }
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException | SQLException e) {
            e.printStackTrace();
        }


    }
}





