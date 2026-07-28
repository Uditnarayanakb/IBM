package com.bank;

public class Student {

    private int studentId;
    private String studentName;

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void display() {
        System.out.println("Student ID : " + studentId);
        System.out.println("Student Name : " + studentName);
    }
}