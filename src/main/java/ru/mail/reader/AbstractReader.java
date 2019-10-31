package ru.mail.reader;

import ru.mail.trade.RawTrade;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class AbstractReader implements Reader {

    protected RawTrade getTrade(InputStreamReader reader) {
        BufferedReader bufferedReader = new BufferedReader(reader);
        RawTrade rawTrade = new RawTrade();
        String line;
        Pattern typeFieldPattern = Pattern.compile("(?<=type).+");
        Pattern typeValuePattern = Pattern.compile("\\w+");
        Pattern priceFieldPattern = Pattern.compile("(?<=price).+");
        Pattern priceValuePattern = Pattern.compile("[\\w\\.,]+");
        try {
            while ((line = bufferedReader.readLine()) != null) {
                rawTrade.setType(parseMatch(typeFieldPattern.matcher(line), typeValuePattern));
                rawTrade.setPrice(parseMatch(priceFieldPattern.matcher(line), priceValuePattern));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rawTrade;
    }

    private String parseMatch(Matcher FieldMatcher, Pattern valuePattern) {
        String value = null;
        if (FieldMatcher.find()) {
            Matcher valueMatcher = valuePattern.matcher(FieldMatcher.group());
            value = valueMatcher.find() ? valueMatcher.group() : null;
        }
        return value;
    }
}
