package ru.mail.trade;

import ru.mail.util.Utils;

public class RawTrade {

    private String type;
    private Double price;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        if (this.type == null) {
            this.type = type;
        }
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(String price) {
        if (this.price == null) {
            this.price = Utils.convertNumber(price);
        }
    }
}
