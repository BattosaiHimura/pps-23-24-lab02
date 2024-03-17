package task2

object Compositions extends App :

    //def compose(f: Int => Int, g: Int => Int): Int => Int = (x: Int) => f(g(x))
    // generic type ordering is key
    def compose[A, B, C](f: B => C, g: A => B): A => C = (a: A) => f(g(a))

    def halve: Double => Double = _ / 2
    def dec: Double => Double = _ - 1

    println(compose(halve, dec)(10)) // 4,5