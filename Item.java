public class Item {
    private int id;
    private String name;
    private int price;
    private int quan;

    private Supplier supplier;

    public Item(String name, int price, int quantity, Supplier supplier) {
        this.id = (int) ( 10000 * Math.random() + 2 );
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.supplier = supplier;
    }

    public int getId() { return this.id; }
    public String getName() { return this.name; }
    public int getPrice() { return this.price; }
    public int getAvailableQuantity() { return this.quantity; }
    public Supplier getSupplier() { return supplier; }

    public void setName(String newName) { this.name = newName; }
    public void setPrice(int newPrice) { this.price = newPrice; }
    public void setAvailableQuantity(int newQuantity) { this.quantity = newQuantity; }

    @Override
    public String toString() {
        return "Item{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
