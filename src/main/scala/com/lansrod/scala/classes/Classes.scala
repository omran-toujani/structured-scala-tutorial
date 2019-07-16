package com.lansrod.scala.classes

object Classes {

  def Greeting(name: String): String = {
    return s"Hello, $name !!!"
  }

  //A minimal class definition is simply the keyword class and an identifier. Class names should be capitalized.
  class User

  //The keyword new is used to create an instance of the class.
  //User has a default constructor which takes no arguments because no constructor was defined.
  //However, you’ll often want a constructor and class body

  class Point(var x: Int, var y: Int) {

    def move(dx: Int, dy: Int): Unit = {

      x = x + dx
      y = y + dy
    }

    override def toString(): String = s"($x,$y)"
  }

  /**
   * This Point class has four members: the variables x and y and the methods move and toString.
   * Unlike many other languages, the primary constructor is in the class signature (var x: Int, var y: Int).
   * The move method takes two integer arguments and returns the Unit value (), which carries no information.
   * This corresponds roughly with void in Java-like languages.
   * toString, on the other hand, does not take any arguments but returns a String value.
   * Since toString overrides toString from AnyRef, it is tagged with the override keyword.
   */
  abstract class AbstrcatBean(var x: Int, var y: Int) {

    def add(): Int = {
      return x + y
    }

    def product(x: Int, y: Int): Int = {

      return x * y
    }

  }

  val x = 10
  val y = 11

  /*
   *  class Bean extends AbstrcatBean(x, y) {

    val m: Int
    val n: Int

    override def product(m: Int, n: Int): Int = {
      return x * x * y * y
    }

  }
  *
  */

  abstract class connector(T: AbstrcatBean) {

  }

  /**
   * Private Members and Getter/Setter Syntax
   * Members are public by default. Use the private access modifier to hide them from outside of the class.
   *
   */

  class PointP {
    private var _x = 0
    private var _y = 0
    private val bound = 100

    def x = _x
    def x_=(newValue: Int): Unit = {
      if (newValue < bound) _x = newValue else printWarning
    }

    def y = _y
    def y_=(newValue: Int): Unit = {
      if (newValue < bound) _y = newValue else printWarning
    }

    private def printWarning = println("WARNING: Out of bounds")
  }

  val point1 = new PointP
  point1.x = 99
  point1.y = 101 // prints the warning

  /**
   * In this version of the Point class, the data is stored in private variables _x and _y.
   *  There are methods def x and def y for accessing the private data. def x_= and def y_= are
   *  for validating and setting the value of _x and _y. Notice the special syntax for the setters: the method has _= appended
   * to the identifier of the getter and the parameters come after.
   */
  
  def main(args: Array[String]) {

    val user1 = new User
    val p = new Point(1, 17)
    println(p)
    println(Greeting("omran"))

    val count: Int = 0
    var year = 0
    if (count == 0) {
      year = 2014
      println(year)
    } else
      year = 2015

  }
}

