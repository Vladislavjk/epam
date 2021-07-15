package by.training.task05.bean;

public class TriangleData {
    private double area;
    private double perimeter;

    public TriangleData(double area, double perimeter) {
        this.area = area;
        this.perimeter = perimeter;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TriangleData that = (TriangleData) o;
        return Double.compare(that.area, area) == 0 && Double.compare(that.perimeter, perimeter) == 0;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(perimeter) * 31 + Double.hashCode(area);
    }

    @Override
    public String toString() {
        return "TriangleData{" +
                "area=" + area +
                ", perimeter=" + perimeter +
                '}';
    }
}
