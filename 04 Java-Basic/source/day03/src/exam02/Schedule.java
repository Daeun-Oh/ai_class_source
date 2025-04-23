package exam02;

public class Schedule {
    private int year;
    private int month;
    private int day;

    public Schedule () {}
    public Schedule (int _year, int _month, int _day) {
        year = _year;
        month = _month;
        day = _day;
    }

    // Setter S
    public void setYear(int _year) {
        year = _year;
    }

    public void setMonth(int _month) {
        month = _month;
    }

    public void setDay(int _day) {
        boolean yunYear = year % 4 == 0 && (year / 4) % 100 == 0 && year / 4 / 100 % 400 == 0;
        if (day > 0 && ((yunYear && month == 2 && day <= 28) || (month % 2 == 0 && day <= 30) || (month % 2 == 1 && day <= 31))) {
            day = _day;
        }
        else {
            System.out.println("Error: 존재하지 않는 날짜입니다!");
        }
    }
    // Setter E

    // Getter S
    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay()  {
        return day;
    }
    // Getter E

    void showDate() {
        System.out.printf("스케줄: %d년 %02d월 %02d일\n", year, month, day);
    }
}
