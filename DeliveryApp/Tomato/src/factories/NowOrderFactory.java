package factories;

import models.*;
import strategies.PaymentStrategy;

import java.time.LocalDateTime;
import java.util.List;

public class NowOrderFactory implements OrderFactory {
    @Override
    public Order createOrder(User user, Cart cart, Restaurant restaurant, List<MenuItems> menuItems, PaymentStrategy paymentStrategy, String orderType) {
        Order order = null;
        if(orderType.equals("Delivery")){
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
        order.setSchedule(LocalDateTime.now().toString());
        order.setTotalPrice(cart.getTotalPrice());

        return order;
    }
}
