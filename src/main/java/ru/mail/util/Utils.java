package ru.mail.util;

public class Utils {

    public static Double convertNumber(String number) {
        return number != null ? Double.valueOf(number.replace(",", ".")) : null;
    }
}
