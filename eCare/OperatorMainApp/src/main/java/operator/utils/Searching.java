package operator.utils;

import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.Client;
import org.elasticsearch.node.Node;
import org.elasticsearch.search.SearchHit;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.elasticsearch.index.query.QueryBuilders.fieldQuery;
import static org.elasticsearch.node.NodeBuilder.nodeBuilder;

/**
 * Created by Artyom Karnov on 10/12/16.
 * artyom-karnov@yandex.ru
 **/

public class Searching {

    public static void main(String args[]) throws IOException {

        Node node = nodeBuilder().node();
        Client client = node.client();

        client.prepareIndex("operator", "tariffs", "1")
                .setSource(putJsonDocument("Tariff: base",
                        "Price:100",
                        new Date(),
                        new String[]{"elasticsearch"},
                        "Artyom Karnov")).execute().actionGet();


        getDocument(client, "operator", "tariffs", "1");

//        updateDocument(client, "kodcucom", "article", "1", "title", "ElasticSearch: Java API");
//        updateDocument(client, "kodcucom", "article", "1", "tags", new String[]{"bigdata"});

//        getDocument(client, "kodcucom", "article", "1");
//
        searchDocument(client, "operator", "tariffs", "title", "base");
//
//        deleteDocument(client, "kodcucom", "article", "1");

        node.close();
    }

    public static Map<String, Object> putJsonDocument(String title, String content, Date postDate,
                                                      String[] tags, String author) {

        Map<String, Object> jsonDocument = new HashMap<String, Object>();

        jsonDocument.put("title", title);
        jsonDocument.put("content", content);
        jsonDocument.put("postDate", postDate);
        jsonDocument.put("tags", tags);
        jsonDocument.put("author", author);

        return jsonDocument;
    }

    public static void getDocument(Client client, String index, String type, String id) {

        GetResponse getResponse = client.prepareGet(index, type, id)
                .execute()
                .actionGet();
        Map<String, Object> source = getResponse.getSource();

        System.out.println("------------------------------");
        System.out.println("Index: " + getResponse.getIndex());
        System.out.println("Type: " + getResponse.getType());
        System.out.println("Id: " + getResponse.getId());
        System.out.println("Version: " + getResponse.getVersion());
        System.out.println(source);
        System.out.println("------------------------------");

    }

    public static void updateDocument(Client client, String index, String type,
                                      String id, String field, String newValue) {

        Map<String, Object> updateObject = new HashMap<String, Object>();
        updateObject.put(field, newValue);

        client.prepareUpdate(index, type, id)
                .setScript("ctx._source." + field + "=" + field)
                .setScriptParams(updateObject).execute().actionGet();
    }

    public static void updateDocument(Client client, String index, String type,
                                      String id, String field, String[] newValue) {

        String tags = "";
        for (String tag : newValue)
            tags += tag + ", ";

        tags = tags.substring(0, tags.length() - 2);

        Map<String, Object> updateObject = new HashMap<String, Object>();
        updateObject.put(field, tags);

        client.prepareUpdate(index, type, id)
                .setScript("ctx._source." + field + "+=" + field)
                .setScriptParams(updateObject).execute().actionGet();
    }

    public static void searchDocument(Client client, String index, String type,
                                      String field, String value) {

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
    }

    public static void deleteDocument(Client client, String index, String type, String id) {

        DeleteResponse response = client.prepareDelete(index, type, id).execute().actionGet();
        System.out.println("Information on the deleted document:");
        System.out.println("Index: " + response.getIndex());
        System.out.println("Type: " + response.getType());
        System.out.println("Id: " + response.getId());
        System.out.println("Version: " + response.getVersion());
    }
}
