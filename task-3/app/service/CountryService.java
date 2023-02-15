package service;

import data.CountryData;

import java.sql.SQLException;
import java.util.Map;

public class CountryService {
    private CountryData countryData;

    public CountryService() throws SQLException {
        countryData = new CountryData();
    }

    public Map<Integer, String> getCountryMap() throws SQLException {
        return countryData.getCountryMap();
    }
}
