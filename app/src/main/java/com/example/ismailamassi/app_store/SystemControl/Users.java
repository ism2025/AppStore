package com.example.ismailamassi.app_store.SystemControl;


import com.example.ismailamassi.app_store.activity.LoginActivity;

public class Users {
    static int count = 1;
    public int id ;
    public String username;
    public String email;
    public String password;

    public Users(String username, String email, String password) {
        this.id = count;
        this.username = username;
        this.email = email;
        this.password = password;
        SystemControl.users.add(this);
        count++;
    }
}
