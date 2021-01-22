package com.example.recyclerviewapplication;

public class ChatData {
    String Name;
    String Comment;
    String Time;
    int ViewType;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getComment() {
        return Comment;
    }

    public void setComment(String comment) {
        Comment = comment;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public int getViewType() {
        return ViewType;
    }

    public void setViewType(int viewType) {
        ViewType = viewType;
    }

    public ChatData(String name, String comment, String time, int viewType) {
        Name = name;
        Comment = comment;
        Time = time;
        ViewType = viewType;
    }
}
