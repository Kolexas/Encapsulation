package org.skypro.skyproshop.searchEngine;

public interface Searchable {
    String getSearchTerm();

    String getTypeOfContent();

    default String getStringRepresentation() {
        return "имя " + getSearchTerm() + " тип " + getTypeOfContent();
    }
}
