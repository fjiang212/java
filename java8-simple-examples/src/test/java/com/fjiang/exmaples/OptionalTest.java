package com.fjiang.exmaples;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
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

    @Test(expected = NullPointerException.class)
    public void testCreationWithNPE() {
        String name = null;
        Optional<String> opt = Optional.of(name);
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

    @Test
    public void testIsPresent() {
        Optional<String> opt = Optional.of("fjiang");
        assertTrue(opt.isPresent());
        opt.ifPresent(name -> System.out.println(name.length()));

        opt = Optional.ofNullable(null);
        assertFalse(opt.isPresent());
    }

    public String getMyDefault() {
        System.out.println("Getting Default Value");
        return "Default Value";
    }

    @Test
    public void testElse() {
        String text = null;

        System.out.println("Using orElseGet:");

        // The orElseGet API is similar to orElse. However, instead of taking a value to
        // return if the Optional value is not present, it takes a supplier functional
        // interface which is invoked and returns the value of the invocation:
        String defaultText = Optional.ofNullable(text).orElseGet(this::getMyDefault);
        assertEquals("Default Value", defaultText);

        System.out.println("Using orElse:");
        // The orElse API is used to retrieve the value wrapped inside an Optional
        // instance. It takes one parameter which acts as a default value. With orElse,
        // the wrapped value is returned if it is present and the argument given to
        // orElse is returned if the wrapped value is absent:
        defaultText = Optional.ofNullable(text).orElse(getMyDefault());
        assertEquals("Default Value", defaultText);
    }

    @Test
    public void testGet() {
        Optional<String> opt = Optional.of("fjiang");
        String name = opt.get();

        assertEquals("fjiang", name);
    }

    @Test(expected = NoSuchElementException.class)
    public void testGetWithException() {
        Optional<String> opt = Optional.ofNullable(null);
        String name = opt.get();
    }

    @Test
    public void testFilter() {
        Integer year = 2016;
        Optional<Integer> yearOptional = Optional.of(year);
        boolean is2016 = yearOptional.filter(y -> y == 2016).isPresent();
        assertTrue(is2016);
        boolean is2017 = yearOptional.filter(y -> y == 2017).isPresent();
        assertFalse(is2017);
    }

    @Test
    public void testMap() {
        List<String> companyNames = Arrays.asList("paypal", "oracle", "", "microsoft", "", "apple");
        Optional<List<String>> listOptional = Optional.of(companyNames);

        int size = listOptional.map(List::size).orElse(0);
        assertEquals(6, size);
    }
}
