package ru.mail.util;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class UtilsTest {

    @Test
    public void convertNumberWithNullNumber() {
        assertNull(Utils.convertNumber(null));
    }

    @Test(expected = NumberFormatException.class)
    public void convertNumberWithEmptyNumber() {
        Utils.convertNumber(StringUtils.EMPTY);
    }

    @Test(expected = NumberFormatException.class)
    public void convertNumberWithIncorrectNumber() {
        Utils.convertNumber("Incorrect");
    }

    @Test
    public void convertNumberWithIntNumber() {
        assertEquals(new Double(42), Utils.convertNumber("42"));
    }

    @Test
    public void convertNumberWithZeroNumber() {
        assertEquals(new Double(0), Utils.convertNumber("0"));
    }

    @Test
    public void convertNumberWithNegativeNumber() {
        assertEquals(new Double(-55), Utils.convertNumber("-55"));
    }

    @Test
    public void convertNumberWithDoubleNumber() {
        assertEquals(new Double(42.42), Utils.convertNumber("42,42"));
    }
}
