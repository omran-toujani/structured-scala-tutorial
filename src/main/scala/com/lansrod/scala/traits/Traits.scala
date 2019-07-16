package com.lansrod.scala.traits

/**
 * Traits are used to share interfaces and fields between classes.
 * They are similar to Java 8’s interfaces. Classes and objects can extend traits but
 *  traits cannot be instantiated and therefore have no parameters.
 */

object Traits extends App {
  //Defining a trait
  //A minimal trait is simply the keyword trait and an identifier:
  trait HairColor

  //Traits become especially useful as generic types and with abstract methods.
  trait Iterator[A] {
    def hasNext: Boolean
    def next(): A
  }

  //Extending the trait Iterator[A] requires a type A and implementations of the methods hasNext and next.

  class IntIterator(to: Int) extends Iterator[Int] {

    private var current = 0

    //implement hasNext()
    override def hasNext: Boolean = current < to

    //implement next()
    override def next(): Int = {
      if (hasNext) {
        val t = current
        current += 1
        t
      } else 0
    }

  }

  val myIter: IntIterator = new IntIterator(3)
  println(myIter.hasNext)
  println(myIter.next()) // prints 0
  println(myIter.next()) // prints 1
  println(myIter.next()) // prints 2
  println(myIter.next()) // prints 0 because our 'to' (upper bound) is equal to 3
  println(myIter.next()) // prints 0 the same as before

  //This IntIterator class takes a parameter to as an upper bound.
  //It extends Iterator[Int] which means that the next method must return an Int.

  //Subtyping: Where a given trait is required, a subtype of the trait can be used instead.

  import scala.collection.mutable.ArrayBuffer // we can use import in everey point of the code

  trait Pet {
    val name: String
  }

  class Cat(val name: String) extends Pet
  class Dog(val name: String) extends Pet

  val dog = new Dog("Harry")
  val cat = new Cat("Sally")

  val animals = ArrayBuffer.empty[Pet]
  animals.append(dog)
  animals.append(cat)
  animals.foreach(pet => println(pet.name)) // Prints Harry Sally
  
  // The trait Pet has an abstract field name which gets implemented by Cat and Dog in their constructors.
  // On the last line, we call pet.name which must be implemented in any subtype of the trait Pet.
}