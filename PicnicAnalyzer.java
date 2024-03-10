import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PicnicAnalyzer {

    
    public static int countWords(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        int wordCount = 0;

        while ((line = reader.readLine()) != null) {
            String[] words = line.split("\\s+");
            wordCount += words.length;
        }

        reader.close();
        return wordCount;
    }

    
    public static String findLongestWord(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        String longestWord = "";

        while ((line = reader.readLine()) != null) {
            String[] words = line.split("\\s+");
            for (String word : words) {
                if (word.length() > longestWord.length()) {
                    longestWord = word;
                }
            }
        }

        reader.close();
        return longestWord;
    }

    
    public static Map<String, Integer> wordFrequency(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        Map<String, Integer> wordCountMap = new HashMap<>();

        while ((line = reader.readLine()) != null) {
            String[] words = line.split("\\s+");
            for (String word : words) {
                wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
            }
        }

        reader.close();
        return wordCountMap;
    }

    public static void main(String[] args) {
        
        String filePath = "input.txt";

        try {
            
            int totalWords = countWords(filePath);
            System.out.println("Всего слов в файле: " + totalWords);

        
            String longestWord = findLongestWord(filePath);
            System.out.println("Самое длинное слово в файле: " + longestWord);

            
            Map<String, Integer> frequency = wordFrequency(filePath);
            System.out.println("Частота слов в файле:");
            for (Map.Entry<String, Integer> entry : frequency.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
