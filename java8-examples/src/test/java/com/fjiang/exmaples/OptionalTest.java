package com.fjiang.exmaples;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.Optional;

import org.junit.Test;

//http://www.baeldung.com/java-optional
public class OptionalTest {

    @Test
    public void testCreation() {
        Optional<String> empty = Optional.empty();
        assertFalse(empty.isPresent());

        String name = "fjiang";
        Optional<String> opt = Optional.of(name);
        assertEquals("Optional[fjiang]", opt.toString());
    }

    @Test
    public void testCreationNullable() {
        String name = null;
        Optional<String> opt = Optional.ofNullable(name);
        assertEquals("Optional.empty", opt.toString());

        name = "fjiang";
        opt = Optional.ofNullable(name);
        assertEquals("Optional[fjiang]", opt.toString());
    }
}
