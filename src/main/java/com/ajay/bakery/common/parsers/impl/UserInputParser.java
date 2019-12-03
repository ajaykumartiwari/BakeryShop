package com.ajay.bakery.common.parsers.impl;

import java.util.List;
import java.util.Map;

import com.ajay.bakery.common.exceptions.InputException;
import com.ajay.bakery.common.parsers.Parser;

import static com.ajay.bakery.common.Constants.INVALID_USER_INPUT;
import static java.lang.Integer.parseInt;
import static java.util.stream.Collectors.toMap;

public class UserInputParser implements Parser<Integer> {

    @Override
    public Map<String, Integer> parseList(List<String> lines) {
        try {
            return lines.stream()
                    .map(line -> line.split(USER_INPUT_SEPARATOR))
                    .collect(toMap(o -> o[1].trim(), o -> parseInt(o[0].trim())));
        } catch (Exception ex) {
            throw new InputException(INVALID_USER_INPUT);
        }
    }
}
