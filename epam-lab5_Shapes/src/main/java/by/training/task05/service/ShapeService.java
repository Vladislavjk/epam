package by.training.task05.service;

import by.training.task05.bean.AbstractShape;

public interface ShapeService <C, T extends AbstractShape> {
    double calculatePerimeter(T shape);

    double calculateArea(T shape);

    C identifyType(T shape);
}
