package com.example.digitalmarketingschool;

public class User {

    String userid,email,password,name;
    public User(String userid,String email, String password, String name) {

        this.userid = userid;
        this.email = email;
        this.password = password;
        this.name = name;
    }
    public User(String email_text, String password_text, String name_text){

    }


    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

