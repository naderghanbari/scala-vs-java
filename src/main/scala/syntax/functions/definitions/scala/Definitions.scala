package syntax.functions.definitions.scala

object Definitions extends App {

  def function(param1: Int, param2: String): String = {
    if (param1 > 0) param2
    else param2.reverse
  }

  def abs(x: Int) = if (x < 0) -x else x

  def random = math.random()

  val i = 10

  // i = 20 wont' compile due to 'reassignment to val'

  var str = "Lorem"
  str = "Now I point to something else"

}
