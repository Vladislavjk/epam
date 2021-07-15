package by.training.task05.factory;

import by.training.task05.bean.AbstractShape;
import by.training.task05.bean.Point2D;
import by.training.task05.exception.CreateShapeException;

import java.util.List;

public interface AbstractShapeFactory<T extends AbstractShape> {
    T createShape(List<Point2D> points) throws CreateShapeException;
}
