package task4

object Shapes extends App :
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
        