package ru.mail.reader;

import ru.mail.trade.RawTrade;

public interface Reader {
    RawTrade reed(String[] args);
}
