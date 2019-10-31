package ru.mail.reader;

import ru.mail.trade.RawTrade;

import java.io.InputStreamReader;

public class ConsoleReader extends AbstractReader {

    @Override
    public RawTrade reed(String[] args) {
        return getTrade(new InputStreamReader(System.in));
    }
}
