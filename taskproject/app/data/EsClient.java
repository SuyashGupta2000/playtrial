package data;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

public class EsClient {
    private RestHighLevelClient restHighLevelClient;

    public EsClient() {
//        restClient = RestClient.builder(
//                new HttpHost("localhost",9200,"http")
//        ).build();
//    }
        restHighLevelClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200, "http")));


    }

    public RestHighLevelClient getRestHighLevelClient() {
        return restHighLevelClient;
    }
}

      
