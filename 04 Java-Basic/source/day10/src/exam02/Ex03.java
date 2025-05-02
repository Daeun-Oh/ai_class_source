package exam02;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.toMap;

public class Ex03 {
    public static void main(String[] args) {
        List<Book> items = List.of(
                new Book(1000, "책1", "저자1"),
                new Book(1001, "책2", "저자2"),
                new Book(1002, "책3", "저자2"),
                new Book(1003, "책4", "저자3"),
                new Book(1004, "책5", "저자3")
        );

        // Book::getIsbn => b -> b.getIsbn(), Funtion.identity() => b -> b
        Map<Integer, Book> items2 = items.stream()
                .collect(toMap(Book::getIsbn, Function.identity()));
        items2.forEach((k, v) -> System.out.printf("key=%s, value=%s%n", k, v));
    }
}
