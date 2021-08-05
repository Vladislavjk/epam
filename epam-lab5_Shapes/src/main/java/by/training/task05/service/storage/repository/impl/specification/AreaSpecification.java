package by.training.task05.service.storage.repository.impl.specification;

import by.training.task05.bean.Triangle;
import by.training.task05.service.ShapeService;
import by.training.task05.service.constant.TriangleType;
import by.training.task05.service.impl.TriangleServiceImpl;
import by.training.task05.service.storage.repository.Specification;

public class AreaSpecification implements Specification<Triangle> {
    private double leftInterval;
    private double rightInterval;

    public AreaSpecification(double leftInterval, double rightInterval) {
        this.leftInterval = leftInterval;
        this.rightInterval = rightInterval;
    }

    @Override
    public boolean specify(Triangle triangle) {
        ShapeService<TriangleType, Triangle> service = new TriangleServiceImpl();
        double calculateArea = service.calculateArea(triangle);
        boolean result = Double.compare(calculateArea, leftInterval) >= 0 && Double.compare(calculateArea, rightInterval) <= 0;
        return result;
    }
}
