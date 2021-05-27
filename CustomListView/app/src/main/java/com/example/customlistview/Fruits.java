package com.example.customlistview;

public class Fruits {
    private int imgAvatar, flag;
    private String hoten, club;

    public Fruits() {
    }

    public Fruits(int imgAvatar, String hoten, String club, int flag) {
        this.imgAvatar = imgAvatar;
        this.flag = flag;
        this.hoten = hoten;
        this.club = club;
    }

    public int getImgAvatar() {
        return imgAvatar;
    }

    public void setImgAvatar(int imgAvatar) {
        this.imgAvatar = imgAvatar;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    @Override
    public String toString() {
        return "Fruits{" +
                "imgAvatar=" + imgAvatar +
                ", flag=" + flag +
                ", hoten='" + hoten + '\'' +
                ", club='" + club + '\'' +
                '}';
    }
}
