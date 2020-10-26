package com.paytmlabs.challenge;

import org.junit.jupiter.api.Test;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests of simple moving average implementation
 */
public class SimpleMovingAverageTest {

    @Test
    public void testWindowSizeLessOrEqualsZero(){
       Throwable throwable = assertThrows(IllegalArgumentException.class,
                () -> new SimpleMovingAverage<Double>(-5));
       assertEquals(throwable.getMessage(), "Moving average window size must be greater then zero.");
    }

    @Test
    public void testEmptyMovingAverage(){
        MovingAverage<Integer> avg  = new SimpleMovingAverage<>(3);

        assertEquals(avg.getCurrentAverage(), 0);
    }

    @Test
    public void testWithSingleElement(){
        MovingAverage<Integer> avg  = new SimpleMovingAverage<>(3);
        avg.addElement(5);

        assertEquals(avg.getCurrentAverage(), 5.0);
    }

    @Test
    public void testStaticWindowAverage(){
        MovingAverage<Integer> avg  = new SimpleMovingAverage<>(3);
        avg.addElement(1);
        avg.addElement(2);
        avg.addElement(3);

        assertEquals(avg.getCurrentAverage(), 2.0);
    }

    @Test
    public void testMovingWindowAverage(){
        MovingAverage<Integer> avg  = new SimpleMovingAverage<>(3);
        avg.addElement(1);
        avg.addElement(2);
        avg.addElement(3);
        avg.addElement(4);

        assertEquals(avg.getCurrentAverage(), 3.0);
    }

    @Test
    public void testEmptyWindow(){
        MovingAverage<Integer> avg  = new SimpleMovingAverage<>(3);

        assertTrue(avg.getElements().isEmpty());
    }

    @Test
    public void testStaticWindow(){
        MovingAverage<Integer> avg  = new SimpleMovingAverage<>(3);
        avg.addElement(1);

        Iterable<Integer> iterable = List.of(1);
        assertIterableEquals(avg.getElements(), iterable);
    }

    @Test
    public void testMovingWindow(){
        MovingAverage<Long> avg  = new SimpleMovingAverage<>(3);
        avg.addElement(1L);
        avg.addElement(2L);
        avg.addElement(3L);
        avg.addElement(4L);

        Iterable<Long> iterable = List.of(2L, 3L, 4L);
        assertIterableEquals(avg.getElements(), iterable);
    }
}
