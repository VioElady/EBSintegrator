package task4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class WorkFile {


    private static String DESTINATION_FILE = "src\\\\task4\\\\filename.txt";

    public  void CreateFile() {
        File myObj = new File(DESTINATION_FILE);
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

    public String[] ReadFile() {
        String[] words = null;
        try {
            String data = "";
            File myObj = new File(DESTINATION_FILE);
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

}
