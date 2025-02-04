package org.skypro.skyproshop;

import org.skypro.skyproshop.searchEngine.Searchable;
import java.util.Objects;

public class Article implements Searchable {
    private String articleName;
    private String articleContent;

    public Article(String articleName, String articleContent) {
        this.articleContent = articleContent;
        this.articleName = articleName;
    }

    public String getArticleName() {
        return articleName;
    }

    public String getArticleContent() {
        return articleContent;
    }

    @Override
    public String toString() {
        return getArticleName() + " " + getArticleContent();
    }

    @Override
    public String getSearchTerm() {
        return getArticleName() + " " + getArticleContent();
    }

    @Override
    public String getTypeOfContent() {
        return "ARTICLE";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Article article)) return false;
        return Objects.equals(articleName, article.articleName);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(articleName);
    }

}
