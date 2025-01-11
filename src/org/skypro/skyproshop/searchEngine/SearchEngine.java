package org.skypro.skyproshop.searchEngine;

import org.skypro.skyproshop.exception.BestResultNotFound;
import org.skypro.skyproshop.product.Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class SearchEngine {
    List<Searchable> engine = new ArrayList<>();

    public List<Searchable> search(String name) {
        List<Searchable> result = new ArrayList<>();
        Iterator<Searchable> iterator = engine.iterator();
        while (iterator.hasNext()) {
            Searchable element = iterator.next();
            if (element.getSearchTerm().contains(name)) {
                result.add(element);
            }
        }
        return result;
    }

    public void addSearchable(Searchable searchable) {
        engine.add(searchable);
    }

    private int countNumberOfMatches(Searchable searchable, String search) {
        if (searchable == null || search == null || search.isEmpty()) {
            return 0;
        }
        String text = searchable.getSearchTerm();
        int count = 0;
        int index = 0;
        int substringIndex = text.indexOf(search, index);
        while (substringIndex != -1) {
            count++;
            index += search.length();
            substringIndex = text.indexOf(search, index);
        }
        return count;
    }

    public Searchable findBestMatch(String search) throws BestResultNotFound {
        Searchable bestMatch = null;
        int maxCount = 0;
        for (Searchable searchable : engine) {
            int count = countNumberOfMatches(searchable, search);
            if (count > maxCount) {
                maxCount = count;
                bestMatch = searchable;
            }
        }
        if (bestMatch == null) {
            throw new BestResultNotFound("Для поискового запроса не нашлось подходящего товара/статьи");
        }
        return bestMatch;
    }
}
