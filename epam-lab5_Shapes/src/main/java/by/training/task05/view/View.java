package by.training.task05.view;

import by.training.task05.bean.AbstractShape;
import by.training.task05.service.storage.Warehouse;
import by.training.task05.service.storage.repository.Repository;

public interface View {
    void showWarehouse(Warehouse warehouse);

    <T extends AbstractShape> void showRepository(Repository<T> repository);

    void showSize(Warehouse warehouse);

    <T extends AbstractShape> void showSize(Repository<T> repository);
}
