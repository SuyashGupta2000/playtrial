package controllers;


import data.RestClient;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import java.sql.SQLException;


public class CountryController extends Controller {

    @Inject
    private RestClient restClient;

    public CountryController() {
    }
    public Result getCountry() throws SQLException {


        return ok(restClient.getMap().toString());
    }
}
