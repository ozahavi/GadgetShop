import java.util.ArrayList;
import java.util.List;

public class Order {
    public static final int ORDER_NOT_COMPLETE = 0;
    public static final int ORDER_COMPLETE = 1;
    public static final int ORDER_SENT = 2;

    private int orderId;
    private int clientId;
    private int orderStatus;

    private List<Item> items;
    private int finalPrice;

    public Order() {
        this.orderId = (int) ( 10000 * Math.random() + 1 );
        this.orderStatus = ORDER_NOT_COMPLETE;

        this.items = new ArrayList<>();
        this.finalPrice = 0;
    }

    /**
     * Method will add an item to the order and set item's valid quantity
     * @param item Item
     * @return Was item successfully added
     */
    public boolean addItem(Item item) {
        if(item.getAvailableQuantity() <= 0) return false;

        items.add(item);
        finalPrice += item.getPrice();
        item.setAvailableQuantity(item.getAvailableQuantity() - 1);

        return true;
    }

    /**
     * Method will complete the order and set required information
     * @param clientId Client's ID
     */
    public void completeOrder(int clientId) {
        if(this.orderStatus != ORDER_NOT_COMPLETE) return;

        this.clientId = clientId;
        this.orderStatus = ORDER_COMPLETE;
    }

    /**
     * Method will send the order to the client
     * MUST BE SENT AFTER ORDER IS COMPLETE
     * @return Was order sent
     */
    public boolean sendOrder() {
        if(orderStatus == ORDER_COMPLETE) orderStatus = ORDER_SENT;
        return orderStatus == ORDER_SENT;
    }

    public int getOrderId() { return this.orderId; }
    public int getClientId() { return this.clientId; }
    public int getOrderStatus() { return this.orderStatus; }
    public int getFinalPrice() { return this.finalPrice; }
    public List<Item> getItems() { return this.items; }

    public String getOrderStatusString() {
        switch (orderStatus) {
            case ORDER_NOT_COMPLETE:
                return "Order isn't complete";
            case ORDER_COMPLETE:
                return "Order is complete";
            case ORDER_SENT:
                return "Order was sent to client";
            default:
                return "UNKNOWN STATE!";
        }
    }

    @Override
    public String toString() {
        String output = "Order{\n\t";
        output += String.format("ID: %d,\n\t", this.orderId);
        output += String.format("ClientID: %d,\n\t", this.clientId);
        output += String.format("OrderStatus: %d,\n\t", this.orderStatus);
        output += String.format("FinalPrice: %d,\n\t", this.finalPrice);
        output += "Items: [\n\t";

        for(Item item : this.items) output += String.format("\t%s,\n\t", item);

        output += "]\n}";
        return output;
    }
}
