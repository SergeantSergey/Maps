import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

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
        File file = new File("");
        try {
            list = parser.parse(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        list.forEach(System.out::println);
    }
}
