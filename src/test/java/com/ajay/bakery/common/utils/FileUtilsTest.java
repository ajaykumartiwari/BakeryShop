package com.ajay.bakery.common.utils;

import org.junit.Assert;
import org.junit.Test;

import com.ajay.bakery.common.exceptions.ReaderException;
import com.ajay.bakery.common.utils.FileUtils;

import java.util.List;

import static com.ajay.bakery.common.Constants.PRODUCT_CSV_FILE;
import static com.ajay.bakery.common.utils.TestData.INVALID_CSV_FILE;

public class FileUtilsTest {
    @Test
    public void testReadFileValid() throws Exception {
        List<String> strings = FileUtils.readFileText(PRODUCT_CSV_FILE);
        Assert.assertNotNull(strings);
        Assert.assertEquals(3, strings.size());
    }

    @Test(expected = ReaderException.class)
    public void testReadFileInvalid() throws Exception {
        FileUtils.readFileText(INVALID_CSV_FILE);
    }
}
