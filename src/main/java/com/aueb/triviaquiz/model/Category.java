package com.aueb.triviaquiz.model;

public class Category {

    public static final int HISTORY = 1;
    public static final int GEOGRAPHY = 2;
    public static final int SPORTS = 3;
    public static final int POP_CULTURE = 4;
    public static final int SCIENCE = 5;

    private int id;
    private String name;

    public Category() {}

    public Category(String name) {
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

    @Override
    public String toString() {
        return  getName();
    }

}
