package exam02;

public class Schedule2 {
    private int year;
    private int month;
    private int day;

    public Schedule2 () {}
    public Schedule2 (int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setDay(int day) {
        this.day = day;
    }

    void showDate() {
        System.out.printf("스케줄: %d년 %02d월 %02d일\n", year, month, day);
    }

    public Schedule2 getThis() {
        return this;
    }
}
