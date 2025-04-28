package exam04;

public class Ex04 {
    public static void main(String[] args) {
        Transportation taxi = Transportation.TAXI;
        System.out.printf("taxi.name(): %s, taxi.ordinal(): %d%n", taxi.name(), taxi.ordinal());

        System.out.printf("taxi.name(): %s%n", taxi.name());
        System.out.printf("taxi.toString(): %s%n", taxi.toString());
    }
}
