package by.training.task05.service.factory;

import by.training.task05.bean.AbstractShape;
import by.training.task05.bean.Point2D;
import by.training.task05.service.exception.CreateShapeException;

import java.util.List;

public interface AbstractShapeFactory<T extends AbstractShape> {
    T createShape(List<Point2D> points) throws CreateShapeException;
}
