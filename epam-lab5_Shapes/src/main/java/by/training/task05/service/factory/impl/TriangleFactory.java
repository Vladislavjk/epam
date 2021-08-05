package by.training.task05.service.factory.impl;

import by.training.task05.bean.Point2D;
import by.training.task05.bean.Triangle;
import by.training.task05.service.exception.CreateShapeException;
import by.training.task05.service.factory.AbstractShapeFactory;
import by.training.task05.service.validator.TriangleValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class TriangleFactory implements AbstractShapeFactory<Triangle> {  // TODO CHECK IF SINGLETON NEEDED(OTHER REALIZATIONS)
    private static final Logger logger = LogManager.getLogger();
    private static TriangleFactory factory;

    private TriangleFactory() {

    }

    public static TriangleFactory getInstance() {
        if (factory == null) {
            factory = new TriangleFactory();
            logger.info("Factory created");
        }
        return factory;
    }

    @Override
    public Triangle createShape(List<Point2D> points) throws CreateShapeException {
        TriangleValidator validator = new TriangleValidator();
        if (!validator.isTriangle(points)) {
            throw new CreateShapeException("This points are not represent a triangle -> " + points);
        }
        Triangle triangle = new Triangle(points);
        logger.info("Triangle -> {} was create", triangle);
        return triangle;
    }
}
