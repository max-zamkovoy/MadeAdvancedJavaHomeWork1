package ru.mail.trade.buider;

import ru.mail.trade.RawTrade;
import ru.mail.trade.Trade;

public interface Builder {

    Trade create(RawTrade rawTrade);
}
