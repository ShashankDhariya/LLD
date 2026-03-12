package models;

import java.util.List;

public class Cart {
    Restaurant restaurant;
    List<MenuItems> items;

    public void addToCart(MenuItems menuItems) {
        if(restaurant == null) {
            System.out.println("Select Restaurant before adding items");
            return;
        }

        items.add(menuItems);
    }

    public int getTotalPrice() {
        return 0;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public List<MenuItems> getItems() {
        return items;
    }
}
