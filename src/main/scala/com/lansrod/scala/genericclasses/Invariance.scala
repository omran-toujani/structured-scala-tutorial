package com.lansrod.scala.genericclasses

/*Invariance
	Generic classes in Scala are invariant by default. This means that they are neither covariant nor contravariant.
	In the context of the following example, Container class is invariant.
	A Container[Cat] is not a Container[Animal], nor is the reverse true.
  */

class Container[A](value: A) {
  private var _value: A = value
  def getValue: A = _value
  def setValue(value: A): Unit = {
    _value = value
  }
}

object Invariance extends App {
  //It may seem like a Container[Cat] should naturally also be a Container[Animal],
  //but allowing a mutable generic class to be covariant would not be safe.
  //In this example, it is very important that Container is invariant.
  //Supposing Container was actually covariant, something like this could happen:

  val catContainer: Container[Cat] = new Container(Cat("Felix"))
  val animalContainer: Container[Animal] = catContainer.asInstanceOf[Container[Animal]]
  //val animalContainer: Container[Animal] = catContainer

  animalContainer.setValue(Dog("Spot"))
  val cat: Cat = catContainer.getValue // Oops, we'd end up with a Dog assigned to a Cat
  //println(cat)

  //Fortunately, the compiler stops us long before we could get this far.
  //It gives an error
}
