package ru.mail.trade.type;

import ru.mail.trade.TradeAbstract;

public class CommoditySpot extends TradeAbstract {

    public static final String NAME = "COMMODITY_SPOT";

    public CommoditySpot(Double price) {
        super(price);
    }
}
