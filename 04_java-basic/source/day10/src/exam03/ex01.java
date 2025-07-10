package exam03;

import java.time.LocalDate;
import java.time.temporal.ChronoField;

public class ex01 {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();  // 현재 날짜

        LocalDate beforAMonthDate = LocalDate.of(2025, 4, 2);
        LocalDate beforAMonth = today.minusMonths(1);
        System.out.println(beforAMonthDate);
        System.out.println(beforAMonth);

        int year = today.getYear();        //int year = today.get(ChronoField.YEAR);
        int month = today.getMonthValue(); //int month = today.get(ChronoField.MONTH_OF_YEAR);
        int day = today.getDayOfMonth();   //int day = today.get(ChronoField.DAY_OF_MONTH);
        System.out.printf("%d년 %d월 %d일%n", year, month, day);


    }
}
