package com.example.demo;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Struct;
import java.util.ArrayList;

public class User {

    private int userid;

    public User() {
    }

    private String username;

    private String password;

    Connecter connecter=new Connecter();

    public int register(String name,String password)
    {
        try
        {
            Statement str =connecter.getConnection().createStatement();
            System.out.println(name);
            System.out.println(password);
            str.executeUpdate("insert into user(username,userpassword) value('"+name+"','"+password+"')");

           ResultSet resultSet=str.executeQuery("select * from user");
           while(resultSet.next())
           {
               userid=resultSet.getInt("userid");
           }
            System.out.println("your userid generted and it is"+userid);
            System.out.println("you have registered succesfully");

        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    return userid;}

    public boolean checkup(String name,String password)
    {
        ArrayList<User> check1=new ArrayList<>();
        User user=null;
        System.out.println(name);
        System.out.println(password);
        try {
            Statement str=connecter.getConnection().createStatement();
            ResultSet resultSet=str.executeQuery("select * from user");
            while(resultSet.next())
            {
                user=new User();
                user.setUserid(resultSet.getInt("userid"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("userpassword"));
                check1.add(user);
                if(user.getUsername().equals(name) && user.getPassword().equals(password))
                {

                System.out.println("login successfull");
                return true;


                }
            }



                System.out.println("login failed");
                 return false;

        } catch (SQLException e)
        {
            e.printStackTrace();
        }


    return false;}

    public int useridvalue()
    {
        int use=0;
        try {
            Statement str = connecter.getConnection().createStatement();
            ResultSet resultSet = str.executeQuery("select * from user");
            while (resultSet.next())
            {
                use =resultSet.getInt("userid");

            }
        }catch (SQLException e)
        {
            e.printStackTrace();
        }


    return use;}


    public User(int userid) {
        this.userid = userid;
    }



    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
