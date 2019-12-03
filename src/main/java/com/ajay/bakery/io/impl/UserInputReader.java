package com.ajay.bakery.io.impl;

import java.util.Scanner;

import com.ajay.bakery.io.Reader;

import static java.util.Objects.isNull;

public class UserInputReader implements Reader {
    private static Reader reader;
    private static Scanner scanner;

    private UserInputReader() {
        scanner = new Scanner(System.in);
    }

    public static Reader getInstance() {
        if(isNull(reader)) {
            reader = new UserInputReader();
        }

        return reader;
    }

    @Override
    public String readValue() {
        return scanner.nextLine();
    }
}
