package by.training.task04.bean;

import by.training.task04.bean.District;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Region implements Entity, Serializable {
    private double area;
    private ArrayList<City> cities = new ArrayList<>();
    private String name;

    public Region() { }

    public Region(String name) {
        this.name = name;
    }

    private double getTotalArea(ArrayList<City> cities) {
        double totalArea = 0;
        for(City next : cities) {
            totalArea += next.getArea();
        }
        return totalArea;
    }

    public Region(ArrayList<City> cities, String name) {
        this.area = getTotalArea(cities);
        this.cities = cities;
        this.name = name;
    }

    public double getArea() {
        return area;
    }

    public int amountOfDistricts() {
        return cities.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Region region = (Region) o;
        return Double.compare(region.area, area) == 0 && Objects.equals(cities, region.cities) && Objects.equals(name, region.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(area, cities, name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Region{" +
                "area=" + area +
                ", districts=" + cities +
                ", name='" + name + '\'' +
                '}';
    }

    public void addCity(City city) {
        cities.add(city);
        area += city.getArea();
    }
}
