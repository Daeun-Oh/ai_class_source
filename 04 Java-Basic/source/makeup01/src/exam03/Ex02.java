package exam03;

public class Ex02 {
    public static void main(String[] args) {
        FruitBox<Apple> appleBox = new FruitBox<>();
        appleBox.add(new Apple());
        appleBox.add(new Apple());
        appleBox.add(new Apple());

        Juicer.make2(appleBox);

        FruitBox<Fruit> graphBox = new FruitBox<>();
        graphBox.add(new Graph());
        graphBox.add(new Graph());
        graphBox.add(new Graph());

        Juicer.make2(graphBox);

        Juicer.make3(appleBox);  // Juicer.<Apple>make3(appleBox);
    }
}
