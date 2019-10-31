package ru.mail.trade.type;

import ru.mail.trade.TradeAbstract;

public class FxSpot extends TradeAbstract {

    public static final String NAME = "FX_SPOT";

    public FxSpot(Double price) {
        super(price);
    }
}
