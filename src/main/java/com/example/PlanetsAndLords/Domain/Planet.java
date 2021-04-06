package com.example.PlanetsAndLords.Domain;

public class Planet {
    private String name;
    private String lordName;
    public Planet(){}
    public Planet(String name){
        this.name = name;
    }
    public Planet(String name, String lordName){
        this.name = name;
        this.lordName = lordName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLordName() {
        return lordName;
    }

    public void setLordName(String lordName) {
        this.lordName = lordName;
    }
}
