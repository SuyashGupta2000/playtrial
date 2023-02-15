package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import services.VehicleService;

import javax.inject.Inject;
import java.io.IOException;

public class VehicleController extends Controller {
    private final VehicleService vehicleService;

    @Inject
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    public Result addDocument(Http.Request request) throws IOException {
        JsonNode jsonNode = request.body().asJson();
        String userId = jsonNode.get("user_id").asText();
        String userName = jsonNode.get("user_name").asText();
        String vehicleId = jsonNode.get("vehicle_id").asText();
        String chassisNumber = jsonNode.get("chassis_number").asText();
        String modelId = jsonNode.get("model_id").asText();
        vehicleService.addDocument(userId, userName, vehicleId, chassisNumber, modelId);
        return ok("Data inserted");
    }

    public Result getByUserId(String userId) throws IOException {
        JsonNode result = vehicleService.getByUserId(userId);
        if (result == null) {
            return notFound("Document not found");
        }
        return ok(result);
    }
    public Result getByVehicleId(String vehicleId) throws IOException {
        JsonNode result = vehicleService.getByUserId(vehicleId);
        if (result == null) {
            return notFound("Document not found");
        }
        return ok(result);
    }
}

//import com.fasterxml.jackson.databind.JsonNode;
//import config.Connection;
//import org.elasticsearch.action.get.GetRequest;
//import org.elasticsearch.action.get.GetResponse;
//import org.elasticsearch.action.index.IndexRequest;
//import org.elasticsearch.action.index.IndexResponse;
//import org.elasticsearch.client.RequestOptions;
//import play.libs.Json;
//import play.mvc.Controller;
//import play.mvc.Http;
//import play.mvc.Result;
//
//import javax.inject.Inject;
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Map;
//
//public class VehicleController extends Controller {
//    @Inject
//    private Connection connection;
//
//    public VehicleController() {
//    }
//    public Result addDocument(Http.Request request) throws IOException {
//        JsonNode jsonNode = request.body().asJson();
//        String user_id = jsonNode.get("user_id").asText();
//        String user_name = jsonNode.get("user_name").asText();
//        String vehicle_id = jsonNode.get("vehicle_id").asText();
//        String chassis_number = jsonNode.get("chassis_number").asText();
//        String model_id = jsonNode.get("model_id").asText();
//        Map<String,Object> map1 = new HashMap<>();
//        map1.put("user_id",user_id);
//        map1.put("user_name",user_name);
//        Map<String,Object> map2 = new HashMap<>();
//        map2.put("vehicle_id",vehicle_id);
//        map2.put("chassis_number",chassis_number);
//        map2.put("model_id",model_id);
//        IndexRequest indexRequest1 = new IndexRequest("user","_doc",user_id).source(map1);
//        IndexRequest indexRequest2 = new IndexRequest("vehicle","_doc",vehicle_id).source(map2);
//        IndexResponse indexResponse1 = connection.getRestHighLevelClient().index(indexRequest1, RequestOptions.DEFAULT);
//        IndexResponse indexResponse2 = connection.getRestHighLevelClient().index(indexRequest2, RequestOptions.DEFAULT);
//        return ok("Data inserted");
//    }
//
//    public Result getByUserId(String user_id) throws IOException {
//        GetRequest getRequest = new GetRequest("user", "_doc", user_id);
//        GetResponse getResponse = connection.getRestHighLevelClient().get(getRequest, RequestOptions.DEFAULT);
//        if (getResponse.isExists()) {
//            String source = getResponse.getSourceAsString();
//            return ok(Json.parse(source));
//        } else {
//            return notFound("Document not found");
//        }
//    }
//
//    public Result getByVehicleId(String vehicle_id) throws IOException {
//        GetRequest getRequest = new GetRequest("vehicle", "_doc", vehicle_id);
//        GetResponse getResponse = connection.getRestHighLevelClient().get(getRequest, RequestOptions.DEFAULT);
//        if (getResponse.isExists()) {
//            String source = getResponse.getSourceAsString();
//            return ok(Json.parse(source));
//        } else {
//            return notFound("Document not found");
//        }
//    }

//}

