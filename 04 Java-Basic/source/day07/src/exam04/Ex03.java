package exam04;

public class Ex03 {
    public static void main(String[] args) {
        Transportation trans = Transportation.BUS;

        switch (trans) {
            case Transportation.BUS:    // 이렇게 써도 오류는 없다
                System.out.println("BUS!");
                break;
            case SUBWAY:    // trans가 이미 Transportation형인 걸 알기 때문에 이렇게 작성하는 것이 좋다
                System.out.println("SUBWAY!");
                break;
            case TAXI:
                System.out.println("TAXI!");
                break;
            case AIRPLANE:
                System.out.println("AIRPLANE!");
                break;
            default:
                System.out.println("해당사항이 없습니다.");
                break;
        }
    }
}
