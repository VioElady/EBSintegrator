package task4;

public class Test {
    public static void main(String[] args) {

        WorkFile workFile = new WorkFile();
        SearchAnagrams searchAnagrams = new SearchAnagrams();

        workFile.CreateFile();
        String[] words = workFile.ReadFile();
        searchAnagrams.printAnagrams(words);
    }

}
