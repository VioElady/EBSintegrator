package task5;

import java.util.Random;

public class WordGenerator {

    public static String generateRandomWords() {
        String generatedWord;
        Random random = new Random();
            char[] word = new char[random.nextInt(5) + 3];
            for (int j = 0; j < word.length; j++) {
                word[j] = (char) ('a' + random.nextInt(26));
            }
            generatedWord = new String(word);
        return generatedWord;
    }
}
