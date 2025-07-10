package exam05;

public class Book {
    private int isbn;
    private String title;
    private String author;
    private String publisher;

    public Book(int isbn, String title, String author, String publisher) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
    }

    /*
    // 이 방법은 멤버 변수가 많으면 너무 귀찮다
    @Override
    public String toString() {
        return String.format("isbn=%d, title=%s, author=%s, publisher=%s", isbn, title, author, publisher);
    }
    */

    @Override
    public String toString() {
        return "Book{" +
                "isbn=" + isbn +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                '}';
    }
}
