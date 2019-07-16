package com.lansrod.scala.basics

object Basics extends App {

  println(1) // 1
  println(1 + 1) // 2
  println("Hello!") // Hello!
  println("Hello," + " world!") // Hello, world!

  //Values : You can name results of expressions with the val keyword.

  val x = 1 + 1
  println(x) // 2

  //Values cannot be re-assigned.
  //x = 3 // This does not compile.

  //Variables: Variables are like values, except you can re-assign them. You can define a variable with the var keyword.
  var y = 1 + 1
  y = 3 // This compiles because "x" is declared with the "var" keyword.
  println(y * y) // 9

  //As with values, you can explicitly state the type if you want:

  var iter: Int = 17

  //Blocks: You can combine expressions by surrounding them with {}. We call this a block.
  //The result of the last expression in the block is the result of the overall block, too.
  println({
    val x = 1 + 1
    x + 1
  }) // 3

  //Functions: Functions are expressions that take parameters.
  //You can define an anonymous function (i.e. no name) that returns a given integer plus one:
  (x: Int) => x + 1

  //On the left of => is a list of parameters. On the right is an expression involving the parameters.
  val addOne = (x: Int) => x + 1
  println(addOne(1)) // 2

  //Functions may take multiple parameters.
  val add = (x: Int, y: Int) => x + y
  println(add(1, 2)) // 3

  //Or it can take no parameters.
  val getTheAnswer = () => 42
  println(getTheAnswer()) // 42
}