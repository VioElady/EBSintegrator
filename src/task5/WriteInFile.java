package task5;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteInFile {

    public static void writeWordsInFile(int number, String fileName) throws IOException {

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (int i = 0; i < number; i++) {
                writer.write(WordGenerator.generateRandomWords() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

    }
}
