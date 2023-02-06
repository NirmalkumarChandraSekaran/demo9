import com.example.demo.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class testcases {

    songimpl songimpl;

   playsong play;

   InputStream sc= new InputStream() {
       @Override
       public int read() throws IOException {
           return 0;
       }
   };

    songimpl songimpl1;

    User user;

@Before
    public void setup()
{
     songimpl=new songimpl(new Album("Shahjahan"),new Aritist("Unni Menon"),new gener("melody"),1,"Mellinamae Mellinamae ","src/main/resources/Mellinamae-Mellinamae.wav",5.27);

    play=new playsong();
     user=new User();

}
@After
    public void teardown()
{
    songimpl songimpl=null;
    playlistimpl playlistimpl=null;
    User user=null;

}

@Test
public void searchbyAlbum()
{
    ArrayList<song> song=new ArrayList<>();
    song=songimpl.searchsongbyAlbum("Shahjahan");
    assertEquals(1,song.size());
}

@Test
public void searchbyArtisit()
{
    ArrayList<song> song=new ArrayList<>();
    song=songimpl.searchsongsbyArtisit("Unni Menon");
    assertEquals(1,song.size());

}
 @Test
public void searchbygener()
{
    ArrayList<song> song=new ArrayList<>();
    song=songimpl.searchsongbygenere("Melody");
    assertEquals(1,song.size());

}

    @Test
    public void searchbyAlbumfailure()
    {
        ArrayList<song> song=new ArrayList<>();
        song=songimpl.searchsongbyAlbum("jack");
        assertEquals(0,song.size());
    }


    @Test
    public void searchbyArtisitfailure()
    {
        ArrayList<song> song=new ArrayList<>();
        song=songimpl.searchsongbyAlbum("Anir");
        assertEquals(0,song.size());
    }

    @Test
    public void searchbygenerefailure()
    {
        ArrayList<song> song=new ArrayList<>();
        song=songimpl.searchsongbygenere("Romantic");
        assertEquals(0,song.size());
    }

    @Test
    public void displayallsons()
    {
        ArrayList<song> song=new ArrayList<>();
        song=songimpl.getallsongs();
        assertEquals(4,song.size());
    }

    @Test
    public void Checkuservaluesinsertedintodatabase()
    {
        int check;
        check=user.register("nirmal","12345");
        assertEquals(check,check);
    }

    @Test
    public void Checkuservaluesintodatabase()
    {
        boolean flag;
        flag=user.checkup("123","123");
        assertEquals("True","True");
    }




}
