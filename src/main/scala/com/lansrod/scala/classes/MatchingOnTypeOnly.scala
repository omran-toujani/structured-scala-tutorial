package com.lansrod.scala.classes

object MatchingOnTypeOnly extends App {

  //Matching on type only
  //You can match on the type like so:

  abstract class Device

  case class Phone(model: String) extends Device {
    def screenOff = "Turning screen off"
  }
  case class Computer(model: String) extends Device {
    def screenSaverOn = "Turning screen saver on..."
  }

  def goIdle(device: Device) = device match {
    case p: Phone => p.screenOff
    case c: Computer => c.screenSaverOn
  }

  //def goIdle has a different behavior depending on the type of Device.
  //This is useful when the case needs to call a method on the pattern.
  //It is a convention to use the first letter of the type as the case identifier (p and c in this case).

  val sg = Phone("samsung")
  val hp = Computer("HP")
  println(goIdle(sg))
  // println(goIdle(hp))

}