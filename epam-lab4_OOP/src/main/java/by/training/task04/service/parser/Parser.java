package by.training.task04.service.parser;

import by.training.task04.bean.City;
import by.training.task04.bean.Country;
import by.training.task04.bean.Region;
import by.training.task04.service.creator.CountryCreator;
import by.training.task04.service.exception.ServiceException;
import by.training.task04.service.impl.RegionServiceImpl;
import by.training.task04.service.validator.Validator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Parser {
    private static final Logger logger = LogManager.getLogger(CountryCreator.class);
    private static final Validator validator = new Validator();

    public Parser() { }

    public Country parse(List<String> list) throws ServiceException {
        logger.info("Parsing list of file lines.");
        validator.validateList(list);

        ArrayList<City> cities = new ArrayList<>();
        //ArrayList<District> districts = new ArrayList<>();
        ArrayList<Region> regions = new ArrayList<>();
        //HashSet<String> districtsHashSet = new HashSet<>();
        HashSet<String> regionsHashSet = new HashSet<>();
        //HashMap<City, String> districtHashMap = new HashMap<>();

        for(String next : list) {
            String[] tokens = next.split(" ");
            City toAdd = new City(Double.parseDouble(tokens[0]), tokens[1], tokens[2], tokens[3]);
            cities.add(toAdd);
            //districtsHashSet.add(toAdd.getDistrict());
            regionsHashSet.add(toAdd.getRegion());
        }

        for(String next : regionsHashSet) {
            regions.add(new Region(next));
        }

        RegionServiceImpl regionService = new RegionServiceImpl();
        ArrayList<String> names = regionService.getNames(regions);
        for(City next : cities) {
            regions.get(names.indexOf(next.getRegion())).addCity(next);
        }
        return new Country(regions);
    }
}
