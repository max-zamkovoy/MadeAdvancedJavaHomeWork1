# Advanced Java Homework 1 for MADE course

### Usage of Readers

    private static Reader reader = new ArgumentFileReader();
    private static Reader reader = new ConsoleReader();

### Usage of Builders

    private static Builder builder = new SwitchBuilder();
    private static Builder builder = new EnumBuilder();

### File contents for tests

    Trade: {
        type: FX_SPOT,
        price: 100.5
    }

But you can use any format. For example:

    Trade- [
        type=(FX_SPOT),
        price=[100,5]
    :-)