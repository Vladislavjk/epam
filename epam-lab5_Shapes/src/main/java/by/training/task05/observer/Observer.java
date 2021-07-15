package by.training.task05.observer;

import by.training.task05.bean.AbstractShape;

public interface Observer<T extends AbstractShape> {
    void recalculatePerimeter(T shape);

    void recalculateArea(T shape);
}
