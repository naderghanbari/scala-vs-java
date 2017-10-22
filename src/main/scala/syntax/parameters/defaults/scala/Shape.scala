package syntax.parameters.defaults.scala

case class Shape(color: java.awt.Color, name: String, size: Int) {

  /** Method (function) with default parameters.
    *
    * @param resolution First param with no default, must be provided.
    * @param details    Second param, has a default, can be omitted.
    * @param out        Third param, has a default, can be omitted.
    */
  def renderShape(resolution: Int, details: Boolean = false, out: java.io.OutputStream = System.out): Unit = ()

}
