package com.paytmlabs.challenge;

import java.util.*;

/**
 * Implementation of the simple moving average algorithm backed by queue (double-linked list) implementation.
 * LinkedList implementation of the mentioned data structure allows efficient (constant time) adding
 * elements for calculation as well as calculating moving average with predictable demand of memory to store
 * N element in LinkedList object.
 *
 * @param <N> the type of elements used by com.paytmlabs.challenge.MovingAverage implementation
 */
public class SimpleMovingAverage<N extends Number> implements MovingAverage<N>{

    /**
     * Sequence of elements (window) used for calculation of moving average
     */
    private final Queue<N> window = new LinkedList<>();

    /**
     * Number of elements in the moving average 'window'
     */
    private final int windowSize;

    /**
     * Variable used to store the sum of all elements in the window
     */
    private double sum = 0f;

    /**
     * Constructor of the com.paytmlabs.challenge.SimpleMovingAverage
     *
     * @param windowSize number of elements in the moving average 'window'
     */
    public SimpleMovingAverage(int windowSize){
        if(windowSize <= 0){
            throw new IllegalArgumentException("Moving average window size must be greater then zero.");
        }
        this.windowSize = windowSize;
    }

    /**
     * Add element to the queue and poll element if queue size exceeds 'window' size.
     * On each call total sum of elements within a window is calculated
     *
     * @param value next element
     */
    @Override
    public void addElement(N value) {
        window.offer(value);
        sum += value.doubleValue();
        if (window.size() > windowSize) {
            sum -= window.poll().doubleValue();
        }
    }

    /**
     * Calculation of the simple moving average by dividing precalculated sum of elements by the 'window' size
     *
     * @return double value of the moving average
     */
    @Override
    public double getCurrentAverage(){
        return window.size() == 0 ? 0: sum / window.size();
    }

    /**
     * Return unmodifiable copy of {@link List} with elements in 'window'
     *
     * @return list of elements
     */
    public List<N> getElements() {
        return List.copyOf(window);
    }
}