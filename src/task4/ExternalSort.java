package task4;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;


public class ExternalSort
{
    static int N = 2000000; // size of the file in disk
    static int M = 100000; // max items the memory buffer can hold

    public static void externalSort(String fileName)
    {
        String tfile = "temp-file-";
        String[] buffer = new String[M < N ? M : N];

        try
        {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            int slices = (int) Math.ceil((double) N/M);

            int i, j;
            i = j = 0;
            // Iterate through the elements in the file
            for (i = 0; i < slices; i++)
            {
                // Read M-element chunk at a time from the file
                for (j = 0; j < (M < N ? M : N); j++)
                {
                    String t = br.readLine();
                    if (t != null)
                        buffer[j] = t;
                    else
                        break;
                }
                // Sort M elements
                Arrays.sort(buffer);


                // Write the sorted numbers to temp file
                FileWriter fw = new FileWriter(tfile + Integer.toString(i) + ".txt");
                PrintWriter pw = new PrintWriter(fw);
                for (int k = 0; k < j; k++)
                    pw.println(buffer[k]);

                pw.close();
                fw.close();
            }

            br.close();
            fr.close();

            // Now open each file and merge them, then write back to disk
            String[] topNums = new String[slices];
            BufferedReader[] brs = new BufferedReader[slices];

            for (i = 0; i < slices; i++)
            {
                brs[i] = new BufferedReader(new FileReader(tfile + Integer.toString(i) + ".txt"));
                String t = brs[i].readLine();
                if (t != null)
                    topNums[i] = t;
                else
                    topNums[i] = "";
            }

            FileWriter fw = new FileWriter("external-sorted.txt");
            PrintWriter pw = new PrintWriter(fw);

            for (i = 0; i < N; i++)
            {
                String min = topNums[0];
                int minFile = 0;

                for (j = 0; j < slices; j++)
                {
                    if (min.compareTo(topNums[j])==1)
                    {
                        min = topNums[j];
                        minFile = j;
                    }
                }

                pw.println(min);
                String t = brs[minFile].readLine();
                if (t != null)
                    topNums[minFile] = t;
                else
                    topNums[minFile] = "";

            }
            for (i = 0; i < slices; i++)
                brs[i].close();

            pw.close();
            fw.close();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean CompareString(String first, String second) {
        int len;
        if (first.length() >= second.length())
            len = second.length();
        else
            len = first.length();
        for (int i = 0; i <= len; i++) {
            if (first.charAt(i) > second.charAt(i))
                return true;
            else if (first.charAt(i) < second.charAt(i))
                return false;
        }
        return false;
    }

    static String generateInput(int n)
    {
        String fileName = "external-sort.txt";
        Random rand = new Random();

        try
        {
            FileWriter fw = new FileWriter(fileName);
            PrintWriter pw = new PrintWriter(fw);

            for (int i = 0; i < n; i++)
                pw.println(rand.nextInt(101));

            pw.close();
        }

        catch (IOException e)
        {
            e.printStackTrace();
        }

        return fileName;
    }

    public static void main(String[] args)
    {
//        String fileName = generateInput(N);
        externalSort("external-sort.txt");
    }
}
