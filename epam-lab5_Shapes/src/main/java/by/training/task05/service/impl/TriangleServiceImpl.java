package by.training.task05.service.impl;

import by.training.task05.bean.Point2D;
import by.training.task05.bean.Triangle;
import by.training.task05.constant.TriangleType;
import by.training.task05.service.TriangleService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class TriangleServiceImpl implements TriangleService {
    private static final Logger logger = LogManager.getLogger(TriangleServiceImpl.class);

    @Override
    public double calculatePerimeter(Triangle triangle) {
        return 0;
    }

    @Override
    public double calculateArea(Triangle triangle) {
        return 0;
    }

    @Override
    public TriangleType identifyType(Triangle triangle) {
        return null;
    }

    private List<Double> getSides(Triangle triangle) {
        List<Double> sides = new ArrayList<>();
        List<Point2D> points = triangle.getPoints();
        sides.add(Math.hypot((points.get(0).getX() - points.get(1).getX()), (points.get(0).getY() - points.get(1).getY())));
        sides.add(Math.hypot((points.get(0).getX() - points.get(2).getX()), (points.get(0).getY() - points.get(2).getY())));
        sides.add(Math.hypot((points.get(1).getX() - points.get(2).getX()), (points.get(1).getY() - points.get(2).getY())));
        return sides;
    }
}
