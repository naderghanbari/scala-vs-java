package syntax.parameters.defaults.scala

import java.awt.Color

object DefaultParameters extends App {
  val shape = Shape(color = Color.black, name = "Circle", size = 42)

  shape.renderShape(2048) // Use defaults for second and third params
  shape.renderShape(resolution = 1024) // Named param + Default Param
  shape.renderShape(resolution = 1024, details = true) // Default param only for third parameter
}
