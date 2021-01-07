package historyOfOrders;

import order.Order;

import java.util.List;

public class HistoryIterator implements Iterator{

    List<Order> orders;
    private int index;

    public HistoryIterator(List<Order> orders) {
        this.orders = orders;
        index = 0;
    }

    public Order last(){
        index = orders.size()-1;
        return orders.get(index);
    }

    public Order first(){
        index = 0;
        return orders.get(0);
    }

    public boolean isLast(){
        return index == orders.size() - 1;
    }

    public boolean isFirst(){
        return  index == 0;
    }

    public Order next(){
        if (index + 1 < orders.size() ){
            index++;
            return orders.get(index);
        }
        return last();
    }

    public Order prev(){
        if (index - 1 >= 0){
            index--;
            return orders.get(index);
        }
        return first();
    }

    public Order currentOrder(){
        return orders.get(index);
    }

    public int sizeHistory(){
        return orders.size();
    }
}