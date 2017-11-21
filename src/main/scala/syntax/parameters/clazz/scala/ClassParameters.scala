package syntax.parameters.clazz.scala

import java.awt.Color

object ClassParameters extends App {
  val small = new Shape(size = 42, Color.BLACK, "Circle")
  val big = new Shape(size = 100, Color.BLACK, "Circle")

  println(small.compare(big))
}
