package task4

import org.junit.*
import org.junit.Assert.*
import task4.Shapes.*
import task4.Shapes.Shape.*

class ShapesTest:
    @Test def shouldCalculateSquarePerimeter(): Unit = {
        var side: Int = 10
        var square = Shape.Square(side)
        assertTrue(perimeter(square) == side * 4)
    }

    @Test def shouldScaleSquare(): Unit = {
        var side: Int = 10
        var square = Shape.Square(side)
        assertTrue(perimeter(scale(square, 2)) == perimeter(square) * 2)
    }

    @Test def shouldCalculateRectanglePerimeter(): Unit = {
        var base: Int = 10
        var height: Int = 5
        var rectangle = Shape.Rectangle(base, height)
        assertTrue(perimeter(rectangle) == base * 2 + height * 2)
    }

    @Test def shouldScaleRectangle(): Unit = {
        var base: Int = 10
        var height: Int = 5
        var rectangle = Shape.Rectangle(base, height)
        assertTrue(perimeter(scale(rectangle, 2)) == perimeter(rectangle) * 2)
    }

    @Test def shouldCalculateCirclePerimeter(): Unit = {
        var radius: Int = 4
        var circle = Shape.Circle(radius)
        assertTrue(perimeter(circle) == 2 * scala.math.Pi * radius)
    }

    @Test def shouldScaleCircle(): Unit = {
        var radius: Int = 4
        var circle = Shape.Circle(radius)
        assertTrue(perimeter(scale(circle, 2)) == perimeter(circle) * 2)
    }