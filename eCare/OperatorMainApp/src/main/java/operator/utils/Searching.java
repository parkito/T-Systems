package operator.utils;

import org.elasticsearch.client.Client;
import org.elasticsearch.node.Node;
import org.springframework.stereotype.Service;

import static org.elasticsearch.node.NodeBuilder.nodeBuilder;

/**
 * Created by Artyom Karnov on 10/13/16.
 * artyom-karnov@yandex.ru
 **/
@Service("Searching")
public class Searching {
    private Node node;
    private Client client;

    public Searching() {
        node = nodeBuilder().node();
        client = node.client();
    }
}
