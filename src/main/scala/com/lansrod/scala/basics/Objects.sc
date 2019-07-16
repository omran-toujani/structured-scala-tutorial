package com.lansrod.scala.basics

object Objects {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  //Objects: Objects are single instances of their own definitions. You can think of them as singletons of their own classes.
  //You can define objects with the object keyword.

  object IdFactory {
    private var counter = 0
    def create(): Int = {
      counter += 1
      counter
    }
  }

  //You can access an object by referring to its name.
  val newId: Int = IdFactory.create()             //> newId  : Int = 1
  println(newId) // 1                             //> 1
  val newerId: Int = IdFactory.create()           //> newerId  : Int = 2
  //println(newerId) // 2

}