package com.ajay.bakery.action;

import static com.ajay.bakery.common.Constants.LINE;
import static com.ajay.bakery.common.Constants.ORDER_TEXT;
import static com.ajay.bakery.io.impl.ConsoleWriter.write;

import com.ajay.bakery.io.Reader;
import com.ajay.bakery.io.impl.UserInputReader;

public class Bakery {
    private Reader reader = UserInputReader.getInstance();
    private OrderProcessor orderProcessor;
    private boolean open;

    public void open() {
        this.open = true;
        orderProcessor = new OrderProcessor(this);

        while (open) {
            write(ORDER_TEXT);
            write(orderProcessor.process(reader.readValue()));
            write(LINE);
        }
    }

    public void close() {
        this.open = false;
    }
}
