package managers;
import models.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderManager {
    List<Order> orders = new ArrayList<>();
    static OrderManager orderManager = null;

    public static OrderManager getInstance()
    {
        if(orderManager == null)
            orderManager=new OrderManager();

        return orderManager;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public void listOrders() {
        for(Order order : orders) {
            System.out.println("Type: " + order.getType() + " " + order.getOrderId());
        }
    }

    public List<Order> getOrders() {
        return orders;
    }
}
