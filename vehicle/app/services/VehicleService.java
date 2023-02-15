package services;



import com.fasterxml.jackson.databind.JsonNode;
import config.Connection;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import play.libs.Json;

import javax.inject.Inject;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class VehicleService {
    private final RestHighLevelClient client;

    @Inject
    public VehicleService(Connection connection) {
        this.client = connection.getRestHighLevelClient();
    }

    public void addDocument(String userId, String userName, String vehicleId, String chassisNumber, String modelId) throws IOException {
        Map<String,Object> userMap = new HashMap<>();
        userMap.put("user_id", userId);
        userMap.put("user_name", userName);
        IndexRequest userIndexRequest = new IndexRequest("user").id(userId).source(userMap);
        IndexResponse userIndexResponse = client.index(userIndexRequest, RequestOptions.DEFAULT);

        Map<String,Object> vehicleMap = new HashMap<>();
        vehicleMap.put("vehicle_id", vehicleId);
        vehicleMap.put("chassis_number", chassisNumber);
        vehicleMap.put("model_id", modelId);
        IndexRequest vehicleIndexRequest = new IndexRequest("vehicle").id(vehicleId).source(vehicleMap);
        IndexResponse vehicleIndexResponse = client.index(vehicleIndexRequest, RequestOptions.DEFAULT);
    }

    public JsonNode getByUserId(String userId) throws IOException {
        GetRequest getRequest = new GetRequest("user", "_doc",userId);
        GetResponse getResponse = client.get(getRequest, RequestOptions.DEFAULT);
        if (getResponse.isExists()) {
            String source = getResponse.getSourceAsString();
            return Json.parse(source);
        } else {
            return null;
        }
    }

    public JsonNode getByVehicleId(String vehicleId) throws IOException {
        GetRequest getRequest = new GetRequest("vehicle","_doc", vehicleId);
        GetResponse getResponse = client.get(getRequest, RequestOptions.DEFAULT);
        if (getResponse.isExists()) {
            String source = getResponse.getSourceAsString();
            return Json.parse(source);
        } else {
            return null;
        }
    }
}
