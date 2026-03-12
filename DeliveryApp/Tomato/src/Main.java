import managers.RestaurantManager;
import models.MenuItems;
import models.Order;
import models.Restaurant;
import models.User;
import strategies.UPI;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        TomatoApp.initializeRestaurants();

        TomatoApp tomatoApp = new TomatoApp();
        User user = new User(101, "Rahul", "Dehradun");
        List<Restaurant> restaurants = tomatoApp.searchRestaurantsByLocation("Dehradun");

        if(!restaurants.isEmpty()){
            for(Restaurant restaurant : restaurants){
                System.out.println(restaurant.getName());
            }
        }

        else
            System.out.println("Restaurant not found");

        tomatoApp.selectRestaurant(user, restaurants.get(0));
        System.out.println("Restaurant Selected: " + restaurants.get(0).getName());

        tomatoApp.addToCart(user, "p11");
        tomatoApp.addToCart(user, "p22");

        Order order = tomatoApp.checkOutNow(user, "Delivery", new UPI());

        tomatoApp.payOrder(user, order);
    }
}