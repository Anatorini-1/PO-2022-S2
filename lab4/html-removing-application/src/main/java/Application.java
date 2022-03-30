public class Application {
    public static void main(String[] args) {
        if(args.length > 0 && args[0].length() > 0){
            String rawHTML = PageDownloadingUtility.download(args[0]);
            System.out.println(StringHtmlCleaner.cleanString(rawHTML));
        }
        else{
            System.out.println("Niepoprawne dane wejściowe");
        }
    }
}
