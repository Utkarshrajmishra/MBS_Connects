package com.example.mbsconnects.HelperClass;

public class UserData {
    public UserData() {
    }
    String name,email,password,course;

    public UserData(String name, String email, String password, String course) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
