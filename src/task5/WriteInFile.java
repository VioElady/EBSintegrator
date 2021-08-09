package task5;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.nio.file.Path.*;

public class WriteInFile {

    public void fileWriter() throws IOException {
        WordGenerator wordGenerator = new WordGenerator();

        String fileName = "src\\\\task4\\\\filename.txt";
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(of(fileName))) {
            for (long i =0; i < 3_000_000; i++){
                String word = wordGenerator.generateRandomWords(1);
                bufferedWriter.write(word + "\n");
            }

        }
    }

}
