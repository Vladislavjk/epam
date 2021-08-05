package by.training.task05.service.storage.repository.impl.specification;

import by.training.task05.bean.Triangle;
import by.training.task05.service.ShapeService;
import by.training.task05.service.constant.TriangleType;
import by.training.task05.service.impl.TriangleServiceImpl;
import by.training.task05.service.storage.repository.Specification;

public class PerimeterSpecification implements Specification<Triangle> {
    private double leftInterval;
    private double rightInterval;

    public PerimeterSpecification(double leftInterval, double rightInterval) {
        this.leftInterval = leftInterval;
        this.rightInterval = rightInterval;
    }

    @Override
    public boolean specify(Triangle triangle) {
        ShapeService<TriangleType, Triangle> service = new TriangleServiceImpl();
        double calculatePerimeter = service.calculatePerimeter(triangle);
        boolean result = Double.compare(calculatePerimeter, leftInterval) >= 0 && Double.compare(calculatePerimeter, rightInterval) <= 0;
        return result;
    }
}
