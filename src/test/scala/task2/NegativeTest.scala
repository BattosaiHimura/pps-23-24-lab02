package task2

import org.junit.*
import org.junit.Assert.*
import Negative.*

class NegativeTest:
    @Test def NegativeLambdaShouldNegateStringPredicates(): Unit = {
        val empty: String => Boolean = _ == ""

        val notEmpty = negLambda(empty)
        assertTrue(notEmpty("foo"))
        assertFalse(notEmpty(""))
        assertTrue(notEmpty("foo") && !notEmpty(""))
    }

    @Test def NegativeMethodShouldNegateStringPredicates(): Unit = {
        val empty: String => Boolean = _ == ""

        val notEmpty = neg(empty)
        assertTrue(notEmpty("foo"))
        assertFalse(notEmpty(""))
        assertTrue(notEmpty("foo") && !notEmpty(""))
    }

    @Test def NegativeMethodShouldNegateNumberPredicates(): Unit = {
        val positive: Int => Boolean = _ >= 0

        val negative = neg(positive);
        assertTrue(negative(-1));
        assertFalse(negative(1));
        assertTrue(negative(-1) && !negative(1))
    }