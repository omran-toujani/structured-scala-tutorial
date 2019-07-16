package com.lansrod.scala.traits

object ClassCompositionWithMixins {

  //Mixins are traits which are used to compose a class.

  def main(args: Array[String]) {

    abstract class A {
      val message: String
    }

    class B extends A {
      val message = "I'm an instance of class B"
    }

    trait C extends A {
      def loudMessage = message.toUpperCase()
      def charInMessage = message.length()
    }

    class D extends B with C

    //class E extends B with A // leads to an error: A must be a trait to be mixed in(after the keyword with, must be a Trait).

    val d = new D
    println(d.message) // I'm an instance of class B
    println(d.loudMessage) // I'M AN INSTANCE OF CLASS B
    println(d.charInMessage) // 26

    // Class D has a superclass B and a mixin C.
    // Classes can only have one superclass but many mixins (using the keywords extends and with respectively).
    // The mixins and the superclass may have the same supertype.

    // Second Example:using an abstract class

    abstract class AbsIterator {

      type A
      def hasNext(): Boolean
      def next(): A

    }

    //The class has an abstract type T and the standard iterator methods.

    //Next, we’ll implement a concrete class (all abstract members T, hasNext, and next have implementations):

    class StringIterator(s: String) extends AbsIterator {
      type T = Char
      private var i = 0
      def hasNext = i < s.length
      def next() = {
        val ch = s charAt i
        i += 1
        ch.asInstanceOf[A] // making a cast of variable ch to be of type A
        // asInstanceOf[T] allows us to make cast from type to type
      }
    }

    val myStrinIter = new StringIterator("Omran")

    println(myStrinIter.next())
    println(myStrinIter.next())
    println(myStrinIter.next())
    println(myStrinIter.next())
    println(myStrinIter.next())
    //println(myStrinIter.next()) //returns an error:  String index out of range: 5

    //StringIterator takes a String and can be used to iterate over the String (e.g. to see if a String contains a certain character).
    //Now let’s create a trait which also extends AbsIterator.
    type T = Char
    trait RichIterator extends AbsIterator {
      def foreach(f: T => Unit): Unit = while (hasNext) f(next().asInstanceOf[Char])
    }

    //This trait implements foreach by continually calling the provided function f: T => Unit on the next element (next())
    //as long as there are further elements (while (hasNext)).
    // Because RichIterator is a trait, it doesn’t need to implement the abstract members of AbsIterator.

    //We would like to combine the functionality of StringIterator and RichIterator into a single class.
    //object StringIteratorTest extends App {
    class RichStringIter extends StringIterator("Scala") with RichIterator
    val richStringIter = new RichStringIter
    richStringIter foreach println // prints: s c a l a
    //}

    //The new class RichStringIter has StringIterator as a superclass and RichIterator as a mixin.

    //With single inheritance we would not be able to achieve this level of flexibility.

  }
}