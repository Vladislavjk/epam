package by.training.task05.factory.impl;

import by.training.task05.bean.Point2D;
import by.training.task05.bean.Triangle;
import by.training.task05.service.exception.CreateShapeException;
import by.training.task05.service.factory.AbstractShapeFactory;
import by.training.task05.service.factory.impl.TriangleFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.assertEquals;

public class TriangleFactoryTest {
    static AbstractShapeFactory<Triangle> shapeFactory;


    @BeforeClass
    public static void initialize() {
        shapeFactory = TriangleFactory.getInstance();
    }

    @Test
    public void createQuadrangleTest() throws CreateShapeException {
        Triangle quadrangleUsualCase = new Triangle(Arrays.asList(new Point2D(3, 3), new Point2D(3, 7), new Point2D(7, 7)));
        Triangle quadrangleFromFactory = shapeFactory.createShape(Arrays.asList(new Point2D(3, 3), new Point2D(3, 7), new Point2D(7, 7)));
        assertEquals(quadrangleFromFactory, quadrangleUsualCase);
    }

    @AfterClass
    public static void clear() {
        shapeFactory = null;
    }
}
