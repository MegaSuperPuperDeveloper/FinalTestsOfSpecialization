import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Map;

public class Functions {

    // Функция выводит количество разных фруктов и овощей в файле
    public static void printFileData(Map<String, Integer> map) throws IOException {
        String[] list; // Массив нужен для занесения слов в map
        String line = ""; // Переменная для перечисления строк в файле
        try(BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            while((line = reader.readLine()) != null) {
                list = line.split(" ");
                for (String s : list) {
                    if (!map.containsKey(s)) {
                        map.put(s.toLowerCase(), 1);
                    } else {
                        map.put(s.toLowerCase(), map.get(s) + 1);
                    }
                }
            }
            System.out.println("Список всех фруктов и овощей и их количество:");
            map.forEach((k, v) -> System.out.println(k + "=" + v));
        }
    }

    // Функция возвращает самое длинное слово в файле
    public static String longestWord(Map<String, Integer> map) throws IOException {
        String[] list; // Массив нужен для занесения слов в map
        String line = ""; // Переменная для перечисления строк в файле
        String longestWord = ""; // Переменная нужна для возвращения самого длиного слова
        LinkedList<String> listOfWords = new LinkedList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            while((line = reader.readLine()) != null) {
                list = line.split(" ");
                Collections.addAll(listOfWords, list);
                for (String el : listOfWords) {
                    if (el.length() > longestWord.length()) {
                        longestWord = el.toLowerCase();
                    }
                }
            }
        }
        return longestWord;
    }

    // Функция выводит количество слов в файле
    public static int countOfWords(Map<String, Integer> map) throws IOException {
        String[] list; // Массив нужен для занесения слов в map
        String line = ""; // Переменная для перечисления строк в файле
        LinkedList<String> listOfWords = new LinkedList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            while((line = reader.readLine()) != null) {
                list = line.split(" ");
                Collections.addAll(listOfWords, list);
            }
        }
        return listOfWords.size();
    }
}