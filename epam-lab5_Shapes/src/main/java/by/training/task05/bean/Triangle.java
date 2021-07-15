package by.training.task05.bean;

import by.training.task05.exception.CreateShapeException;
import by.training.task05.observer.Observable;
import by.training.task05.observer.Observer;
import by.training.task05.observer.impl.TriangleObserver;
import by.training.task05.util.IdGenerator;
import by.training.task05.validator.TriangleValidator;

import java.util.ArrayList;
import java.util.List;

public class Triangle extends AbstractShape implements Observable<Observer<Triangle>> {
    private String triangleId;
    private List<Point2D> pointsToCreate;
    private Observer<Triangle> observer;

    public Triangle(List<Point2D> pointsToCreate) {
        triangleId = IdGenerator.generateId();
        this.pointsToCreate = pointsToCreate;
        observer = new TriangleObserver();
    }

    public String getQuadrangleId() {
        return triangleId;
    }

    public void setQuadrangleId(String quadrangleId) {
        this.triangleId = quadrangleId;
    }

    public List<Point2D> getPoints() {
        return new ArrayList<>(pointsToCreate);
    }

    public void setPointsToCreate(List<Point2D> pointsToCreate) throws CreateShapeException {
        TriangleValidator validator = new TriangleValidator();
        if (!validator.isTriangle(pointsToCreate)) {  // TODO CHECK(3 sides and so on)
            throw new CreateShapeException("This points -> {} are not consist a triangle" + pointsToCreate);
        }
        this.pointsToCreate = pointsToCreate;
        notifyObserver();
    }

    @Override
    public void attachObserver(Observer<Triangle> observer) {
        if(observer != null) {
            this.observer = observer;
        }
    }

    @Override
    public void detachObserver(Observer<Triangle> observer) {
        observer = null;
    }

    @Override
    public void notifyObserver() {
        if(observer != null) {
            observer.recalculateArea(this);
            observer.recalculatePerimeter(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return pointsToCreate.equals(triangle.pointsToCreate);
    }

    @Override
    public int hashCode() {
        return pointsToCreate.hashCode() * 31;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "triangleId='" + triangleId + '\'' +
                ", pointsToCreate=" + pointsToCreate +
                '}';
    }
}
