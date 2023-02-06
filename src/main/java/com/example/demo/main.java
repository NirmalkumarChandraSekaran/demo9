package com.example.demo;

import com.sun.jdi.connect.Connector;

import java.util.ArrayList;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        Connecter con = new Connecter();
        con.getConnection();
        songimpl song=new songimpl();

        playlistimpl playlist=new playlistimpl();
        playsong playsong=new playsong();
        User obj=new User();
        int userid = 0;
        Scanner sc=new Scanner(System.in);
        ArrayList<song> di=new ArrayList<>();
        ArrayList<playlist> play1=new ArrayList<>();
        int e;
        int u;
        System.out.println("**************hello everyone welcome to juke music**********");
        do {
            System.out.println("**********Enter 1 for login*****************************");
            System.out.println("**********Enter 2 for register**************************");
            System.out.println("**********Enter 3 for guest*****************************");
            System.out.println("**********Enter the option you want to perform**********");
            int oper = sc.nextInt();
            switch (oper) {
                case 1:

                    System.out.println("enter the username ");
                    sc.nextLine();
                    String use = sc.nextLine();

                    System.out.println("enter the  password");
                    String pass = sc.nextLine();
                    if (obj.checkup(use,pass))
                    {
                        userid=obj.useridvalue();
                        do {
                            System.out.println("*******************       Welcom to Juke Music                 ***********************");
                            System.out.println("*******************Enter the function you to perform           ***********************");
                            System.out.println("*******************Enter 1 for display all song                ***********************");
                            System.out.println("*******************Enter 2 for Search song by Artisit          ***********************");
                            System.out.println("*******************Enter 3 for Search song by Album            ***********************");
                            System.out.println("*******************Enter 4 for Search song by gener            ***********************");
                            System.out.println("*******************Enter 5 for create playlist                 ***********************");
                            System.out.println("*******************Enter 6 for  view playlist                  ***********************");
                            System.out.println("*******************Enter 7 for insert song in existing playlist***********************");
                            System.out.println("*******************Enter 8 for exit                            ***********************");
                            int g = sc.nextInt();
                            switch (g) {
                                case 1:
                                    di = song.getallsongs();
                                    song.display(di);
                                    song.playsong(di);
                                    break;
                                case 2:
                                    di = song.getallsongs();
                                    song.display(di);
                                    ArrayList<song> art = new ArrayList<>();
                                    System.out.println("Enter the Artist Name");
                                    sc.nextLine();
                                    String Artist = sc.nextLine();
                                    art = song.searchsongsbyArtisit(Artist);
                                    song.displayselectefromartisit(art);
                                    song.playbyArtisit(art);
                                    break;
                                case 3:
                                    di = song.getallsongs();
                                    song.display(di);
                                    ArrayList<song> alb = new ArrayList<>();
                                    System.out.println("Enter the Album Name");
                                    sc.nextLine();
                                    String Album = sc.nextLine();
                                    alb = song.searchsongbyAlbum(Album);
                                    song.displayselectefromalbum(alb);
                                    song.playbyAlbum(alb);
                                    break;
                                case 4:
                                    di = song.getallsongs();
                                    song.display(di);
                                    ArrayList<song> j = new ArrayList<>();
                                    System.out.println("Enter the gener type ");
                                    sc.nextLine();
                                    String gener = sc.nextLine();
                                    j = song.searchsongbygenere(gener);
                                    song.displaybygenere(j);
                                    song.playsongbygenere(j);
                                    break;
                                case 5:
                                    di = song.getallsongs();
                                    song.display(di);
                                    System.out.println("Enter the name for the playlist");
                                    sc.nextLine();
                                    String pLName =sc.nextLine();
                                    playlist.createplaylist(userid,pLName);
                                    break;
                                case 6:
                                    play1=playlist.viewplaylist();
                                    playlist.displayplaylist(play1);
                                    ArrayList<song> displayplay=new ArrayList<>();
                                    displayplay=playlist.displayfunctionplaylist();
                                    playlist.displaysongid(displayplay);
                                    playlist.play(displayplay);
                                    break;
                                case 7:
                                    play1=playlist.viewplaylist();
                                    playlist.displayplaylist(play1);
                                    playlist.insertsongintoplaylist();
                                case 8:
                                    System.out.println("*******************you entered the last page press any number other than 1 to exit completely");
                                    break;
                                default:
                                    System.out.println("*******************Please enter between 1 to 7***********************************************");
                                    break;
                            }
                            System.out.println("Enter 1 for continue in performing search and display Main Meny functions or else enter any other number to exist");
                            u = sc.nextInt();
                            ;
                        } while (u == 1);
                    }
                    break;
                case 2:
                    System.out.println("********************Enter your new Username for New Registration***********************************************");
                    sc.nextLine();
                    String newusername=sc.nextLine();

                    System.out.println("********************Enter your new password********************************************************************");
                    String newpassword=sc.nextLine();
                    System.out.println("********************After registration if you wish to log in press 1*******************************************");
                    userid=obj.register(newusername,newpassword);

                    break;

                case 3:
                    System.out.println("*******************In guest account you can only listen to songs you can't creata playlist******************** ");
                    int g = sc.nextInt();
                    int h=0;
                    do {


                        switch (g)
                        {
                            case 1:
                                di = song.getallsongs();
                                song.display(di);
                                song.playsong(di);
                                break;
                            case 2:
                                ArrayList<song> art = new ArrayList<>();
                                song.display(di);
                                System.out.println("Enter the Artist Name");
                                sc.nextLine();
                                String Artist = sc.nextLine();
                                art = song.searchsongsbyArtisit(Artist);
                                song.playsong(art);
                                break;
                            case 3:
                                ArrayList<song> alb = new ArrayList<>();
                                song.display(di);
                                System.out.println("Enter the Album Name");
                                sc.nextLine();
                                String Album = sc.nextLine();
                                alb = song.searchsongbyAlbum(Album);
                                song.playsong(alb);
                                break;
                            case 4:
                                ArrayList<song> j = new ArrayList<>();
                                song.display(di);
                                System.out.println("Enter the gener type ");
                                sc.nextLine();
                                String gener = sc.nextLine();
                                j = song.searchsongbygenere(gener);
                                song.playsong(j);
                                break;
                            default:
                                System.out.println("Enter between 1 to 4");
                                break;
                        }
                        System.out.println("if you want to continue press 1 or else press any other number");
                    }while(h==1);

            }
            System.out.println("if want to continue press 1 if mistakenly got  out or else exit press any other number than 1");

            e=sc.nextInt();
        }while(e==1);
    }
}
