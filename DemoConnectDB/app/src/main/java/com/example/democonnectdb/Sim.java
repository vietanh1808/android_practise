package com.example.democonnectdb;

public class Sim {
    private int id;
    private String so;
    private float gia;

    public Sim(int id, String so, float gia) {
        this.id = id;
        this.so = so;
        this.gia = gia;
    }

    public Sim() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSo() {
        return so;
    }

    public void setSo(String so) {
        this.so = so;
    }

    public float getGia() {
        return gia;
    }

    public void setGia(float gia) {
        this.gia = gia;
    }

    @Override
    public String toString() {
        return "Sim{" +
                "id=" + id +
                ", so='" + so + '\'' +
                ", gia=" + gia +
                '}';
    }
}
