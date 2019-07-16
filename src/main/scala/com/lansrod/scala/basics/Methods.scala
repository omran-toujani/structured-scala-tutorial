package com.lansrod.scala.basics

object Methods {

  def main(args: Array[String]) {

    //Methods: Methods look and behave very similar to functions, but there are a few key differences between them.
    //Methods are defined with the def keyword. def is followed by a name, parameter lists, a return type, and a body.
    def add(x: Int, y: Int): Int = x + y
    println(add(1, 2)) // 3

    //Methods can take multiple parameter lists.
    def addThenMultiply(x: Int, y: Int)(multiplier: Int): Int = (x + y) * multiplier
    println(addThenMultiply(1, 2)(3)) // 9

    //Or no parameter lists at all.
    def name: String = System.getProperty("user.name")
    println("Hello, " + name + "!")

    //There are some other differences, but for now, you can think of them as something similar to functions.
    //Methods can have multi-line expressions as well.
    def getSquareString(input: Double): String = {
      val square = input * input
      square.toString
    }

  }

}