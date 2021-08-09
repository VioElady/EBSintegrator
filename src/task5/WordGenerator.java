package task5;

import java.util.Random;

public class WordGenerator {

    public String generateRandomWords(int numberOfWords) {
        String generatedWord = null;
        Random random = new Random();
        for (int i = 0; i < numberOfWords; i++) {
            char[] word = new char[random.nextInt(5) + 3];
            for (int j = 0; j < word.length; j++) {
                word[j] = (char) ('a' + random.nextInt(26));
            }
            generatedWord = new String(word)

            ;
        }
        return generatedWord;
    }
}
