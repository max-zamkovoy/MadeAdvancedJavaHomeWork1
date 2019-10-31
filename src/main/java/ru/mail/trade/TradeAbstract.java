package ru.mail.trade;

public abstract class TradeAbstract implements Trade {

    private Double price;

    public TradeAbstract(Double price) {
        this.price = price;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
