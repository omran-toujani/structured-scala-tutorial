package com.lansrod.scala.genericclasses

/*Contravariance
 *
 * A type parameter A of a generic class can be made contravariant by using the annotation -A.
 * This creates a subtyping relationship between the class and its type parameter that is similar, but opposite to what we get with covariance.
 * That is, for some class Writer[-A],
 * making A contravariant implies that for two types A and B where A is a subtype of B, Writer[B] is a subtype of Writer[A].
 */

//Consider the Cat, Dog, and Animal classes defined above for the following example:
abstract class Printer[-A] {
  def print(value: A): Unit
}

//A Printer[A] is a simple class that knows how to print out some type A. Let’s define some subclasses for specific types:

class AnimalPrinter extends Printer[Animal] {
  def print(animal: Animal): Unit =
    println("The animal's name is: " + animal.name)
}

class CatPrinter extends Printer[Cat] {
  def print(cat: Cat): Unit =
    println("The cat's name is: " + cat.name)
}

//If a Printer[Cat] knows how to print any Cat to the console, and a Printer[Animal] knows how to print any Animal to the console,
//it makes sense that a Printer[Animal] would also know how to print any Cat.
//The inverse relationship does not apply, because a Printer[Cat] does not know how to print any Animal to the console.
//Therefore, we should be able to substitute a Printer[Animal] for a Printer[Cat], if we wish, and making Printer[A] contravariant
//allows us to do exactly that.

object Contravariance extends App {
  
  val myCat: Cat = Cat("Boots")

  def printMyCat(printer: Printer[Cat]): Unit = {
    printer.print(myCat)
  }

  val catPrinter: Printer[Cat] = new CatPrinter
  val animalPrinter: Printer[Animal] = new AnimalPrinter

  printMyCat(catPrinter)
  printMyCat(animalPrinter)
  
}
