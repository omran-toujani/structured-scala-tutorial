package com.lansrod.scala.objects

package logging

/*An object is a class that has exactly one instance. It is created lazily when it is referenced, like a lazy val.
	As a top-level value, an object is a singleton.
	As a member of an enclosing class or as a local value, it behaves exactly like a lazy val.
	*/

//Defining a singleton object
//An object is a value. The definition of an object looks like a class, but uses the keyword object:
object Box

//Here’s an example of an object with a method:

object Logger {
  def info(message: String): Unit = println(s"INFO: $message")
}

object SingletonObjects extends App {

  //The method info can be imported from anywhere in the program. Creating utility methods like this is a common use case for singleton objects.
  //Let’s see how to use info in another package:

  import logging.Logger.info

  class Project(name: String, daysToComplete: Int)

  class Test {
    val project1 = new Project("TPS Reports", 1)
    val project2 = new Project("Website redesign", 5)
    info("Created projects") // Prints "INFO: Created projects"
  }

  //The info method is visible because of the import statement, import logging.Logger.info.

  //Imports require a “stable path” to the imported symbol, and an object is a stable path.

  //Note: If an object is not top-level but is nested in another class or object, then the object is “path-dependent” like any other member.
  //This means that given two kinds of beverages, class Milk and class OrangeJuice, a class member object NutritionInfo “depends”
  //on the enclosing instance, either milk or orange juice. milk.NutritionInfo is entirely distinct from oj.NutritionInfo.

}

