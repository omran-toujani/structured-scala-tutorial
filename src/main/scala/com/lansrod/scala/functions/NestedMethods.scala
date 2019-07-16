package com.lansrod.scala.functions

object NestedMethods extends App {

  def factorial(x: Int): Int = {
    def fact(x: Int, accumulator: Int): Int = {
      if (x <= 1) accumulator
      else fact(x - 1, x * accumulator)
    }
    fact(x, 1)
  }

  println("Factorial of 2: " + factorial(2))
  println("Factorial of 3: " + factorial(3))

  //The same hhh just for kidding
  def fact(x: Int): Int = {
    def factIter(x: Int, accumulator: Int): Int = {
      if (x <= 1) accumulator
      else factIter(x - 1, x * accumulator)
    }
    factIter(x, 1)
  }

}