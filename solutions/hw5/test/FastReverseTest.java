package hw5.test;

import base.Selector;
import base.TestCounter;
import hw3.test.ReverseTest;

/**
 * @author Georgiy Korneev (kgeorgiy@kgeorgiy.info)
 */
public final class FastReverseTest {
    public static final int MAX_SIZE = 1_000_000 / TestCounter.DENOMINATOR;
    public static final Selector SELECTOR = ReverseTest.selector(FastReverseTest.class, MAX_SIZE);

    private FastReverseTest() {
    }

    public static void main(final String... args) {
        SELECTOR.main(args);
    }
}
