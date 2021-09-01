package task4;

import task5.WriteInFile;

import java.io.IOException;

public class Test {
    public static void main(String[] args) {
        String fileName = "src\\\\task4\\\\external-sorted.txt";

//        try {
////            WriteInFile.writeWordsInFile(3_000_000,fileName);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        WorkFile workFile = new WorkFile();
        SearchAnagrams searchAnagrams = new SearchAnagrams();
        String[] words = workFile.ReadFile();
        searchAnagrams.printAnagrams(words);
    }

}
