package consegna

object Lab02 extends App :
    // TASK 1, svolto in autonomia
    println("Hello, Scala!")
    //-------------------------------------------------------------------------------

    // TASK 2, svolto in autonomia

    // Positive
    // Lambda
    val positiveLambda: Int => String = (n: Int) => n match
        case n if  n >= 0 => "positive"
        case n if n < 0 => "negative"

    println(positiveLambda(1)) // positive
    println(positiveLambda(0)) // positive
    println(positiveLambda(-1)) // negative


    // method
    def positiveFunc(n: Int): String = n match
        case n if n >= 0 => "positive"
        case n if n < 0 => "negative"

    println(positiveFunc(1)) // positive
    println(positiveFunc(0)) // positive
    println(positiveFunc(-1)) // negative

    // Negative 
    // Lambda
    val negLambda: (String => Boolean) => (String => Boolean) = (p: String => Boolean) => !p(_)

    // method
    //def neg(p: String => Boolean): String => Boolean = (a: String) => !p(a)
    def neg[X](p: X => Boolean): X => Boolean = (a: X) => !p(a)

    val empty: String => Boolean = _ == ""
    val notEmpty = negLambda(empty)

    println(notEmpty("foo")) // true
    println(notEmpty("")) // false
    println(notEmpty("foo") && !notEmpty("")) // true

    val positive: Int => Boolean = _ >= 0
    val negative = neg(positive)

    println(negative(-1)) // true
    println(negative(1)) // false
    println(negative(-1) && !negative(1)) // true

    // Currying
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

    // Compositions
    //def compose(f: Int => Int, g: Int => Int): Int => Int = (x: Int) => f(g(x))
    // generic type, generics order is key
    def compose[A, B, C](f: B => C, g: A => B): A => C = (a: A) => f(g(a))

    def double: Double => Double = _ * 2
    def halve: Double => Double = _ / 2
    def dec: Double => Double = _ - 1

    println(compose(dec, double)(5)) // 9.0
    println(compose(halve, dec)(10)) // 4,5
    //-------------------------------------------------------------------------------

    // TASK 3, svolto in autonomia
    @annotation.tailrec
    def gcd(a: Int, b: Int): Int = b match
        case 0 => a
        case _ if a > b => gcd(b, a % b)
        case _ if a < b => gcd(b, a)

    println(gcd(12, 8)) // 4
    println(gcd(7, 14)) // 7
    println(gcd(3, 0)) // 3
    println(gcd(0, 11)) // 11
    //-------------------------------------------------------------------------------

    // TASK 4, svolto in autonomia
    enum Shape:
        case Square(side: Double)
        case Circle(radius: Double)
        case Rectangle(base: Double, height: Double)

    object Shape:
        def perimeter(shape: Shape): Double = shape match
            case Square(side) => side * 4
            case Rectangle(base, height) => base * 2 + height * 2
            case Circle(radius) => 2 * scala.math.Pi * radius
        def scale(shape: Shape, alpha: Double) : Shape = shape match
            case Square(side) => Square(side * alpha)
            case Rectangle(base, height) => Rectangle(base * alpha, height * alpha)
            case Circle(radius) => Circle(radius * alpha)

    import consegna.Lab02.Shape.*

    println(perimeter(Shape.Square(10))) // 40
    println(perimeter(scale(Shape.Square(10), 3))) // 120

    println(perimeter(Shape.Rectangle(4, 2))) // 12
    println(perimeter(scale(Shape.Rectangle(3, 6), 2))) // 36

    println(perimeter(Shape.Circle(1))) // 2Pi
    println(perimeter(scale(Shape.Circle(1), 2))) // Pi * 2
    //-------------------------------------------------------------------------------

    // TASK 5, svolto in autonomia
    import task5.Optionals.Optional
    import task5.Optionals.Optional.*
    
    def map[A, B](optional: Optional[A], f: A => B): Optional[B] = optional match
      case Empty() => Optional.Empty()
      case Maybe(value: A) => Optional.Maybe(f(value))

    def filter[A](optional: Optional[A], f: A => Boolean): Optional[A] = optional match
      case Maybe(value: A) if f(value) => optional
      case _ => Empty()