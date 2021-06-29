package task3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import static jdk.nashorn.internal.objects.Global.print;

public class MyAnagrams {
    private static void CreateFile() {
        File myObj = new File("filename.txt");
        try {
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private static void WriteToFile() {
        try {
            FileWriter myWriter = new FileWriter("filename.txt");
            myWriter.write("act\n" +
                    "cat\n" +
                    "tree\n" +
                    "race\n" +
                    "care\n" +
                    "acre\n" +
                    "bee\n" +
                    "eeb");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private static String[] ReadFile() {
        String[] words = null;
        try {
            String data = "";
            File myObj = new File("filename.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                data += myReader.nextLine() + " ";
            }
            words = data.split(" ");
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return words;
    }

    private static void printAnagrams(String arr[]) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            String word = arr[i];
            char[] letters = word.toCharArray();
            Arrays.sort(letters);
            String newWord = new String(letters);

            if (map.containsKey(newWord)) {
                map.get(newWord).add(word);
            } else {
                List<String> words = new ArrayList<>();
                words.add(word);
                map.put(newWord, words);
            }
        }
        for (String s : map.keySet()) {
            List<String> values = map.get(s);
            if (values.size() > 1) {
              System.out.println(values.toString().replace("[","").replace("]","").replace(",",""));
            }
        }
    }

    public static void main(String[] args) {
        CreateFile();
        WriteToFile();
        String[] words = ReadFile();
        printAnagrams(words);
    }
}