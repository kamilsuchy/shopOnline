package historyOfOrders;

import order.Order;

public interface Iterator {

    Order last();

    Order first();

    Order next();

    Order prev();

    Order currentOrder();

    int sizeHistory();

    boolean isLast();

    boolean isFirst();
}
