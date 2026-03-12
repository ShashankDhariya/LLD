package managers;
import models.Restaurant;

import java.util.ArrayList;
import java.util.List;

public class RestaurantManager {
    List<Restaurant> restaurants = new ArrayList<>();

    static  RestaurantManager restaurantManager = null;
    RestaurantManager() {
//        private constructor
    }

    public static RestaurantManager getInstance() {
        if (restaurantManager == null) {
            restaurantManager = new RestaurantManager();
        }

        return restaurantManager;
    }

    public void addRestaurant(Restaurant restaurant) {
        restaurants.add(restaurant);
    }

    void removeRestaurant(Restaurant restaurant) {
        restaurants.remove(restaurant);
    }

    public List<Restaurant> getRestaurantByLocation(String location) {
        List<Restaurant> resLocation = new ArrayList<>();
        for(Restaurant restaurant : restaurants) {
            if(restaurant.getLocation().equals(location)) {
                resLocation.add(restaurant);
            }
        }

        return resLocation;
    }

}
