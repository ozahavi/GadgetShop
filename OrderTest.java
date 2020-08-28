public class OrderTest {
    public static void main(String[] args) {
        Order order = new Order();
        order.addItem(new Item("Lamp", 10, 20, new Supplier("Lamp inc.", 1)));
        order.addItem(new Item("Lamp Pro", 999, 20, new Supplier("Lamp inc.", 1)));

        System.out.println(order);
        order.completeOrder((int) ( Math.random() * Integer.MAX_VALUE + 1 ) + 1);
        System.out.println();
        System.out.println();
        System.out.println(order);
    }
}
