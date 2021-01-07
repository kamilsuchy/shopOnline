package historyOfOrders;

import order.Order;

import java.util.ArrayList;
import java.util.List;

public class HistoryOfOrders {

    private final List<Order> orderList;
    private final Iterator iterator;

    public HistoryOfOrders() {
        orderList = new ArrayList<>();
        iterator = new HistoryIterator(orderList);
    }

    public Iterator getDefaultIterator() {
        return iterator;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void addToHistory(Order order) {
        orderList.add(order);
    }

    public int getSize() {
        return orderList.size();
    }
}
