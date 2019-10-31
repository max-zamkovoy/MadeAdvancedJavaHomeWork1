package ru.mail.trade.builder;

import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Test;
import ru.mail.trade.RawTrade;
import ru.mail.trade.Trade;
import ru.mail.trade.buider.Builder;
import ru.mail.trade.buider.EnumBuilder;
import ru.mail.trade.type.FxSpot;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class EnumBuilderTest {

    private static final String TRADE_TYPE = "FX_SPOT";

    private Builder builder;
    private RawTrade rawTrade;

    @Before
    public void initialization() {
        builder = new EnumBuilder();
        rawTrade = new RawTrade();
    }

    @Test(expected = NullPointerException.class)
    public void createWithNullRawTrade() {
        builder.create(null);
    }

    @Test(expected = NullPointerException.class)
    public void createWithNullType() {
        builder.create(rawTrade);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createWithEmptyType() {
        rawTrade.setType(StringUtils.EMPTY);
        rawTrade.setPrice("100");
        builder.create(rawTrade);
    }

    @Test
    public void createWithNullPrice() {
        rawTrade.setType(TRADE_TYPE);
        rawTrade.setPrice(null);
        Trade trade = builder.create(rawTrade);
        assertNull(trade.getPrice());
    }

    @Test
    public void createWithTypeAndPriceAndTestOnCorrectPrice() {
        rawTrade.setType(TRADE_TYPE);
        rawTrade.setPrice("100.5");
        Trade trade = builder.create(rawTrade);
        assertEquals(Double.valueOf(100.5), trade.getPrice());
    }

    @Test
    public void createWithTypeAndPriceAndTestOnCorrectType() {
        rawTrade.setType(TRADE_TYPE);
        rawTrade.setPrice("100.5");
        Trade trade = builder.create(rawTrade);
        assertTrue(trade instanceof FxSpot);
    }
}
