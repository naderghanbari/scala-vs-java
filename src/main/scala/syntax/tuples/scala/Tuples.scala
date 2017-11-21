package syntax.tuples.scala


object Tuples extends App {
  def connect(): (String, Int) = ("https://localhost", 8080)

  val serverAndPort: (String, Int) = connect()

  serverAndPort.swap

  // Iterate over elements
  serverAndPort.productIterator.foreach {
    // No type information here though because Tuples are heterogeneous
    any =>
      println(any)
  }

  serverAndPort._1 // first element
  serverAndPort._2 // second element
  type ServerPort = (String, Int)

  // Define type aliases if you use the tuple type frequently
  // This will further reduce the noise and make the code more readable
  type Quad = (String, Int, String, Int)
  val quadruple: Quad = ("A", 1, "B", 2)

  // Deconstruction, discard not needed elements binding them to _
  val (a, one, b, two) = quadruple

  val entry = "A" -> 1
  val myMap = Map("A" -> 1, "B" -> 2)
}
