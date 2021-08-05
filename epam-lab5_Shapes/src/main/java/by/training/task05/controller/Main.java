package by.training.task05.controller;

import by.training.task05.bean.Point2D;
import by.training.task05.bean.Triangle;
import by.training.task05.bean.TriangleData;
import by.training.task05.dao.DaoException;
import by.training.task05.dao.Reader;
import by.training.task05.service.ShapeService;
import by.training.task05.service.constant.TriangleType;
import by.training.task05.service.exception.CreateShapeException;
import by.training.task05.service.exception.ParseException;
import by.training.task05.service.factory.AbstractShapeFactory;
import by.training.task05.service.factory.impl.TriangleFactory;
import by.training.task05.service.impl.TriangleServiceImpl;
import by.training.task05.service.parser.TriangleParser;
import by.training.task05.service.storage.Warehouse;
import by.training.task05.service.storage.repository.Repository;
import by.training.task05.service.storage.repository.impl.TriangleRepository;
import by.training.task05.service.validator.ToCreateTriangleValidator;
import by.training.task05.view.ViewImpl;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws ParseException, DaoException, CreateShapeException {  // TODO main with throws is bad(try..)
        Reader reader = new Reader();
        ViewImpl viewImpl = new ViewImpl();

        List<String> lines =  reader.read("input_files/triangles_input.txt");  // TODO ASK USER OR CONSTANT OR IN READER

        TriangleParser parser = new TriangleParser();

        ToCreateTriangleValidator validator = new ToCreateTriangleValidator();

        lines = validator.validate(lines);

        List<List<Point2D>> objects = new ArrayList<>();

        for (String line : lines) {
            List<Point2D> points = parser.parseValidPointsToCreate(line);
            objects.add(points);
        }

        AbstractShapeFactory<Triangle> triangleFactory = TriangleFactory.getInstance();

        Repository<Triangle> triangleRepository = TriangleRepository.getInstance();

        for (int i = 0; i < objects.size(); i++) {
            triangleRepository.add(triangleFactory.createShape(objects.get(i)));  // TODO КАК-ТО НАДО ЭТО В ОТДЕЛЬНЫЕ МЕТОДЫ РАСКИДАТЬ
        }

        ShapeService<TriangleType, Triangle> shapeService = new TriangleServiceImpl();


        Warehouse warehouseTriangleData = Warehouse.getInstance();
        for (int i = 0; i < triangleRepository.getSize(); i++) {
            warehouseTriangleData.put(triangleRepository.get(i).getTriangleId(), new TriangleData(shapeService.calculateArea(triangleRepository.get(i)), shapeService.calculatePerimeter(triangleRepository.get(i))));
        }

        viewImpl.showWarehouse(warehouseTriangleData);
        viewImpl.showRepository(triangleRepository);
        viewImpl.showSize(triangleRepository);
        //System.out.println(warehouseTriangleData.getTriangleData().get(triangleRepository.get(0)));
    }
}
