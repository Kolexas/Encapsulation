package org.skypro.skyproshop.searchEngine;

import org.skypro.skyproshop.exception.BestResultNotFound;
import java.util.*;
import java.util.stream.Collectors;

public class SearchEngine {
    private final Set<Searchable> engine;

    public SearchEngine() {
        this.engine = new HashSet<>();
    }

    public void addSearchable(Searchable searchable) {
        engine.add(searchable);
    }

    public TreeSet<Searchable> search(String name) {
        TreeSet<Searchable> result = new TreeSet<>((o1, o2) -> {
            if (o1.getSearchTerm().length() - o2.getSearchTerm().length() != 0) {
                return Integer.compare(o2.getSearchTerm().length(), o1.getSearchTerm().length());
            }
            return o1.getSearchTerm().compareTo(o2.getSearchTerm());
        });
        engine.stream()
                .filter(searchable -> searchable.getSearchTerm().contains(name))
                .collect(Collectors.toCollection(() -> result));
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
