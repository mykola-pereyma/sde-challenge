## [PaytmLabs SDE Challenge](https://github.com/PaytmLabs/SDEChallenge)

## Codding question: Simple Moving Average implementation
Interface and implementation of the moving average algorithm

Requirements
Java 1.8+
Maven 3.6.0 (to build and run tests)

Implementation
Implementation of the simple moving average algorithm backed by queue (double-linked list) implementation.LinkedList implementation of the mentioned data structure allows efficient (constant time) adding elements for calculation as well as calculating moving average with predictable demand of memory to store N element in LinkedList object.
Main classes contain extensive javadoc documentation that describes original intent and implementation details.

Souce code structure:

    |-main-|
           |-java-|
                  |-com.paytmlabs.challenge-|
                                            |-MovingAverage.java (interface)
                                            |-SimpleMovingAverage.java (implementation)

    |-test-|
           |-java-|
                  |-com.paytmlabs.challenge-|
                                            |-SimpleMovingAverageTest.java (JUnit test cases)

Build
To build project and check that tests completed successfully run in parent dir: mvn clean package

## Design question: Design A Google Analytic like Backend System
Please look into file [Google Analytics System Design](./Google_Analytics_System_Design.pdf)
