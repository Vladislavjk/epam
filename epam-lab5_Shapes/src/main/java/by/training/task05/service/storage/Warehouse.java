package by.training.task05.service.storage;

import by.training.task05.bean.TriangleData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class Warehouse {
    private static final Logger logger = LogManager.getLogger(Warehouse.class);
    private static Warehouse warehouse;
    private Map<String, TriangleData> triangleData;

    private Warehouse() {
        triangleData = new HashMap<>();
    }

    public static Warehouse getInstance() {
        if (warehouse == null) {
            warehouse = new Warehouse();
            logger.info("Warehouse created");
        }
        return warehouse;
    }

    public Map<String, TriangleData> getTriangleData() {
        logger.info("Get copy of warehouse -> {}", triangleData);
        return new HashMap<>(triangleData);
    }

    public boolean contains(String triangleId) {
        return triangleData.containsKey(triangleId);
    }

    public TriangleData getInfoAboutTriangle(String triangleId) {
        TriangleData result = new TriangleData(triangleData.get(triangleId).getArea(), triangleData.get(triangleId).getPerimeter());
        logger.info("Info about triangle with id->{}, {}", triangleId, result);
        return result;
    }

    public void put(String triangleId, TriangleData data) {
        triangleData.put(triangleId, data);
        logger.info("Triangle's data with id->{} was put to warehouse successfully -> {}", triangleId, data);
    }

    @Override
    public String toString() {
        return "Warehouse{" +
                "triangleData=" + triangleData +
                '}';
    }
}
