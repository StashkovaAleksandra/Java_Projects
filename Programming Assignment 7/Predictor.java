// Title:             Rating Predictor
// Files:              Predictor.java, rawReviewRatings.txt, rawReviews.txt, stopwords.txt, PA7Tester.java
// Quarter:            CSE 8B Spring 2021
//
// Author:             Aleksandra Stashkova
// Email:              astashko@ucsd.edu
// Instructor's Name:  Haytham Allos
import java.io.*;
import java.util.*;

/**
 * This class implements the functionality of a rating predictor. It contains multiple methods that cleans the data,
 * write the cleaned data to new files, fit on the cleaned data with ratings to learn how to make predictions,
 * and predict ratings on unlabeled cleaned data.
 *
 * Bugs: none
 *
 * @author Aleksandra Stashkova
 */
public class Predictor {
    private HashMap<String, int[]> wordFreqMap;
    private HashSet<String> stopWords;

    /**
     * public constructor that initialize member variables with empty 
     * collections.
     */
    public Predictor() {
        this.wordFreqMap = new HashMap<>();
        this.stopWords = new HashSet<>();
    }

    /**
     * Getter that returns wordFreqMap
     * @return the instance variable wordFreqMap
     */
    public HashMap<String, int[]> getWordFreqMap() {
        return this.wordFreqMap;
    }

    /**
     * Getter that returns stopWords
     * @return the instance variable stopWords
     */
    public HashSet<String> getStopWords() {
        return this.stopWords;
    }

    /**
     * Setter that sets wordFreqMap
     * @param map the new wordFreqMap to be assigned
     */
    public void setWordFreqMap(HashMap<String, int[]> map) {
        this.wordFreqMap = map;
    }

    /**
     * Setter that sets stopWords
     * @param stopWords the new stopWords to be assigned
     */
    public void setStopWords(HashSet<String> stopWords) {
        this.stopWords = stopWords;
    }

    /**
     * This method takes in a filename and read its contents to the HashSet 
     * instance variable this.stopwords.
     * 
     * @param inFile the filename to be read
     * @throws IOException
     */
    public void createStopWordsSet(String inFile) throws IOException{
        Scanner scnr = new Scanner(new File(inFile));

        // iterate over all lines and each line contain a single word
        while (scnr.hasNextLine()) {
            String data = scnr.nextLine();
            this.stopWords.add(data);
        }
        scnr.close();
    }

    /**
     * This method takes in a string of sentence and split the string to a list
     * of words by delimited by whitespces.
     *
     * @param sentence a String object of the sentence to split
     * @return a new list of words
     */
    public ArrayList<String> splitLine(String sentence) {
        ArrayList<String> list = new ArrayList<>();
        // Uses static method to add all elements of string[] to ArrayList
        Collections.addAll(list, sentence.split(" "));
        return list;
    }

    /**
     * This method takes in a list of words and for each word it trys to split
     * at hyphens.
     * 
     * @param words a list of words to split
     * @return a new list of words split at hyphens
     */
    public ArrayList<String> splitAtHyphens(ArrayList<String> words){
        ArrayList<String> list = new ArrayList<>();

        for (String word : words) {
            // split at hyphens for each word
            Collections.addAll(list, word.split("-"));
        }
        return list;
    } 

    /**
     * This method takes in a list of words and for each word it removes all 
     * punctuations. The new words are then added to a new list to return.
     * 
     * @param words a list of words to get punctuations removed
     * @return a new list of words with punctuations removed
     */
    public ArrayList<String> removePunctuation(ArrayList<String> words) {
        ArrayList<String> list = new ArrayList<>();

        for (String word : words) {
            // regular expression
            list.add(word.replaceAll("[^a-zA-Z0-9]", "")); 
        }
        return list;
    }

    /**
     * This method takes in a list of words and for each word it trims the white
     * spaces. The new words are then added to a new list to return.
     * 
     * @param words a list of words to get spaces trimmed
     * @return a new list of words with spaces trimmed
     */
    public ArrayList<String> trimWhiteSpaces(ArrayList<String> words){
        ArrayList<String> list = new ArrayList<>();
        
        for (String word : words) {
            // simply call its instance method for string object
            list.add(word.trim());
        }
        return list;
    }

    /**
     * This method takes in a list of words and removes all the empty and single
     * words. The new words are then added to a new list to return.
     * 
     * @param words a list of words to be filtered
     * @return a new list of words with empty and single words removed
     */
    public ArrayList<String> removeEmptySingleWords(ArrayList<String> words){
        ArrayList<String> list = new ArrayList<>();

        for (String word : words) {
            // add the word to the new list of its length is bigger than 1
            if (word.length() > 1) {
                list.add(word);
            }
        }
        return list;
    }

    /**
     * This method takes in a list of words and cast all words to lower case.
     * 
     * @param words a list of words to be casted
     * @return a new list of words with all lower cases
     */
    public ArrayList<String> toLowerCase(ArrayList<String> words){
        ArrayList<String> list = new ArrayList<>();

        for (String word : words) {
            // simply call its instance method for string object
            list.add(word.toLowerCase());
        }
        return list;
    }


    /**
     * This method should remove all the stop words in the ArrayList and return a modified ArrayList of words.
     *
     * @param words a list of words to be filtered
     * @return a new list of words without any stop words
     * @throws IOException
     */
    public ArrayList<String> removeStopWords(ArrayList<String> words){
        ArrayList<String> list = new ArrayList<>();
        for (String word: words) {
            if (!stopWords.contains(word)){
                list.add(word);
            }
        }
        return list;
    }

    /**
     * This method should take in the cleaned data file as the input and use it to update the HashMap.
     *
     * @param inCleanFile file that is already filtered
     * @return updated HashMap
     */
    public void updateHashMap(String inCleanFile) throws IOException {
        Scanner scanner = new Scanner(new File(inCleanFile));
        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            LinkedHashSet<String> set = new LinkedHashSet<>(this.splitLine(line)); //i used set in order to not include exact same word more than once in one review
            int rating = 0;
            for (String word: set){
                if (word.matches(".*\\d+.*")) {
                    rating = Integer.parseInt(word);
                }
                else {
                    if (wordFreqMap.get(word) != null){
                        int[] array = wordFreqMap.get(word);
                        array[0] += rating;
                        array[1]++;
                        wordFreqMap.put(word, array);
                    }
                    else {
                        int[] array = {rating, 1};
                        wordFreqMap.put(word, array);
                    }
                }
            }
        }
        scanner.close();
    }

    /**
     * Predicts the ratings for the reviews given in this cleaned file.
     *
     * @param inCleanFile new unrated reviews from a cleaned file
     * @param outRatingsFile output file
     * @return outRatingsFile consists of predicted rating for each review
     * @throws IOException
     */

    public void rateReviews(String inCleanFile, String outRatingsFile) 
    throws IOException {
        Scanner scanner = new Scanner(new File(inCleanFile));
        FileWriter writer = new FileWriter(new File(outRatingsFile));
        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            ArrayList <String> list = this.splitLine(line);
            double rating = 0;
            int wordNumber = 0;
            for (String word: list){
                if (wordFreqMap.get(word) != null){
                    int[] array = wordFreqMap.get(word);
                    rating += (double) array[0] / array[1];
                    wordNumber++;
                }
                else {
                    rating +=2;
                    wordNumber++;
                }
            }
            if (wordNumber == 0){
                writer.write("2" + "\n");
            }
            else {
                double preResult = rating / wordNumber;
                String result = String.format("%.1f", preResult);
                writer.write(result + "\n");
            }
        }
        writer.close();

    } 

    /**
     * This method takes in a filename called inFile, read it line by line, 
     * clean each line and write to a new file called outFile.
     * @param inFile the filename to read
     * @param outFile the filename to write 
     * @param ratingIncluded whether the inFile contains rating at front
     * @throws IOException
     */
    public void cleanData(String inFile, String outFile, boolean ratingIncluded) 
    throws IOException {

        // creating scanner and writer to open and read file
        Scanner scnr = new Scanner(new File(inFile));
        FileWriter writer = new FileWriter(new File(outFile));

        // starting while until there is a next line
        while (scnr.hasNextLine()) {
            String sentence = scnr.nextLine();
            ArrayList<String> list = this.splitLine(sentence);

            // checking if i need to save the rating
            String rating = null;
            if (ratingIncluded) {
                rating = list.remove(0);
            }

            // cleaning up the file with the methods provided
            list = this.splitAtHyphens(list);
            list = this.removePunctuation(list);
            list = this.trimWhiteSpaces(list);
            list = this.removeEmptySingleWords(list);
            list = this.toLowerCase(list);
            list = this.removeStopWords(list);

            // joining the strings via " "
            String result = String.join(" ", list); 

            // if i saved rating than i finish writing it
            if (ratingIncluded) {
                result = rating + " " + result;
            }

            // writing into the file
            writer.write(result + "\n");
        }

        // closing scanner and writer
        scnr.close();
        writer.close();
    }


}