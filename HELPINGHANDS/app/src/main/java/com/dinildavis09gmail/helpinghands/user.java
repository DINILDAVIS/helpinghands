package com.dinildavis09gmail.helpinghands;

/**
 * Created by DENIL on 03-04-2016.
 */
public class user {
    String email,name;
    Integer password,phone;
    public user()
    {

    }
    public user(String email, String name, Integer password, Integer phone) {

        this.email = email;
        this.name = name;
        this.password = password;
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPassword() {
        return password;
    }

    public void setPassword(Integer password) {
        this.password = password;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }


}
