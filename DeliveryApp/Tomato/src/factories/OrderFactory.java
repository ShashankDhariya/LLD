package factories;

import models.*;
import strategies.PaymentStrategy;

import java.util.List;

public interface OrderFactory {
    public Order createOrder(User user, Cart cart, Restaurant restaurant, List<MenuItems> menuItems, PaymentStrategy paymentStrategy, String orderType);
}
