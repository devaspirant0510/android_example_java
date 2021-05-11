package com.example.viewmodel;

public class MyInfo {
    String name;
    int age;
    String language;
    String FrameWork;

    public MyInfo(String name, int age, String language, String frameWork) {
        this.name = name;
        this.age = age;
        this.language = language;
        FrameWork = frameWork;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getFrameWork() {
        return FrameWork;
    }

    public void setFrameWork(String frameWork) {
        FrameWork = frameWork;
    }
}
