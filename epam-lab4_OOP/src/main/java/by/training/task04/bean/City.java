package by.training.task04.bean;

import java.io.Serializable;
import java.util.Objects;

public class City implements Entity, Serializable {
    private double area;
    private String name;
    private String partOfDistrict;
    private String partOfRegion;

    public City() { }

    public City(double area, String name, String district, String region) {
        this.area = area;
        this.name = name;
        this.partOfDistrict = district;
        this.partOfRegion = region;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return Double.compare(city.area, area) == 0 && Objects.equals(name, city.name) && Objects.equals(partOfDistrict, city.partOfDistrict) && Objects.equals(partOfRegion, city.partOfRegion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(area, name, partOfDistrict, partOfRegion);
    }

    @Override
    public String toString() {
        return "City{" +
                "area=" + area +
                ", name='" + name + '\'' +
                ", district='" + partOfDistrict + '\'' +
                ", region='" + partOfRegion + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public String getDistrict() {
        return partOfDistrict;
    }

    public void setDistrict(String district) {
        this.partOfDistrict = district;
    }

    public String getRegion() {
        return partOfRegion;
    }

    public void setRegion(String region) {
        this.partOfRegion = region;
    }
}
