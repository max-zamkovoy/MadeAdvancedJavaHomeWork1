package ru.mail;

import ru.mail.trade.RawTrade;
import ru.mail.reader.ArgumentFileReader;
import ru.mail.reader.Reader;
import ru.mail.trade.Trade;
import ru.mail.trade.buider.Builder;
import ru.mail.trade.buider.SwitchBuilder;

public class Main {

    private static Reader reader = new ArgumentFileReader();
    private static Builder builder = new SwitchBuilder();

    public static void main(String[] args) {
        RawTrade rawTrade = reader.reed(args);
        Trade trade = builder.create(rawTrade);
    }
}
