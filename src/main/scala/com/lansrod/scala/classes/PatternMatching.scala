package com.lansrod.scala.classes

object PatternMatching extends App {
  /*Pattern matching is a mechanism for checking a value against a pattern.
   * A successful match can also deconstruct a value into its constituent parts.
   * It is a more powerful version of the switch statement in Java and it can likewise be used in place of a series of if/else statements.
   */

  //Syntax
  //A match expression has a value, the match keyword, and at least one case clause.
  import scala.util.Random

  val x: Int = Random.nextInt(10)

  x match {
    case 0 => "zero"
    case 1 => "one"
    case 2 => "two"
    case _ => "many"
  }
  //The val x above is a random integer between 0 and 10.
  //x becomes the left operand of the match operator and on the right is an expression with four cases.
  //The last case _ is a “catch all” case for any number greater than 2. Cases are also called alternatives.

  //Match expressions have a value.
  def matchTest(x: Int): String = x match {
    case 1 => "one"
    case 2 => "two"
    case _ => "many"
  }
  println(matchTest(3)) // many
  println(matchTest(1)) // one
  //This match expression has a type String because all of the cases return String. Therefore, the function matchTest returns a String.

  //Matching on case classes
  //Case classes are especially useful for pattern matching.

  abstract class Notification

  case class Email(sender: String, title: String, body: String) extends Notification

  case class SMS(caller: String, message: String) extends Notification

  case class VoiceRecording(contactName: String, link: String) extends Notification
  //Notification is an abstract super class which has three concrete Notification types implemented with case classes Email, SMS, and VoiceRecording.
  //Now we can do pattern matching on these case classes:

  def showNotification(notification: Notification): String = {
    notification match {
      case Email(email, title, _) =>
        s"You got an email from $email with title: $title"
      case SMS(number, message) =>
        s"You got an SMS from $number! Message: $message"
      case VoiceRecording(name, link) =>
        s"you received a Voice Recording from $name! Click the link to hear it: $link"
    }
  }
  val someSms = SMS("12345", "Are you there?")
  val someVoiceRecording = VoiceRecording("Tom", "voicerecording.org/id/123")

  println(showNotification(someSms)) // prints You got an SMS from 12345! Message: Are you there?

  println(showNotification(someVoiceRecording)) // you received a Voice Recording from Tom! Click the link to hear it: voicerecording.org/id/123

  //The function showNotification takes as a parameter the abstract type Notification and matches on the type of Notification
  //(i.e. it figures out whether it’s an Email, SMS, or VoiceRecording). In the case Email(email, title, _)
  // the fields email and title are used in the return value but the body field is ignored with _.
}
