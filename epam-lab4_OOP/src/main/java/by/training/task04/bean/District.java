package by.training.task04.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class District implements Entity, Serializable {
    private double area;
    private String name;
    private ArrayList<City> cities;

    public District() { }

    public District(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        District district = (District) o;
        return Double.compare(district.area, area) == 0 && Objects.equals(name, district.name) && Objects.equals(cities, district.cities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(area, name, cities);
    }

    @Override
    public String toString() {
        return "District{" +
                "area=" + area +
                ", name='" + name + '\'' +
                ", cities=" + cities +
                '}';
    }

    private double getTotalArea(ArrayList<City> cities) {
        double totalArea = 0;
        for(City next : cities) {
            totalArea += next.getArea();
        }
        return totalArea;
    }

    public District(String name, ArrayList<City> cities) {
        this.area = getTotalArea(cities);
        this.cities = cities;
        this.name = name;
    }

    public double getArea() {
        return area;
    }

    public void addCity(City city) {
        cities.add(city);
        area += city.getArea();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<City> getCities() {
        return cities;
    }

    public void setCities(ArrayList<City> cities) {
        this.cities = cities;
    }

    public int amountOfCities() {
        return cities.size();
    }
}
