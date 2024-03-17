package task2

object Compositions extends App :
    def compose(f: Int => Int, g: Int => Int): Int => Int = (x: Int) => f(g(x))

    println(compose(_ -1, _ * 2)(5))