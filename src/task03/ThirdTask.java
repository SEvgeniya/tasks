package task03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class ThirdTask {

    private static final String filePath = "D:/text.txt";

    public static void main(String[] args) {

        countWords();
    }

    public static void countWords() {

        List<String> words = new ArrayList<>();
        try {
            String str;
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(ThirdTask.filePath), StandardCharsets.UTF_8));
            while ((str = br.readLine()) != null) {
                Arrays.stream(str.split(" "))
                        .map(s -> s.replaceAll("[-+.^:,]",""))
                        .forEach(words::add);
            }
            br.close();
        } catch (IOException exc) {
            System.out.println(exc.toString());
        }

        Map<String, Integer> result = new HashMap<>();

        for (int i = 0; i < words.size(); i ++) {
            int count = 0;
            for (String word : words) {
                if (words.get(i).equals(word)) {
                    count++;
                }
                result.put(words.get(i), count);
            }
        }
        entriesSortedByValues(result)
                .forEach(System.out::println);
    }
    private static <String, Integer extends Comparable> List<Map.Entry<String, Integer>> entriesSortedByValues(Map<String, Integer> map) {

        List<Map.Entry<String, Integer>> sortedEntries = new ArrayList<>(map.entrySet());
        sortedEntries.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));
        return sortedEntries;
    }
}
