package by.training.task05.storage;

import by.training.task05.bean.TriangleData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class Warehouse {
    private static final Logger logger = LogManager.getLogger(Warehouse.class);
    private static Warehouse warehouse;
    private Map<String, TriangleData> quadrangleData;

    private Warehouse() { }

    public static Warehouse getInstance() {
        if (warehouse == null) {
            warehouse = new Warehouse();
            logger.info("Warehouse created");
        }
        return warehouse;
    }

    public Map<String, TriangleData> getQuadrangleData() {
        logger.info("Get copy of warehouse -> {}", quadrangleData);
        return new HashMap<>(quadrangleData);
    }

    public boolean contains(String quadrangleId) {
        return quadrangleData.containsKey(quadrangleId);
    }

    public TriangleData getInfoAboutQuadrangle(String quadrangleId) {
        TriangleData result = new TriangleData(quadrangleData.get(quadrangleId).getArea(), quadrangleData.get(quadrangleId).getPerimeter());
        logger.info("Info about quadrangle with id->{}, {}", quadrangleId, result);
        return result;
    }

    public void put(String quadrangleId, TriangleData data) {
        quadrangleData.put(quadrangleId, data);
        logger.info("Quadrangle's data with id->{} was put to warehouse successfully -> {}", quadrangleId, data);
    }

    @Override
    public String toString() {
        return "Warehouse{" +
                "quadrangleData=" + quadrangleData +
                '}';
    }
}
