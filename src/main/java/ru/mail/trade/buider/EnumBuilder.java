package ru.mail.trade.buider;

import ru.mail.trade.RawTrade;
import ru.mail.trade.Trade;
import ru.mail.trade.TradeEnum;

public class EnumBuilder implements Builder {

    @Override
    public Trade create(RawTrade rawTrade) {
        return TradeEnum.valueOf(rawTrade.getType()).create(rawTrade.getPrice());
    }
}
