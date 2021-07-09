package by.training.task04.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Country implements Entity, Serializable { // TODO construct - set/get
    private double area;
    private ArrayList<Region> regions;

    public Country() { }

    public double getArea() {
        return area;
    }

    public ArrayList<Region> getRegions() {
        return regions;
    }

    public void setRegions(ArrayList<Region> regions) {
        this.regions = regions;
    }

    private double getTotalArea(ArrayList<Region> regions) {
        double totalArea = 0;
        for(Region next : regions) {
            totalArea += next.getArea();
        }
        return totalArea;
    }

    public Country(ArrayList<Region> regions) {
        this.area = getTotalArea(regions);
        this.regions = regions;
    }

    public void addRegion(Region region) {
        regions.add(region);
        area += region.getArea();
    }

    public int amountOfRegions() {
        return regions.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return Double.compare(country.area, area) == 0 && Objects.equals(regions, country.regions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(area, regions);
    }

    @Override
    public String toString() {
        return "Country{" +
                "area=" + area +
                ", regions=" + regions +
                '}';
    }
}
