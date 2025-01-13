package org.skypro.skyproshop.searchEngine;

import org.skypro.skyproshop.exception.BestResultNotFound;
import java.util.*;

public class SearchEngine {
    private HashMap<String, List<Searchable>> engine = new HashMap<>();

    public void addSearchable(Searchable searchable) {
        engine.computeIfAbsent(searchable.getSearchTerm(), k -> new ArrayList<>()).add(searchable);
    }

    public List<Searchable> search(String name) {
        List<Searchable> result = new ArrayList<>();
        for (List<Searchable> searchablesList : engine.values()) {
            for (Searchable searchable : searchablesList) {
                if (searchable.getSearchTerm().contains(name)) {
                    result.add(searchable);
                }
            }
        }
        return result;
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
        for (List<Searchable> searchablesList : engine.values()) {
            for (Searchable searchable : searchablesList) {
                int count = countNumberOfMatches(searchable, search);
                if (count > maxCount) {
                    maxCount = count;
                    bestMatch = searchable;
                }
            }
        }
        if (bestMatch == null) {
            throw new BestResultNotFound("Для поискового запроса не нашлось подходящего товара/статьи");
        }
        return bestMatch;
    }
}
