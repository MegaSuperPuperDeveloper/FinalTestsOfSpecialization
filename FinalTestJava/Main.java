import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        Map<String, Integer> map = new HashMap<>();
        System.out.println("Количество слов в файле: " + Functions.countOfWords(map));
        System.out.println();
        Functions.printFileData(map);
        System.out.println();
        System.out.println("Cамое длинное слово: "  + Functions.longestWord(map));
    }

}
