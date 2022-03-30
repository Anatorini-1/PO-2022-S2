import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class StringHtmlCleaner {
    public static String cleanString(String input){
        String textToClean = input;
        Document document = Jsoup.parse(textToClean);
        String textWithoutHtml = document.text();
        return textWithoutHtml;
    }
}
