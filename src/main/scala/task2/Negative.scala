package task2

object Negative extends App :

    // Lambda Negative
    val negLambda: (String => Boolean) => (String => Boolean) = (p: String => Boolean) => !p(_)

    // method
    def neg(p: String => Boolean): String => Boolean = (a: String) => !p(a)

    