package com.lansrod.scala.classes

object SealedClasses extends App {

  /*Traits and classes can be marked sealed which means all subtypes must be declared in the same file.
   * This assures that all subtypes are known.
   */

  sealed abstract class Furniture {
    def tostring(): String = "This is furniture !!!"
  }
  case class Couch() extends Furniture
  case class Chair() extends Furniture

  def findPlaceToSit(piece: Furniture): String = piece match {
    case a: Couch => "Lie on the couch"
    case b: Chair => "Sit on the chair"
  }

  //This is useful for pattern matching because we don’t need a “catch all” case.
  val chair = Chair()

  println(findPlaceToSit(chair))
  println(chair.tostring())

  //Scala’s pattern matching statement is most useful for matching on algebraic types expressed via case classes.
  //Scala also allows the definition of patterns independently of case classes, using unapply methods in extractor objects.

}