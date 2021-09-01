package task4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class SearchAnagrams {

    public void printAnagrams(String arr[]) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            String word = arr[i];
            char[] letters = word.toCharArray();

            for (int n = 0; n < letters.length; n++) {
                for (int j = n + 1; j < letters.length; j++) {
                    if (letters[n] > letters[j]) {
                        Sort(n, j, letters);
                    }
                }
            }
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

//                values = Arrays.asList(sortStringArray(values.toArray(new String[0])));
//                values = Arrays.asList();
//                Arrays.parallelSort(values.toArray(new String[0]));

                System.out.print( s + " - " );

                for (String value : values
                ) {
                    System.out.print( value + " ");
                }
                System.out.println();
            }
        }
    }

    public int CompareString(String first, String second) {
        int len;
        if (first.length() >= second.length())
            len = second.length();
        else
            len = first.length();
        for (int i = 0; i <= len; i++) {
            if (first.charAt(i) > second.charAt(i))
                return 1;
            else if (first.charAt(i) < second.charAt(i))
                return -1;
        }
        return 0;
    }

    public String[] sortStringArray(String[] array) {
        for (int i = 0; i <= array.length - 1; i++) {
            for (int j = 1; j < array.length - i; j++) {
                if (CompareString(array[j - 1], array[j]) == 1) {
                    String temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }

    public void Sort(int i, int j, char[] charArray) {
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
    }
}
