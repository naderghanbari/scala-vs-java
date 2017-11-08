package syntax.parameters.grouped.scala

object GroupedParameters extends App {

  // Grouping args to make currying easier
  def divisibleBy(n: Int)(x: Int) = (x % n) == 0

  // Applying the multi-group function, just pass arguments in the same order and fashion that params are defined
  private val res1 = divisibleBy(5)(10)
  println(res1)

  // currying
  val divisibleByFive = divisibleBy(5)

  // applying the curried function
  private val res2 = divisibleByFive(10)
  println(res2)

  // Grouping arguments to be able to pass multiple varargs
  def multiSum(as: Int*)(bs: Int*)(cs: Int*) = as.sum * bs.sum * cs.sum

  // Passing multiple varargs
  val sum = multiSum(1, 2, 3)(4, 5, 6, 7, 9)(10, 11)
  println(multiSum())

}
