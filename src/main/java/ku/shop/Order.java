package ku.shop;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<OrderItem> items;
    private LocalDateTime date;

    public Order() {
        this.items = new ArrayList<>();
        this.date = LocalDateTime.now();
    }

    public void addItem(Product prod, int quantity) throws NotEnoughStockException {
        if (prod.getStock() < quantity) {
            throw new NotEnoughStockException("Not enough stock for product: " + prod.getName());
        }
        prod.cutStock(quantity);
        items.add(new OrderItem(prod, quantity));
    }

    public double getTotal() {
        double total = 0;
        for (OrderItem item : items)
            total += item.getSubtotal();
        return total;
    }
}
