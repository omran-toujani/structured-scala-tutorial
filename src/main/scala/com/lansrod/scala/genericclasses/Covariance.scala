package com.lansrod.scala.genericclasses

/*Covariance
	A type parameter A of a generic class can be made covariant by using the annotation +A.
 	For some class List[+A], making A covariant implies that for two types A and B where A is a subtype of B, then List[A] is a subtype of List[B].
 	This allows us to make very useful and intuitive subtyping relationships using generics.
  */

//Consider this simple class structure:

abstract class Animal {
  def name: String
}
case class Cat(name: String) extends Animal
case class Dog(name: String) extends Animal

/*
 * Both Cat and Dog are subtypes of Animal.
 * The Scala standard library has a generic immutable sealed abstract class List[+A] class, where the type parameter A is covariant.
 * This means that a List[Cat] is a List[Animal] and a List[Dog] is also a List[Animal].
 * Intuitively, it makes sense that a list of cats and a list of dogs are each lists of animals,
 * and you should be able to substitute either of them for a List[Animal].
 * In the following example, the method printAnimalNames will accept a list of animals as an argument and print their names each on a new line.
 * If List[A] were not covariant, the last two method calls would not compile, which would severely limit the usefulness of the printAnimalNames method.
 *
 */

object Covariance extends App {
  
  def printAnimalNames(animals: List[Animal]): Unit = {
    animals.foreach { animal =>
      println(animal.name)
    }
  }

  val cats: List[Cat] = List(Cat("Whiskers"), Cat("Tom"))
  val dogs: List[Dog] = List(Dog("Fido"), Dog("Rex"))

  printAnimalNames(cats)
  // Whiskers
  // Tom

  println()

  printAnimalNames(dogs)
  // Fido
  // Rex

}
