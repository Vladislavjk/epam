package by.training.task05.view;

import by.training.task05.bean.AbstractShape;
import by.training.task05.service.storage.Warehouse;
import by.training.task05.service.storage.repository.Repository;

public class ViewImpl implements View {
    @Override
    public void showWarehouse(Warehouse warehouse) {
        System.out.println(warehouse);
    }

    @Override
    public <T extends AbstractShape> void showRepository(Repository<T> repository) {
        System.out.println(repository);
    }

    @Override
    public void showSize(Warehouse warehouse) {
        System.out.println(warehouse.getTriangleData().size());
    }

    @Override
    public <T extends AbstractShape> void showSize(Repository<T> repository) {
        System.out.println(repository.getSize());
    }
}
