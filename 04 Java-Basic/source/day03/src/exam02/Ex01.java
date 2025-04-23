package exam02;

public class Ex01 {
    public static void main(String[] args) {
        Schedule myS = new Schedule(2025, 4, 22);
//        myS.year = 2025;
//        myS.month = 2;
//        myS.day = 31;     // 통제 불가
        myS.setYear(2025);
        myS.setMonth(2);
        myS.setDay(31);

        myS.showDate();
    }
}
