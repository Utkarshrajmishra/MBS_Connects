package com.example.mbsconnects.HelperClass;

public class notify_data {
    public notify_data() {
    }
    String title,body,time,date;

    public notify_data(String title, String body, String time, String date) {
        this.title = title;
        this.body = body;
        this.time = time;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
