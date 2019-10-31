package ru.mail.trade.type;

import ru.mail.trade.TradeAbstract;

public class IrSwap extends TradeAbstract {

    public static final String NAME = "IR_SWAP";

    public IrSwap(Double price) {
        super(price);
    }
}
