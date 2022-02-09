import java.io.*;
import java.util.*;


public class PA7Tester {
    public static void main(String[] args) throws IOException {
        testRemovePunc();
        testSmallDataset();
        testRemoveStopWords();
        String[] list = {"the", "jungle", "book", "is", "fantastic", "movie", "its", "the", "best"};
        Predictor predictor = new Predictor();
        ArrayList<String> words = new ArrayList<>();
        Collections.addAll(words, list);

    }

    public static void testRemoveStopWords() throws IOException {
        String[] list = {"the", "jungle", "book", "is", "fantastic", "movie", "its", "the", "best"};
        Predictor predictor = new Predictor();
        ArrayList<String> words = new ArrayList<>();
        Collections.addAll(words, list);
        predictor.createStopWordsSet("stopwords.txt");
        ArrayList<String> cleaned = predictor.removeStopWords(words);


        System.out.println("Words without stop words:");
        System.out.println(cleaned);
    }

    public static void testRemovePunc() {
        String[] list = {"Thi*s", "sen^tence,", "ha?s", "many%", "puncs?"};

        Predictor predictor = new Predictor();
        ArrayList<String> words = new ArrayList<>();
        Collections.addAll(words, list);
        ArrayList<String> cleaned = predictor.removePunctuation(words);

        System.out.println("Words without punctuations:");
        System.out.println(cleaned);
    }

    public static void testSmallDataset() throws IOException {
        Predictor predictor = new Predictor();
        predictor.createStopWordsSet("stopwords.txt");

        System.out.println(predictor.getStopWords().size());

        predictor.cleanData("rawReviewRatings.txt", "cleanReviewRatings.txt",
                true);
        predictor.updateHashMap("cleanReviewRatings.txt");

        // Map print
        for (String key : predictor.getWordFreqMap().keySet()){
            System.out.println(key + ' ' + Arrays.toString(predictor.getWordFreqMap().get(key)));
        }

        predictor.cleanData("rawReviews.txt", "cleanReviews.txt", false);
        predictor.rateReviews("cleanReviews.txt", "ratings.txt");
    }

    // Feel free to add more testers

}