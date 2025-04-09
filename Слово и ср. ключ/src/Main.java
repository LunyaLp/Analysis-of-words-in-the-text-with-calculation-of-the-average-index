import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader buffReader = new BufferedReader(new FileReader("voina.txt"));
        String perem = "";
        while (buffReader.ready()) {
            perem += buffReader.readLine();
        }

        perem = perem.replaceAll("[0-9a-zA-ZÀ-ÿ]", " "); 
        perem = perem.replaceAll("[;?.,!«»—\\[\\]()-/:]", " ");
        perem = perem.replaceAll("\\s+", " ");

        String[] words = perem.split("\\s+");

        Map<String, List<Integer>> mapA = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i].toLowerCase();
            if (mapA.get(word) == null) {
                List<Integer> list = new ArrayList<>();
                mapA.put(word, list);
            }
            mapA.get(word).add(i);
        }

        for (String word : mapA.keySet()) {
            List<Integer> keys = mapA.get(word);
            double sum = 0;
            for (int key : keys) {
                sum += key;
            }
            double averageKey = sum / keys.size();
            System.out.println("Слово: " + word + ". Среднее арифметическое ключей: " + averageKey);
        }

        buffReader.close();
    }

}