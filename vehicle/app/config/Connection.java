package config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

public class Connection {
    private RestHighLevelClient restHighLevelClient;

    public Connection() {
        restHighLevelClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200, "http")));
    }

    public RestHighLevelClient getRestHighLevelClient() {
        return restHighLevelClient;
    }
}
