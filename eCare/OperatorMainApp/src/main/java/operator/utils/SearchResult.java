package operator.utils;

import org.springframework.stereotype.Service;

/**
 * Created by Artyom Karnov on 10/12/16.
 * artyom-karnov@yandex.ru
 **/
@Service("SearchResult")
public class SearchResult {
    public String getResults(String str) {
        return str;
    }
}