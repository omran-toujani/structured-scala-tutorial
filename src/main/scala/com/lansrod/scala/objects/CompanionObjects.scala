package com.lansrod.scala.objects

object CompanionObjects extends App {

  /*Companion objects:
	An object with the same name as a class is called a companion object. Conversely, the class is the object’s companion class.
	A companion class or object can access the private members of its companion.
	Use a companion object for methods and values which are not specific to instances of the companion class.
   */

  import scala.math._

  case class Circle(radius: Double) {
    import Circle._
    def area: Double = calculateArea(radius)
  }

  object Circle {
    private def calculateArea(radius: Double): Double = Pi * pow(radius, 2.0)
  }

  val circle1 = new Circle(5.0)

  println(circle1.area)
  //The class Circle has a member area which is specific to each instance, and the
  //singleton object Circle has a method calculateArea which is available to every instance.

  //The companion object can also contain factory methods:

  class Email(val username: String, val domainName: String)

  object Email {
    def fromString(emailString: String): Option[Email] = {
      emailString.split('@') match {
        case Array(a, b) => Some(new Email(a, b))
        case _ => None
      }
    }
  }

  val scalaCenterEmail = Email.fromString("scala.center@epfl.ch")
  scalaCenterEmail match {
    case Some(email) => println(
      s"""Registered an email
       |Username: ${email.username}
       |Domain name: ${email.domainName}
     """)
    case None => println("Error: could not parse email")
  }

  //The object Email contains a factory fromString which creates an Email instance from a String.
  //We return it as an Option[Email] in case of parsing errors.

  //Note: If a class or object has a companion, both must be defined in the same file.
  //To define companions in the REPL, either define them on the same line or enter :paste mode.

  /*
   * Notes for Java programmers
  	 static members in Java are modeled as ordinary members of a companion object in Scala.

     When using a companion object from Java code, the members will be defined in a companion class with a static modifier.
     This is called static forwarding. It occurs even if you haven’t defined a companion class yourself.
  */

}