package syntax.parameters.named.scala

import java.awt.Color

object NamedParameters extends App {
  val shape = Shape(color = Color.black, name = "Circle", size = 42)
  println(shape)
}
