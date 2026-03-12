package factories;

import models.*;
import strategies.PaymentStrategy;

import java.util.List;
import java.util.Objects;

public class ScheduledOrderFactory implements OrderFactory {
    private String scheduleTime;
    public ScheduledOrderFactory(String scheduledTime) {
        this.scheduleTime = scheduledTime;
    }

    @Override
    public Order createOrder(User user, Cart cart, Restaurant restaurant, List<MenuItems> menuItems, PaymentStrategy paymentStrategy, String orderType) {
        Order order = null;

        if(Objects.equals(order.getType(), "Delivery")) {
            DeliveryOrder deliveryOrder = new DeliveryOrder();
            deliveryOrder.setAddress(user.getLocation());
            order = deliveryOrder;
        }

        else {
            PickUpOrder pickUpOrder = new PickUpOrder();
            pickUpOrder.setRestaurantAddress(restaurant.getLocation());
            order = pickUpOrder;
        }

        order.setUser(user);
        order.setRestaurant(restaurant);
        order.setPaymentStrategy(paymentStrategy);
        order.setSchedule(scheduleTime);
        order.setTotalPrice(cart.getTotalPrice());

        return order;
    }
}
