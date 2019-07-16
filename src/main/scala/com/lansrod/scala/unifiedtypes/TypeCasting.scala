package com.lansrod.scala.unifiedtypes

object TypeCasting extends App {

  // Value types can be cast in the following way: Byte => Short => Int( Int <= Char) => Long => Float => Double

  val x: Long = 987654321
  val y: Float = x // 9.8765434E8 (note that some precision is lost in this case)

  val face: Char = '☺'
  val number: Int = face // 9786

  //Casting is unidirectional. This will not compile:
  //val x: Long = 987654321
  //val y: Float = x // 9.8765434E8
  //val z: Long = y // Does not conform

  //Nothing and Null
  
  /**Nothing is a subtype of all types, also called the bottom type. There is no value that has type Nothing.
	A common use is to signal non-termination such as a thrown exception, program exit, or an infinite loop
	(i.e., it is the type of an expression which does not evaluate to a value, or a method that does not return normally).

	Null is a subtype of all reference types (i.e. any subtype of AnyRef).
	It has a single value identified by the keyword literal null. Null is provided mostly
	for interoperability with other JVM languages and should almost never be used in Scala code.
	We’ll cover alternatives to null later in the tour.
	*/

}