package com.lansrod.scala.basics

object Classes {
  //You can define classes with the class keyword followed by its name and constructor parameters.

  class Greeter(prefix: String, suffix: String) {

    //The return type of the method greet is Unit, which says there’s nothing meaningful to return.
    //It’s used similarly to void in Java and C. (A difference is that because every Scala expression must have some value,
    //there is actually a singleton value of type Unit, written (). It carries no information.)
    def greet(name: String): Unit =
      println(prefix + name + suffix)

    def greeting(name: String) {
      println(prefix + name + suffix)
    }
  }

  def main(args: Array[String]) {

    val greeter = new Greeter("Hello ", " !!!")

    greeter.greeting("omran")
    greeter.greet("omran")

    val greeterG = new Greeter("Hello, ", "!")
    greeterG.greet("Scala developer") // Hello, Scala developer!
  }

}