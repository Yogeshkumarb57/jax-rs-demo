package com.jaxrs.utility;

import com.jaxrs.model.Article;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TheHinduSiteDataReadUtility {
    private static List<String> authors = null;
    private static List<Article> allArticles = null;

    public static void main(String[] args) {
        try {
            Document doc = Jsoup.connect("https://www.thehindu.com/archive/").get();
            Elements newsHeadlines = doc.getElementsByClass("archiveBorder");
            authors = new ArrayList<String>();
            allArticles = new ArrayList<Article>();
            boolean sizeDone = false;
            for (Element headline : newsHeadlines) {
                Elements thisYear = headline.getElementsByClass("archiveMonthList");
                for (Element thisYearList : thisYear) {
                    Elements allMonths = thisYearList.getElementsByTag("a");
                    for (Element thisMonth : allMonths) {
                        if (thisMonth.absUrl("href").toString().contains("/archive/web/")) {
                            Document thisMonthDoc = Jsoup.connect(thisMonth.absUrl("href")).get();
                            Elements tableDatas = thisMonthDoc.getElementsByClass("archiveTable");
                            for (Element tableData : tableDatas) {
                                Elements allDates = tableData.getElementsByClass("ui-state-default");
                                for (Element thisDate : allDates) {
                                    Document thisdateDoc = Jsoup.connect(thisDate.absUrl("href")).get();

                                    Elements allTitleLink = thisdateDoc.getElementsByTag("a");
                                    for (Element titleLink : allTitleLink) {
                                        if (titleLink.absUrl("href").endsWith(".ece")) {
                                            String title = titleLink.text();
                                            Document thisTitleDoc = Jsoup.connect(titleLink.absUrl("href")).get();
                                            Element authorElement = thisTitleDoc.getElementsByClass("mobile-author").first().getElementsByTag("a").first();
                                            String authorName = authorElement != null ? authorElement.text() : "unknown";
                                            if (!authors.contains(authorName)) {
                                                authors.add(authorName);
                                            }
                                            Elements allParagraphTag = thisTitleDoc.getElementsByTag("p");
                                            String description = "";
                                            for (Element thisParagraph : allParagraphTag) {
                                                description += "<p>" + thisParagraph.text() + "</p>";
                                            }
                                            Article article = new Article(authorName, title, description);
                                            allArticles.add(article);
                                            if (allArticles.size() == 10) {
                                                sizeDone = true;
                                                break;
                                            }
                                        }
                                    }
                                    if (sizeDone)
                                        break;
                                }
                                if (sizeDone)
                                    break;
                            }
                        }
                        if (sizeDone)
                            break;
                    }
                    if (sizeDone)
                        break;
                }
                if (sizeDone)
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Article> getAllArticlesByAuthor(final String autherName) {
        if (authors == null || allArticles == null) {
            main(null);
        }
        List<Article> articles = allArticles.stream().filter(article -> {
            return article.getAuthorName().equalsIgnoreCase(autherName);
        }).collect(Collectors.toList());
        return articles;
    }

    public static List<Article> getAllArticlesByTitleDesc(final String title, final String desc) {
        if (authors == null || allArticles == null) {
            main(null);
        }
        List<Article> articles = allArticles.stream().filter(article -> {
            return (article.getTitle().equalsIgnoreCase(title) || article.getDescription().equalsIgnoreCase(desc));
        }).collect(Collectors.toList());
        return articles;
    }

    public static List<String> getAllAuthors() {
        if (authors == null || allArticles == null) {
            main(null);
        }
        return authors;
    }
}
