package task2

object Positive extends App :

    // Lambda
    val positiveLambda: Int => String = (n: Int) => n match
        case n if  n >= 0 => "positive"
        case n if n < 0 => "negative"

    println(positiveLambda(1));
    println(positiveLambda(0));
    println(positiveLambda(-1));


    // method
    def positiveFunc(n: Int): String = n match
        case n if n >= 0 => "positive"
        case n if n < 0 => "negative"

    println(positiveFunc(1));
    println(positiveFunc(0));
    println(positiveFunc(-1));
