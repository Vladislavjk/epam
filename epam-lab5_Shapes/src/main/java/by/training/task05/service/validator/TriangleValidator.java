package by.training.task05.service.validator;

import by.training.task05.bean.Point2D;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class TriangleValidator {
    private static final Logger logger = LogManager.getLogger(TriangleValidator.class);

    public boolean isTriangle(List<Point2D> points2D) {
        boolean flag = false;
        double side1 = Math.hypot((points2D.get(0).getX() - points2D.get(1).getX()), (points2D.get(0).getY() - points2D.get(1).getY()));
        double side2 = Math.hypot((points2D.get(1).getX() - points2D.get(2).getX()), (points2D.get(1).getY() - points2D.get(2).getY()));
        double side3 = Math.hypot((points2D.get(0).getX() - points2D.get(2).getX()), (points2D.get(0).getY() - points2D.get(2).getY()));
        if ((side1 + side2) > side3 && (side1 + side3) > side2 && (side2 + side3) > side1) {
            flag = true;
            logger.info("These points -> {} represent a triangle", points2D);
        } else {
            logger.error("These points -> {} don't represent a triangle", points2D);
        }
        return flag;
    }
}
