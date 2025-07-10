package exam02;

import java.util.Vector;

public class Ex03 {
    public static void main(String[] args) {
        Vector<String> items = new Vector<>(3);
        addAndPrintCapacity(items, "가");
        addAndPrintCapacity(items, "나");
        addAndPrintCapacity(items, "다");
        addAndPrintCapacity(items, "라");
        addAndPrintCapacity(items, "마");
        addAndPrintCapacity(items, "바");
        addAndPrintCapacity(items, "사");
    }

    public static <T> void addAndPrintCapacity(Vector<T> vector, T element) {
        vector.add(element);
        System.out.printf("%s - capacity: %d%n", element, vector.capacity());
    }
}
