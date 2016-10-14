package operator.utils;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.search.SearchHit;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Map;

/**
 * Created by Artyom Karnov on 10/12/16.
 * artyom-karnov@yandex.ru
 **/
@Service("SearchResult")
public class SearchResult {
    public String getResults(String str) throws UnknownHostException {
        String result = "Nothing found";
        Client client = TransportClient.builder().build()
                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("localhost"), 9300));
        SearchResponse search = client.prepareSearch("operator").setTypes("tariffs").execute().actionGet();

        for (SearchHit hit : search.getHits()) {
            Map<String, Object> searchMap = hit.getSource();
            if (searchMap.containsValue(str)) {
                result = searchMap.toString();
            }
        }
        return result;
    }
}