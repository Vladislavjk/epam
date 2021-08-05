package by.training.task05.service.storage.repository.impl.specification;

import by.training.task05.bean.Point2D;
import by.training.task05.bean.Triangle;
import by.training.task05.service.storage.repository.Specification;

import java.util.List;

public class PointInFirstQuadrantSpecification implements Specification<Triangle> {
    @Override
    public boolean specify(Triangle triangle) {
        List<Point2D> points = triangle.getPoints();
        boolean result = ((points.get(0).getX() > 0 && points.get(0).getY() > 0) && (points.get(1).getX() > 0 && points.get(1).getY() > 0)
                && (points.get(2).getX() > 0 && points.get(2).getY() > 0));
        return result;
    }
}
