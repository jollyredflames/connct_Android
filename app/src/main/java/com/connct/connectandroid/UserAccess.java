package com.connct.connectandroid;

public class UserAccess {

    private boolean seeEmail;
    private boolean seeFacebook;
    private boolean seeInstagram;
    private boolean seePhone;
    private boolean seeSnapchat;
    private boolean seeTwitter;

    public UserAccess() {
    }

    public UserAccess(boolean seeEmail, boolean seeFacebook, boolean seeInstagram, boolean seePhone,
                      boolean seeSnapchat, boolean seeTwitter){
        this.seeEmail = seeEmail;
        this.seeFacebook = seeFacebook;
        this.seeInstagram = seeInstagram;
        this.seePhone = seePhone;
        this.seeSnapchat = seeSnapchat;
        this.seeTwitter = seeTwitter;

    }

    public boolean isSeeEmail() {
        return seeEmail;
    }

    public void setSeeEmail(boolean seeEmail) {
        this.seeEmail = seeEmail;
    }

    public boolean isSeeFacebook() {
        return seeFacebook;
    }

    public void setSeeFacebook(boolean seeFacebook) {
        this.seeFacebook = seeFacebook;
    }

    public boolean isSeeInstagram() {
        return seeInstagram;
    }

    public void setSeeInstagram(boolean seeInstagram) {
        this.seeInstagram = seeInstagram;
    }

    public boolean isSeePhone() {
        return seePhone;
    }

    public void setSeePhone(boolean seePhone) {
        this.seePhone = seePhone;
    }

    public boolean isSeeSnapchat() {
        return seeSnapchat;
    }

    public void setSeeSnapchat(boolean seeSnapchat) {
        this.seeSnapchat = seeSnapchat;
    }

    public boolean isSeeTwitter() {
        return seeTwitter;
    }

    public void setSeeTwitter(boolean seeTwitter) {
        this.seeTwitter = seeTwitter;
    }


}
