package exam06;

public class Order implements Buyer, Seller{
    @Override
    public void buy() {
        System.out.println("구매!");
    }

    @Override
    public void sell() {
        System.out.println("판매!");
    }

    public void order() {
        Buyer.super.order();
    }
}
