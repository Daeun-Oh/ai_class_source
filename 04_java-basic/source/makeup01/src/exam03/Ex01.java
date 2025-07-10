package exam03;

public class Ex01 {
    public static void main(String[] args) {
        FruitBox<Apple> appleItems = new FruitBox<>();
        appleItems.add(new Apple());
        appleItems.add(new Apple());
        appleItems.add(new Apple());

        Juicer.make(appleItems);

        FruitBox<Graph> grapeItems = new FruitBox<>();
        grapeItems.add(new Graph());
        grapeItems.add(new Graph());
        grapeItems.add(new Graph());

        Juicer.make(grapeItems);
    }
}
