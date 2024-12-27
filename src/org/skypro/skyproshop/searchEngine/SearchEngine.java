package org.skypro.skyproshop.searchEngine;

import org.skypro.skyproshop.exception.BestResultNotFound;

public class SearchEngine {
    Searchable[] engine;

    public SearchEngine(int size) {
        engine = new Searchable[size];
    }

    public String[] search(String name) {
        String[] result = new String[5];
        int count = 0;
        for (Searchable searchable : engine) {
            if (searchable != null && searchable.getSearchTerm().contains(name)) {
                result[count++] = searchable.getStringRepresentation();
                if (count == 5) {
                    break;
                }
            }
        }
        return result;
    }

    public int findSpaceInEngine() {
        for (int i = 0; i < engine.length; i++) {
            if (engine[i] == null) {
                return i;
            }
        }
        return -1;
    }

    public void addSearchable(Searchable searchable) {
        int i = findSpaceInEngine();
        if (i == -1) {
            throw new ArrayIndexOutOfBoundsException("Невозможно добавить в поиск");
        }
        engine[i] = searchable;
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
