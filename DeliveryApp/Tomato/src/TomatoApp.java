import factories.NowOrderFactory;
import factories.OrderFactory;
import factories.ScheduledOrderFactory;
import managers.OrderManager;
import managers.RestaurantManager;
import models.*;
import service.NotificationService;
import strategies.PaymentStrategy;

import java.util.List;

import static managers.RestaurantManager.getInstance;

public class TomatoApp {
    static void initializeRestaurants() {
        Restaurant restaurant1 = new Restaurant("Bikaner Sweets", "Deoband");
        restaurant1.addMenu(new MenuItems("P1", "Suji Halwa", 100));
        restaurant1.addMenu(new MenuItems("P2", "Gajar Halwa", 200));
        restaurant1.addMenu(new MenuItems("P3", "Moong Dal Halwa", 300));

        Restaurant restaurant2 = new Restaurant("Bikaner Sweets", "Dehradun");
        restaurant2.addMenu(new MenuItems("P11", "Suji_Halwa", 100));
        restaurant2.addMenu(new MenuItems("P22", "Gajar_Halwa", 200));
        restaurant2.addMenu(new MenuItems("P33", "Moong_Dal Halwa", 300));

        Restaurant restaurant3 = new Restaurant("Bikaner Sweets", "Deoband");
        restaurant3.addMenu(new MenuItems("P111", "Suji-Halwa", 100));
        restaurant3.addMenu(new MenuItems("P222", "Gajar-Halwa", 200));
        restaurant3.addMenu(new MenuItems("P333", "Moong-Dal-Halwa", 300));

        RestaurantManager restaurantManager = getInstance();
        restaurantManager.addRestaurant(restaurant1);
        restaurantManager.addRestaurant(restaurant2);
        restaurantManager.addRestaurant(restaurant3);
    }

    List<Restaurant> searchRestaurantsByLocation(String location) {
        return RestaurantManager.getInstance().getRestaurantByLocation(location);
    }

    void selectRestaurant(User user, Restaurant restaurant) {
        Cart cart = user.getCart();
        cart.setRestaurant(restaurant);
    }

    void addToCart(User user, String itemCode) {
        Restaurant restaurant = user.getCart().getRestaurant();
        if(restaurant == null) {
            System.out.println("Restaurant not found");
            return;
        }

        for(MenuItems items: restaurant.getMenu()) {
            if(items.getCode().equals(itemCode)) {
                user.getCart().addToCart(items);
                break;
            }
        }
    }

    Order checkOutNow(User user, String orderType, PaymentStrategy paymentStrategy) {
        return checkOut(user, orderType, paymentStrategy, new NowOrderFactory());
    }

    Order checkOutScheduled(User user, String orderType, PaymentStrategy paymentStrategy, String scheduledTime) {
        return checkOut(user, orderType, paymentStrategy, new ScheduledOrderFactory(scheduledTime));
    }

    Order checkOut(User user, String orderType, PaymentStrategy paymentStrategy, OrderFactory orderFactory) {
        Cart cart = user.getCart();
        Restaurant restaurant = cart.getRestaurant();
        List<MenuItems> menu = cart.getItems();
        double totalCost = cart.getTotalPrice();

        Order order = orderFactory.createOrder(user, cart, restaurant, menu, paymentStrategy, orderType);
        OrderManager.getInstance().addOrder(order);

        return order;
    }

    void payOrder(User user, Order order) {
        boolean isPaymentSuccess = order.processPayment();

        if(isPaymentSuccess) {
            NotificationService notificationService = new NotificationService();
            notificationService.sendNotification(order);
        }
    }
}
