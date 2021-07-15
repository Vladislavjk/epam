package by.training.task05.factory.impl;

import by.training.task05.bean.Point2D;
import by.training.task05.bean.Triangle;
import by.training.task05.exception.CreateShapeException;
import by.training.task05.factory.AbstractShapeFactory;

import java.util.List;

public class TriangleFactory implements AbstractShapeFactory<Triangle> {
    @Override
    public Triangle createShape(List<Point2D> points) throws CreateShapeException {
        return null;
    }
}
