package by.training.task04.service;

import by.training.task04.bean.District;
import by.training.task04.bean.Region;

import java.util.ArrayList;

public interface RegionService {
    public ArrayList<String> getNames(ArrayList<Region> regions);
}
