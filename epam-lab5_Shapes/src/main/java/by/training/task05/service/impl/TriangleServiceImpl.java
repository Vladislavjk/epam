package by.training.task05.service.impl;

import by.training.task05.bean.Point2D;
import by.training.task05.bean.Triangle;
import by.training.task05.service.constant.TriangleType;
import by.training.task05.service.TriangleService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class TriangleServiceImpl implements TriangleService {
    private static final Logger logger = LogManager.getLogger(TriangleServiceImpl.class);

    @Override
    public double calculatePerimeter(Triangle triangle) {
        List<Double> sides = getSides(triangle);
        double perimeter = sides.stream().mapToDouble(Double::doubleValue).sum(); // TODO ??
        logger.info("Triangle -> {},\t perimeter -> {}", triangle, perimeter);
        return perimeter;
    }

    @Override
    public double calculateArea(Triangle triangle) {
        List<Double> sides = getSides(triangle);
        double triangleHalfPerimeter = calculatePerimeter(triangle) / 2.;
        double area = Math.sqrt(triangleHalfPerimeter * (triangleHalfPerimeter - sides.get(0)) * (triangleHalfPerimeter - sides.get(1)) * (triangleHalfPerimeter - sides.get(2)));
        logger.info("Triangle -> {},\t area -> {}", triangle, area);
        return area;
    }

    @Override
    public TriangleType identifyType(Triangle triangle) { // TODO ideally we count 3 angles
        List<Double> sides = getSides(triangle);
        TriangleType triangleType = TriangleType.NOT_DEFINED;
        return triangleType;
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
