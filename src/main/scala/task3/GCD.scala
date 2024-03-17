package task3

import u02.DefinedFunctions.abs

object GCD extends App :

    @annotation.tailrec
    def gcd(a: Int, b: Int): Int = b match
        case 0 => a
        case _ if a > b => gcd(b, a % b)
        case _ if a < b => gcd(b, a)

    println(gcd(12, 8)) // 4
    println(gcd(7, 14)) // 7