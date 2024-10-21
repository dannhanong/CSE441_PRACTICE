package com.ktpm1.prac03;

import java.io.Serializable;

public class Country implements Serializable {
    private String name;
    private String capital;
    private long population;
    private double area;
    private double density;
    private double worldShare;

    public Country() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWorldShare() {
        return worldShare;
    }

    public Country(String name, String capital, long population, double area, double density, double worldShare) {
        this.name = name;
        this.capital = capital;
        this.population = population;
        this.area = area;
        this.density = density;
        this.worldShare = worldShare;
    }

    public void setWorldShare(double worldShare) {
        this.worldShare = worldShare;
    }

    public double getDensity() {
        return density;
    }

    public void setDensity(double density) {
        this.density = density;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }
}

