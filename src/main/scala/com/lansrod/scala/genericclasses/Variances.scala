package com.lansrod.scala.genericclasses

/*Variance is the correlation of subtyping relationships of complex types and the subtyping relationships of their component types.
 * Scala supports variance annotations of type parameters of generic classes, to allow them to be covariant, contravariant,
 * or invariant if no annotations are used. The use of variance in the type system allows us to make intuitive connections between complex types,
 * whereas the lack of variance can restrict the reuse of a class abstraction.
 */

object Variances extends App {

  //Example:
  class Foo[+A] // A covariant class
  class Bar[-A] // A contravariant class
  class Baz[A] // An invariant class

  /*Covariance
	A type parameter A of a generic class can be made covariant by using the annotation +A.
 	For some class List[+A], making A covariant implies that for two types A and B where A is a subtype of B, then List[A] is a subtype of List[B].
 	This allows us to make very useful and intuitive subtyping relationships using generics.
  */

  /*Contravariance
  A type parameter A of a generic class can be made contravariant by using the annotation -A.
  This creates a subtyping relationship between the class and its type parameter that is similar, but opposite to what we get with covariance.
  That is, for some class Writer[-A],
  making A contravariant implies that for two types A and B where A is a subtype of B, Writer[B] is a subtype of Writer[A].
  */

  /*Invariance
	Generic classes in Scala are invariant by default. This means that they are neither covariant nor contravariant.
	In the context of the following example, Container class is invariant.
	A Container[Cat] is not a Container[Animal], nor is the reverse true.
  */

  /*Other Examples
	Another example that can help one understand variance is trait Function1[-T, +R] from the Scala standard library.
	Function1 represents a function with one argument, where the first type parameter T represents the argument type,
	and the second type parameter R represents the return type. A Function1 is contravariant over its argument type,
	and covariant over its return type. For this example we’ll use the literal notation A => B to represent a Function1[A, B].
   */
  abstract class SmallAnimal extends Animal
  case class Mouse(name: String) extends SmallAnimal

  /*Suppose we’re working with functions that accept types of animals, and return the types of food they eat.
   * If we would like a Cat => SmallAnimal (because cats eat small animals), but are given a Animal => Mouse instead, our program will still work.
   * Intuitively an Animal => Mouse will still accept a Cat as an argument, because a Cat is an Animal, and it returns a Mouse,
   * which is also a SmallAnimal. Since we can safely and invisibly substitute the former for the latter,
   * we can say Animal => Mouse is a subtype of Cat => SmallAnimal.
   */
  
  
}


