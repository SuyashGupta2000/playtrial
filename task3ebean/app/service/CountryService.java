package service;

import play.db.ebean.EbeanConfig;
import play.db.ebean.EbeanDynamicEvolutions;
import javax.inject.Inject;
import java.util.List;

public class CountryService {

    private final EbeanConfig ebeanConfig;
    private final EbeanDynamicEvolutions ebeanDynamicEvolutions;
    private List<Country> countries;

    @Inject
    public CountryService(EbeanConfig ebeanConfig, EbeanDynamicEvolutions ebeanDynamicEvolutions) {
        this.ebeanConfig = ebeanConfig;
        this.ebeanDynamicEvolutions = ebeanDynamicEvolutions;
        this.countries = getAllCountries();
    }

    private List<Country> getAllCountries() {
        return Ebean.find(Country.class).findList();
    }

    public List<Country> getCountries() {
        return countries;
    }
}

