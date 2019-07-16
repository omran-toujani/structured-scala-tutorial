package com.lansrod.scala.basics

object Traits extends App {

  //Traits: Traits are types containing certain fields and methods. Multiple traits can be combined.
  //You can define traits with trait keyword.
  //trait Greeter {
  //def greet(name: String): Unit
  //}

  //Traits can also have default implementations.
  trait Greeter {
    def greet(name: String): Unit =
      println("Hello, " + name + "!")
  }

  trait Salut {
    def bonjour(name: String): Unit =
      println("Bonjour, " + name + "!")
  }

  //You can extend traits with the extends keyword and override an implementation with the override keyword.
  class DefaultGreeter extends Greeter with Salut

  class CustomizableGreeter(prefix: String, postfix: String) extends Greeter {
    override def greet(name: String): Unit = {
      println(prefix + name + postfix)
    }
  }

  val greeter = new DefaultGreeter()
  greeter.greet("Scala developer") // Hello, Scala developer!
  greeter.bonjour("omran")
  
  val customGreeter = new CustomizableGreeter("How are you, ", "?")
  customGreeter.greet("Scala developer") // How are you, Scala developer?
 

  //Here, DefaultGreeter extends only a single trait, but it could extend multiple traits

}