package historyOfOrders;

import order.Order;

import java.util.ArrayList;
import java.util.List;

public class HistoryOfOrders {

    private final List<Order> orderList;
    private final HistoryIterator iterator;

    public HistoryOfOrders() {
        orderList = new ArrayList<>();
        iterator = new HistoryIterator(orderList);
    }


    public HistoryIterator getIterator(){
        return iterator;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void addToHistory(Order order){
        orderList.add(order);
    }

    public int getSize(){
        return orderList.size();
    }
}
