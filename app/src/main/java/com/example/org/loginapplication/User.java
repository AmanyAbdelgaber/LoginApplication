package com.example.org.loginapplication;

public class User {

    private String email;
    private String password;
    private String note;
    private int recordurl;

    public User() {
    }

    public User(String email, String password, String note, int recordurl) {
        this.setEmail(email);
        this.setPassword(password);
        this.setNote(note);
        this.setRecordurl(recordurl);
    }

    public User(String email, String password) {
        this(email, password, null, 0);
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getRecordurl() {
        return recordurl;
    }

    public void setRecordurl(int recordurl) {
        this.recordurl = recordurl;
    }
}
