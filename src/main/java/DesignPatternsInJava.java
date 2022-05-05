import javax.swing.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * class for finding design patterns in Java.
 *
 * @author Yuzhe Guo.
 */
public class DesignPatternsInJava {
    public static void main(String[] args) {
        pattern1();
        pattern2();
        pattern3();
        pattern4();
        pattern5();
        pattern6();
        pattern7();
    }

    public static void pattern1() {
        /**
         * when we are going to use a thread safe map, we can use Collections to create a new
         * synchronizedMap.
         * What is the implementation of synchronizedMap?
         * Pattern: Decorator pattern, factory pattern
         */
        Map<String, String> map = new HashMap<>();
        map.put("course name", "15214");
        map.put("grade", "A+");
        Map<String, String> synMap = Collections.synchronizedMap(map);
        System.out.println(synMap.get("course name"));
        System.out.println(synMap.get("grade"));
    }

    public static void pattern2() {
        /**
         * When we are going to sort the list, we use Collections.sort() and pass the list
         * and comparator as input variables.
         * For each comparator, we need to declare its compare method.
         * Pattern: strategy pattern
         */
        Comparator<String> comparator1 = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int len1 = (o1 == null) ? 0 : o1.length();
                int len2 = (o2 == null) ? 0 : o2.length();
                return len1 - len2;
            }
        };
        Comparator<String> comparator2 = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                assert (o1 != null) && (o2 != null);
                assert (o1.length() > 0) && (o2.length() > 0);
                return o1.charAt(0) - o2.charAt(0);
            }
        };
        List<String> list = new ArrayList<>(List.of("Harry", "Hagrid", "Hermione", "Ron"));
        Collections.sort(list, comparator1);
        System.out.println(list);
        Collections.sort(list, comparator2);
        System.out.println(list);
    }

    public static void pattern3() {
        /**
         * When we want to create string in Java. It is recommended to use StringBuilder
         * because it is more efficient and convenient.
         * We can also use String.format() and String.valueOf() to get a string.
         *
         * What is the implementation of StringBuilder?
         *
         * Pattern: builder pattern, static factory method (not in 23 design patterns, not abstract factory Pattern).
         * please refer to Effective Java(3rd) item 1 for static factory method.
         * please refer to item 2 for detailed discussion of builder pattern.
         */
        StringBuilder builder = new StringBuilder();
        builder.append("This").append(" ").append("is ").append(17514);
        String str1 = builder.substring(8);
        String str2 = builder.toString();
        System.out.println(str1);
        System.out.println(str2);

        // different ways to build the string, BigInteger
        String str3 = String.format("I am %s years old", 23);
        String str4 = String.valueOf(17514);
        BigInteger in = BigInteger.valueOf(5);
    }

    public static void pattern4() {
        /**
         * Every Java application has a single instance of class Runtime that allows
         * the application to interface with the environment in which the application is running
         * We can use Runtime.getRuntime() method to get it.
         *
         * We can use Collections to get immutable emptyMap, emptyList to avoid Unwanted NullPointerException.
         *
         * What is the implementation of emptyMap and emptyList?
         *
         * Pattern: singleton pattern
         */
        Runtime runtime = Runtime.getRuntime();
        Map<String, Integer> emptyMap = Collections.emptyMap();
        List<String> emptyList = Collections.emptyList();
    }

    public static void pattern5() {
        /**
         * Java's array and List interface is different, if we need to create an
         * array {1, 3, 4} but has the same behavior as List interface(add, size, isEmpty),
         * We can use Arrays.adList() method.
         *
         * Pattern: adaptor pattern
         */
        List<Integer> list1 = Arrays.asList(2020, 2022);
        List<String> list3 = Arrays.asList("Malfoy", "Snap");
    }

    public static void pattern6() {
        /**
         * We can use Java swing to build simple UI.
         * There are many type of JComponent in Java, including JPanel, JButton, JTextArea
         * We can add these component to the JPanel and add JPanel to JPanel. Then we need to add
         * JPanel to the JFrame and set visible to true.
         *
         * What class does JButton, JPanel, JTextArea extend?
         *
         * Pattern: composite pattern
         */
        JFrame frame = new JFrame("design patterns");
        frame.setSize(300, 150);
        JPanel window = new JPanel();
        JPanel sub = new JPanel();
        sub.add(new JButton("button"));
        sub.add(new JCheckBox("checkBox"));
        window.add(new JTextArea("test area"));
        window.add(sub);
        frame.add(window);
        frame.setVisible(true);
    }


    public static void pattern7() {
        /**
         * we can use forEach or iterator to iterate the element in the list.
         * Pattern: iterator pattern
         */
        List<String> myList = new ArrayList<>();
        myList.add("Niffler");
        myList.add("Bowtruckles");
        myList.add("Zouwu");
        myList.forEach(s -> System.out.println(s));
        Iterator<String> iterator = myList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
