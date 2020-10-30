package com.example.recycle_menu;

public class Maindata {
    private int profile;
    private String user_name;
    private String address;
    private String phone_number;

    public Maindata(int profile, String user_name, String address, String phone_number) {
        this.profile = profile;
        this.user_name = user_name;
        this.address = address;
        this.phone_number = phone_number;
    }

    public int getProfile() {
        return profile;
    }

    public void setProfile(int profile) {
        this.profile = profile;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }
}
