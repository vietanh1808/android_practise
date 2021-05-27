package com.example.getimagefrominternet;

import java.io.Serializable;

public class Student implements Serializable {
    private String Name;
    private int age;
    private boolean sex; // true: là nam, false là nữ
    private float diemtb;

    public Student() {
    }

    public Student(String name, int age, boolean sex, float diemtb) {
        Name = name;
        this.age = age;
        this.sex = sex;
        this.diemtb = diemtb;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public float getDiemtb() {
        return diemtb;
    }

    public void setDiemtb(float diemtb) {
        this.diemtb = diemtb;
    }

    @Override
    public String toString() {
        return "Student{" +
                "Name='" + Name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", diemtb=" + diemtb +
                '}';
    }
}
