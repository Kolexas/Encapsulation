package SearchEngine;

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
        return getArticleName() + "\n " + getArticleContent();
    }

    @Override
    public String getSearchTerm() {
        return getArticleName() + " " + getArticleContent();
    }

    @Override
    public String getTypeOfContent() {
        return "ARTICLE";
    }
}