package ru.mail.reader;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import ru.mail.trade.RawTrade;

import java.io.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@RunWith(PowerMockRunner.class)
@PrepareForTest(ArgumentFileReader.class)
public class ArgumentFileReaderTest {

    private static final String FILE_NAME = "File Name";

    private Reader reader;

    @Mock
    private PrintStream printStream;

    @Mock
    private File file;

    @Mock
    private FileReader fileReader;

    @Mock
    private BufferedReader bufferedReader;

    @Before
    public void initialization() {
        reader = new ArgumentFileReader();
    }

    @Test(expected = NullPointerException.class)
    public void reedWithNullArgs() {
        reader.reed(null);
    }

    @Test
    public void reedWithEmptyArgs() {
        assertNull(reader.reed(new String[]{}));
    }

    @Test(expected = NullPointerException.class)
    public void reedWithArgsAndNullFileName() {
        reader.reed(getArgs(null));
    }

    @Test
    public void reedWithArgsAndEmptyFileName() {
        System.setErr(printStream);
        reader.reed(getArgs(StringUtils.EMPTY));
        verify(printStream).println(any(FileNotFoundException.class));
    }

    @Test
    public void reedWithArgsAndFileName() throws Exception {
        mockBufferedReader();
        reader.reed(getArgs(FILE_NAME));
        PowerMockito.verifyNew(FileReader.class).withArguments(eq(file));
    }

    @Test
    public void readWithoutData() throws Exception {
        mockBufferedReader();
        mockReadLines(StringUtils.EMPTY);
        RawTrade rawTrade = reader.reed(getArgs(FILE_NAME));
        assertNull(rawTrade.getPrice());
        assertNull(rawTrade.getType());
    }

    @Test
    public void readWithJsonFormat() throws Exception {
        mockBufferedReader();
        mockReadLines("{\\n\"Trade\":{\\n\"type\":\"FX_SPOT\",\\n\"price\":\"100\"\\n}\\n}");
        RawTrade rawTrade = reader.reed(getArgs(FILE_NAME));
        assertEquals(Double.valueOf(100), rawTrade.getPrice());
        assertEquals("FX_SPOT", rawTrade.getType());
    }

    @Test
    public void readWithIncorrectFormat() throws Exception {
        mockBufferedReader();
        mockReadLines("Trade- [\\ntype=(FX_SPOT),\\nprice=[100,5]\\n:-)");
        RawTrade rawTrade = reader.reed(getArgs(FILE_NAME));
        assertEquals(Double.valueOf(100.5), rawTrade.getPrice());
        assertEquals("FX_SPOT", rawTrade.getType());
    }

    private String[] getArgs(String value) {
        String[] args = new String[1];
        args[0] = value;
        return args;
    }

    private void mockBufferedReader() throws Exception {
        PowerMockito.whenNew(File.class).withArguments(FILE_NAME).thenReturn(file);
        PowerMockito.whenNew(FileReader.class).withAnyArguments().thenReturn(fileReader);
        PowerMockito.whenNew(BufferedReader.class).withAnyArguments().thenReturn(bufferedReader);
    }

    private void mockReadLines(String lines) throws IOException {
        Mockito.when(bufferedReader.readLine()).thenReturn(FILE_NAME, ArrayUtils.add(lines.split("\n"), null));
    }
}
