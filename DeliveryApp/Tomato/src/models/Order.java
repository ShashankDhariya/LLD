package models;

import strategies.PaymentStrategy;

import java.util.List;

public abstract class Order {
    static int nextOrderId = 0;
    int orderId;
    User user;
    Restaurant restaurant;
    List<MenuItems> items;
    PaymentStrategy paymentStrategy;
    double totalPrice;
    String scheduled;

    public Order(int orderId, User user, Restaurant restaurant, List<MenuItems> items, double totalPrice, String scheduled, PaymentStrategy paymentStrategy) {
        this.orderId = nextOrderId++;
        this.user = user;
        this.restaurant = restaurant;
        this.items = items;
        this.totalPrice = totalPrice;
        this.paymentStrategy = paymentStrategy;
        this.scheduled = "";
    }

    protected Order() {
    }

    public boolean processPayment() {
        if(paymentStrategy != null) {
            paymentStrategy.Pay(totalPrice);
            return true;
        }

        else {
            System.out.println("Payment failed");
            return false;
        }
    }

    public abstract String getType();

    public int getOrderId() {
        return orderId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public PaymentStrategy getPaymentStrategy() {
        return paymentStrategy;
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public String getSchedule() {
        return scheduled;
    }

    public void setSchedule(String schedule) {
        this.scheduled = schedule;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<MenuItems> getMenuItems() {
        return items;
    }

}
