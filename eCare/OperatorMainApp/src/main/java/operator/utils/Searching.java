package operator.utils;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.Client;
import org.elasticsearch.node.Node;
import org.elasticsearch.search.SearchHit;
import org.springframework.stereotype.Service;

import javax.xml.ws.soap.Addressing;
import java.util.Map;

import static org.elasticsearch.index.query.QueryBuilders.fieldQuery;
import static org.elasticsearch.node.NodeBuilder.nodeBuilder;

/**
 * Created by Artyom Karnov on 10/13/16.
 * artyom-karnov@yandex.ru
 **/
public class Searching {
    private Node node;
    private Client client;

    public Searching() {
        node = nodeBuilder().node();
        client = node.client();
    }

    public String searchDocument(
            String value) {
        String index = "operator";
        String type = "article";
        String field = "title";

        SearchResponse response = client.prepareSearch(index)
                .setTypes(type)
                .setSearchType(SearchType.QUERY_AND_FETCH)
                .setQuery(fieldQuery(field, value))
                .setFrom(0).setSize(60).setExplain(true)
                .execute()
                .actionGet();

        SearchHit[] results = response.getHits().getHits();

        System.out.println("Current results: " + results.length);
        for (SearchHit hit : results) {
            System.out.println("------------------------------");
            Map<String, Object> result = hit.getSource();
            System.out.println(result);
        }
        return value;
    }
}
