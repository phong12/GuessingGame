package com.collegeboard.guess;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;

public class ConsoleReaderTest {

    @Test
    public void testGetInput() throws Exception {
        ConsoleReader instance = new ConsoleReader();
        ByteArrayInputStream in = new ByteArrayInputStream("ready".getBytes());
        System.setIn(in);
        Assert.assertEquals("ready", instance.getInput());
    }
}