package models;

public class User {
    private int user_id;
    private String name;
    private String location;

    private Cart cart;

    public User(int user_id, String name, String location) {
        this.user_id = user_id;
        this.name = name;
        this.location = location;
        this.cart = new Cart();
    }

    public int getUser_id() {
        return user_id;
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

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
