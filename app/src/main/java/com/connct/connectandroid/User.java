package com.connct.connectandroid;

public class User {

    private String username;
    private String email;
    private String facebook;
    private String facebookID;
    private String instagram;
    private String phone;
    private String snapchat;
    private String twitter;

    public User() {
    }

    public User(String username, String email) {
        this.email = email;
        this.facebook = "";
        this.facebookID = "";
        this.instagram = "";
        this.phone = "";
        this.username = username;
        this.snapchat = "";
        this.twitter = "";
    }

    public User(String username, String email, String phone, String facebook, String facebookID,
                String instagram, String snapchat, String twitter) {
        this.email = email;
        this.facebook = facebook;
        this.facebookID = facebookID;
        this.instagram = instagram;
        this.phone = phone;
        this.username = username;
        this.snapchat = snapchat;
        this.twitter = twitter;

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getFacebookID() {
        return facebookID;
    }

    public void setFacebookID(String facebookID) {
        this.facebookID = facebookID;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSnapchat() {
        return snapchat;
    }

    public void setSnapchat(String snapchat) {
        this.snapchat = snapchat;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }



}

