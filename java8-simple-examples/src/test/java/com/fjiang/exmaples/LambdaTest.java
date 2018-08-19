package com.fjiang.exmaples;

import static org.junit.Assert.assertEquals;

import java.util.UUID;
import java.util.stream.Collectors;

import org.junit.Test;

public class LambdaTest {
    @Test
    public void testMapToOject() {
        String id = UUID.randomUUID().toString();

        String formatedValue = id.chars()
                                 .filter(e -> e != '-')
                                 .mapToObj(e -> String.valueOf((char) e))
                                 .limit(16)
                                 .collect(Collectors.joining(""));

        assertEquals(16, formatedValue.length());
    }
}
