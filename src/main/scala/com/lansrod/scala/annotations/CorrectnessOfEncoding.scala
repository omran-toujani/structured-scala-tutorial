package com.lansrod.scala.annotations

/*Annotations that ensure correctness of encodings
	Certain annotations will actually cause compilation to fail if a condition(s) is not met.
	For example, the annotation @tailrec ensures that a method is tail-recursive.
 	Tail-recursion can keep memory requirements constant. Here’s how it’s used in a method which calculates the factorial:
 */

object CorrectnessOfEncoding extends App {

  import scala.annotation.tailrec

  def factorial(x: Int): Int = {

    @tailrec
    def factorialHelper(x: Int, accumulator: Int): Int = {
      if (x == 1) accumulator else factorialHelper(x - 1, accumulator * x)
    }
    factorialHelper(x, 1)
  }

  //The factorialHelper method has the @tailrec which ensures the method is indeed tail-recursive.
  //If we were to change the implementation of factorialHelper to the following, it would fail:

  /*import scala.annotation.tailrec

  def factorial(x: Int): Int = {
    @tailrec
    def factorialHelper(x: Int): Int = {
      if (x == 1) 1 else x * factorialHelper(x - 1)
    }
    factorialHelper(x)
	}
	*/

  //We would get the message “Recursive call not in tail position”.

}
