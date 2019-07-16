package com.lansrod.scala.currying

object Currying extends App {
  //Multiple Parameters List(Currying)

  /*Methods may define multiple parameter lists. When a method is called with a fewer number of parameter lists,
   * then this will yield a function taking the missing parameter lists as its arguments. This is formally known as currying.
   */

  //Here is an example, defined in Traversable trait from Scala collections:
  type A
  type B
  def foldLeft[B](z: B)(op: (B, A) => B): B = z

  //foldLeft applies a binary operator op to an initial value z and all elements of this traversable, going left to right.
  //Shown below is an example of its usage.

  //Starting with an initial value of 0, foldLeft here applies the function (m, n) => m + n
  //to each element in the List and the previous accumulated value.

  val numbers = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
  val res = numbers.foldLeft(0)((m, n) => m + n)

  println(res) // 55
  println()
  //Multiple parameter lists have a more verbose invocation syntax; and hence should be used sparingly. Suggested use cases include:

  //SINGLE FUNCTIONAL PARAMETER
  /*In case of a single functional parameter, like op in the case of foldLeft above, multiple parameter
   * lists allow a concise syntax to pass an anonymous function to the method. Without multiple parameter lists, the code would look like this:
   */
  val rt = numbers.foldLeft(0)({ (m: Int, n: Int) => m + n })
  println(rt)
  println()

  //Note that the use of multiple parameter lists here also allows us to take advantage of Scala type inference
  //to make the code more concise as shown below; which would not be possible in a non-curried definition.
  println(numbers.foldLeft(0)(_ + _))

  //Above statement numbers.foldLeft(0)(_ + _) allows us to fix the parameter z and pass around a partial function and reuse it as shown below:

  val numberFunc = numbers.foldLeft(List[Int]())_
  //println(numberFunc)

  val squares = numberFunc((xs, x) => xs :+ x * x)
  println(squares.toString()) // List(1, 4, 9, 16, 25, 36, 49, 64, 81, 100)

  val cubes = numberFunc((xs, x) => xs :+ x * x * x)
  println(cubes.toString()) // List(1, 8, 27, 64, 125, 216, 343, 512, 729, 1000)

  //Finally, foldLeft and foldRight can be used in any of the following terms,
  numbers.foldLeft(0)((sum, item) => sum + item) // Generic Form
  numbers.foldRight(0)((sum, item) => sum + item) // Generic Form

  numbers.foldLeft(0)(_ + _) // Curried Form
  numbers.foldRight(0)(_ + _) // Curried Form

  (0 /: numbers)(_ + _) // Used in place of foldLeft
  (numbers :\ 0)(_ + _) // Used in place of foldRight

  //IMPLICIT PARAMETERS
  //To specify certain parameters in a parameter list as implicit, multiple parameter lists should be used. An example of this is:
  //def execute(arg: Int)(implicit ec: ExecutionContext) = ???

}
