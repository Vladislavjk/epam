package by.training.task05.service.storage.repository.impl;

import by.training.task05.bean.Triangle;
import by.training.task05.service.storage.repository.Repository;
import by.training.task05.service.storage.repository.Specification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TriangleRepository implements Repository<Triangle> {

    private static final Logger logger = LogManager.getLogger(TriangleRepository.class);

    private static TriangleRepository triangleRepository;
    private List<Triangle> triangles;

    private TriangleRepository() {
        triangles = new ArrayList<>();
    }

    public static TriangleRepository getInstance() {
        if (triangleRepository == null) {
            triangleRepository = new TriangleRepository();
        }
        return triangleRepository;
    }

    @Override
    public void add(Triangle triangle) {
        triangles.add(triangle);
        logger.info("Triangle added to repository {}", triangle);
    }

    @Override
    public void addAll(List<Triangle> shapes) {
        triangles.addAll(shapes);
        logger.info("Triangles added to repository {}", triangles);
    }

    @Override
    public void remove(Triangle triangle) {
        triangles.remove(triangle);
        logger.info("Triangle {} removed from repository", triangle);
    }

    @Override
    public Triangle get(int index) {
        logger.info("Triangle received {}", triangles.get(index));
        return triangles.get(index);
    }

    @Override
    public int getSize() {
        return triangles.size();
    }

    @Override
    public List<Triangle> sort(Comparator<? super Triangle> comparator) {
        List<Triangle> result = triangles.stream().sorted(comparator).collect(Collectors.toList());
        logger.info("Triangles sorted in accordance to the condition -> {}", result);
        return result;
    }

    public List<Triangle> query(Specification<Triangle> specification) {
        List<Triangle> result = triangles.stream().filter(specification::specify).collect(Collectors.toList());
        logger.info("Triangles filtered in accordance to the specification -> {}", result);
        return result;
    }

    @Override
    public String toString() {
        return "TriangleRepository{" +
                "triangles=" + triangles +
                '}';
    }
}
