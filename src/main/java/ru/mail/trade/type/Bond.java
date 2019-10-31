package ru.mail.trade.type;

import ru.mail.trade.TradeAbstract;

public class Bond extends TradeAbstract {

    public static final String NAME = "BOND";

    public Bond(Double price) {
        super(price);
    }
}
