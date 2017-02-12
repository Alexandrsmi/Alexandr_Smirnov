package ru.job4j;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertEquals;

/**
 * @author Aleksandr Smirnov.
 * @version 1
 * @since 11.02.2017.
 */
public class DropAbuseTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(DropAbuseTest.class);

    @Test
    public void getDropAbuseTest() throws IOException {
        DropAbuse dropAbuse = new DropAbuse();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        final String[] abuse = new String[]{"0", ",", "s"};
        final String testString = "12'0o, clocks";
        final String expectedResult = "12'o clock";
        dropAbuse.getDropAbuse(new ByteArrayInputStream(testString.getBytes()), byteArrayOutputStream, abuse);
        LOGGER.info(String.format("Expected: %s, Result %s",expectedResult, byteArrayOutputStream.toString()));
        assertEquals(expectedResult, byteArrayOutputStream.toString());
    }
}
