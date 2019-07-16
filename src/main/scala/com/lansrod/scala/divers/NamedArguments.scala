package com.lansrod.scala.divers

object NamedArguments extends App {

  //When calling methods, you can label the arguments with their parameter names like so:

  def printName(first: String, last: String): Unit = {
    println(first + " " + last)
  }

  printName("John", "Smith") // Prints "John Smith"
  printName(first = "John", last = "Smith") // Prints "John Smith"
  printName(last = "Smith", first = "John") // Prints "John Smith"

  //Notice how the order of named arguments can be rearranged. However, if some arguments are named and others are not,
  //the unnamed arguments must come first and in the order of their parameters in the method signature.

  //printName(last = "Smith", "john") // error: positional after named argument

  //Note that named arguments do not work with calls to Java methods.


}