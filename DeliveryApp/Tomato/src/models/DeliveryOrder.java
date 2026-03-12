package models;

import java.util.List;

public class DeliveryOrder extends Order{
    private String address;

    public DeliveryOrder() {
        this.address = "";
    }

    public String getType() {
        return  "Delivery";
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }
}
