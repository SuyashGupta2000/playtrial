package controllers;

import play.api.libs.json.Json;
import play.mvc.Controller;
import play.mvc.Result;
import service.CountryService;

import javax.inject.Inject;


public class CountryController extends Controller {

    private final CountryService countryService;

    @Inject
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    public Result getCountries() {
        List<Country> countries = countryService.getCountries();
        Result ok = ok(Json.toJson(countries));
    }
}

