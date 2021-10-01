import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        HashMap<String, TestSubject> hashMap = new HashMap<>();
        String selectedString = "";

        for (int i = 0; i < 100; i++) {
            TestSubject subject = new TestSubject(i);
            hashMap.put(subject.getId(), subject);
            if (i == 27) {
                selectedString = subject.getId();
            }
        }

        System.out.println(hashMap.get(selectedString).getId());

        if (hashMap.get(selectedString).getId() == selectedString) {
            System.out.println("TRUE");
        } else {
            System.out.println("FALSE");
        }

        TreeMap<Integer, TestSubject> treeMap = new TreeMap<>(new TestComparator());

        for (int i = 0; i < 100; i++) {

            TestSubject subject = new TestSubject(i);
            treeMap.put(subject.getOrdinal(), subject);
        }

        System.out.println(treeMap.lastEntry());

        ArrayList<String> list = null;
        Parser parser = new Parser();
        File file = new File("voyna.txt");
        try {
            list = parser.parse(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // поиск слова введеного с клавиатуры
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите слово для поиска");
        String scannerLine = scanner.nextLine();

        System.out.println("Слов в книге " + getWorldCount(scannerLine, list));

        // поиск слова Страдание
        System.out.println("Слов в страдание книге " + getWorldCount("страдани[иеяй].?", list));

        // таблица умножения
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                System.out.print(i * j + " ");
            }
            System.out.println();
        }
    }

    // поиск слова страдание
    public static int getWorldCount(String worldPattern, ArrayList<String> list) {
        int indexStr = 0;
        Pattern pattern = Pattern.compile(worldPattern, Pattern.CASE_INSENSITIVE);

        for (String s : list) {
            Matcher matcher = pattern.matcher(s);
            while (matcher.find()) {
                indexStr++;
            }
        }
        return indexStr;
    }
}
