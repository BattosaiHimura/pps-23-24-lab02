package task3

import org.junit.*
import org.junit.Assert.*
import task3.GCD.gcd

class GCDTest :
    @Test def shouldCalculateGCD(): Unit = {
        assertEquals(4, gcd(12, 8))
        assertEquals(7, gcd(7, 14))
    }

    @Test def GCDShouldBeOtherThanZeroWhenOneValueIsZero(): Unit = {
        assertEquals(8, gcd(0, 8))
        assertEquals(7, gcd(7, 0))
    }