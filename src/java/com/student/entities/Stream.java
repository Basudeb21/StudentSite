package com.student.entities;

/**
 *
 * @author Nil
 */
public class Stream {
    private int id;
    private String name;

    public Stream() {
    }
    
    

    public Stream(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
