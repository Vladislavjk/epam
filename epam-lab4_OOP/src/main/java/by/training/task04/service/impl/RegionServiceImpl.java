package by.training.task04.service.impl;

import by.training.task04.bean.Region;
import by.training.task04.service.RegionService;

import java.util.ArrayList;

public class RegionServiceImpl implements RegionService {
    /**
     * Get names of regions from ArrayList<Region>
     * @param regions
     * @returns ArrayList<String> with names of regions
     */
    @Override
    public ArrayList<String> getNames(ArrayList<Region> regions) {
        ArrayList<String> names = new ArrayList<>();
        for(Region next : regions) {
            names.add(next.getName());
        }
        return names;
        //districts.stream().forEach(District::getName);
    }
}
