package services;
import com.fasterxml.jackson.databind.JsonNode;
import config.Connection;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import play.mvc.Http;


import javax.inject.Inject;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class VehicleService {
    @Inject Connection connection;

    public void addDocument(Http.Request request) throws IOException {
        JsonNode jsonNode = request.body().asJson();
        String userId = jsonNode.get("user_id").asText();
        String userName = jsonNode.get("user_name").asText();
        String vehicleId = jsonNode.get("vehicle_id").asText();
        String chassisNumber = jsonNode.get("chassis_number").asText();
        String modelId = jsonNode.get("model_id").asText();

        Map<String,Object> userMap = new HashMap<>();
        userMap.put("user_id", userId);
        userMap.put("user_name", userName);
        IndexRequest userIndexRequest = new IndexRequest("user", "_doc", userId).source(userMap);
        IndexResponse userIndexResponse = connection.getRestHighLevelClient().index(userIndexRequest, RequestOptions.DEFAULT);

        Map<String,Object> vehicleMap = new HashMap<>();
        vehicleMap.put("vehicle_id", vehicleId);
        vehicleMap.put("chassis_number", chassisNumber);
        vehicleMap.put("model_id", modelId);
        IndexRequest vehicleIndexRequest = new IndexRequest("vehicle","_doc", vehicleId).source(vehicleMap);
        IndexResponse vehicleIndexResponse = connection.getRestHighLevelClient().index(vehicleIndexRequest, RequestOptions.DEFAULT);
    }

    public String getByUserId(String userId) throws IOException {
        GetRequest getRequest = new GetRequest("user", "_doc",userId);
        GetResponse getResponse = connection.getRestHighLevelClient().get(getRequest, RequestOptions.DEFAULT);
        if (getResponse.isExists()) {
            String source = getResponse.getSourceAsString();
            return source;
        } else {
            return null;
        }
    }

    public String getByVehicleId(String vehicleId) throws IOException {
        GetRequest getRequest = new GetRequest("vehicle","_doc", vehicleId);
        GetResponse getResponse = connection.getRestHighLevelClient().get(getRequest, RequestOptions.DEFAULT);
        if (getResponse.isExists()) {
            String source = getResponse.getSourceAsString();
            return source;
        } else {
            return null;
        }
    }
}
