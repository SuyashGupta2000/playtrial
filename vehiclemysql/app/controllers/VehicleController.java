package controllers;

import com.google.inject.Inject;
import play.mvc.Http;
import play.mvc.Result;
import services.VehicleService;

import java.io.IOException;
import java.sql.SQLException;

import static play.mvc.Results.ok;


public class VehicleController {

    @Inject
    private VehicleService vehicleService;
    public Result addDocument(Http.Request request) throws SQLException, IOException {
        vehicleService.addDocument(request);
        return ok("Data Inserted");
    }

    public Result getByUserId(int id) throws SQLException {
        String result = vehicleService.getByUserId(id);
        return ok(result);
    }

}
