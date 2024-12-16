package com.student.entities;

/**
 *
 * @author Nil
 */
public class Student {
    private int s_roll;
    private String s_name;
    private String s_stream;
    private String s_reg;

    public Student(int s_roll, String s_name, String s_stream, String s_reg) {
        this.s_roll = s_roll;
        this.s_name = s_name;
        this.s_stream = s_stream;
        this.s_reg = s_reg;
    }

    public Student() {
    }

    public int getS_roll() {
        return s_roll;
    }

    public void setS_roll(int s_roll) {
        this.s_roll = s_roll;
    }

    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    public String getS_stream() {
        return s_stream;
    }

    public void setS_stream(String s_stream) {
        this.s_stream = s_stream;
    }

    public String getS_reg() {
        return s_reg;
    }

    public void setS_reg(String s_reg) {
        this.s_reg = s_reg;
    }


    
}
