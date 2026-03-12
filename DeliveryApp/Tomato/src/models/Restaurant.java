package models;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private static int nextRestaurantId = 0;
    private int restaurantId;
    private String name;
    private String location;
    private List<MenuItems> menu = new ArrayList<MenuItems>();

    public Restaurant(String name, String location) {
        this.restaurantId = ++nextRestaurantId;
        this.name = name;
        this.location = location;
    }

    public void addMenu(MenuItems menuItem) {
        menu.add(menuItem);
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<MenuItems> getMenu() {
        return menu;
    }
}
