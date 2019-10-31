package ru.mail.reader;

import ru.mail.trade.RawTrade;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ArgumentFileReader extends AbstractReader {

    @Override
    public RawTrade reed(String[] args) {
        RawTrade rawTrade = null;
        if (args.length > 0) {
            File file = new File(args[0]);
            try {
                rawTrade = getTrade(new FileReader(file));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        return rawTrade;
    }
}
