package task2

object Currying extends App :

    val p1: Double => Double => Double => Boolean = x => y => z => x <= y && y == z 
    val p2: (Double, Double, Double) => Boolean = (x,y,z) => x <= y && y == z
    def p3(x: Double)(y: Double)(z: Double): Boolean = x <= y && y == z
    def p4(x: Double, y: Double, z: Double): Boolean = x <= y && y == z

    println("With P1: curried lambda")
    println(p1(1)(2)(3)) // false
    println(p1(1)(3)(3)) // true
    println(p1(3)(3)(3)) // true
    println(p1(3)(3)(4)) // false
    println(p1(4)(3)(3)) // false
    println(p1(4)(3)(4)) // false

    println("With P2: non-curried lambda")
    println(p2(1, 2, 3)) // false
    println(p2(1, 3, 3)) // true
    println(p2(3, 3, 3)) // true
    println(p2(3, 3, 4)) // false
    println(p2(4, 3, 3)) // false
    println(p2(4, 3, 4)) // false

    println("With P3: curried method")
    println(p3(1)(2)(3)) // false
    println(p3(1)(3)(3)) // true
    println(p3(3)(3)(3)) // true
    println(p3(3)(3)(4)) // false
    println(p3(4)(3)(3)) // false
    println(p3(4)(3)(4)) // false

    println("With P4: non-curried method")
    println(p4(1, 2, 3)) // false
    println(p4(1, 3, 3)) // true
    println(p4(3, 3, 3)) // true
    println(p4(3, 3, 4)) // false
    println(p4(4, 3, 3)) // false
    println(p4(4, 3, 4)) // false