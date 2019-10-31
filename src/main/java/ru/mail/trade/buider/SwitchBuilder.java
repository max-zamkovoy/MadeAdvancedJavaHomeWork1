package ru.mail.trade.buider;

import ru.mail.trade.RawTrade;
import ru.mail.trade.Trade;
import ru.mail.trade.TradeAbstract;
import ru.mail.trade.type.Bond;
import ru.mail.trade.type.CommoditySpot;
import ru.mail.trade.type.FxSpot;
import ru.mail.trade.type.IrSwap;

public class SwitchBuilder implements Builder {

    @Override
    public Trade create(RawTrade rawTrade) {
        Double price = rawTrade.getPrice();
        Trade trade;
        switch (rawTrade.getType()) {
            case FxSpot.NAME:
                trade = new FxSpot(price);
                break;
            case Bond.NAME:
                trade = new Bond(price);
                break;
            case IrSwap.NAME:
                trade = new IrSwap(price);
                break;
            case CommoditySpot.NAME:
                trade = new CommoditySpot(price);
                break;
            default:
                trade = new TradeAbstract(price) {};
        }
        return trade;
    }
}
