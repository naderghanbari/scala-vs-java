package syntax.parameters.clazz.scala

import java.awt.Color

class Shape(val size: Int, color: Color, name: String) {
  val fullName = color + " " + name + " " + size

  def compare(that: Shape) = this.size > that.size
}
