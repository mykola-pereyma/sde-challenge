package com.paytmlabs.challenge;

import java.util.List;

/**
 * interface for a data structure that can provide the moving average of the last N elements added,
 * add elements to the structure and get access to the elements
 *
 * @param <N> the type of elements used by com.paytmlabs.challenge.MovingAverage implementation
 */
public interface MovingAverage<N extends Number> {

    /**
     * Add next element to find moving average
     *
     * @param value next element
     */
    void addElement(N value);

    /**
     * Return current value of moving average
     * @return double value
     */
    double getCurrentAverage();

    /**
     * Returns List of elements used for moving average calculation
     * @return list of elements
     */
    List<N> getElements();
}
