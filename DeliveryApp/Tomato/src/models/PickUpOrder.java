package models;

import java.util.List;

public class PickUpOrder extends DeliveryOrder{
    String restaurantAddress;

    public PickUpOrder() {
        restaurantAddress = "";
    }

    public String getType() {
        return "PickUpOrder";
    }

    public void setRestaurantAddress(String restaurantAddress) {
        this.restaurantAddress = restaurantAddress;
    }

    public String getRestaurantAddress() {
        return restaurantAddress;
    }
}
