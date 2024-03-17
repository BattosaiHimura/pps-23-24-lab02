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