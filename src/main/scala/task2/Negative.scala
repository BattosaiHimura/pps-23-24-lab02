package task2

object Negative extends App :

    // Lambda Negative
    val negLambda: (String => Boolean) => (String => Boolean) = (p: String => Boolean) => !p(_)

    // method
    def neg[X](p: X => Boolean): X => Boolean = (a: X) => !p(a)

    