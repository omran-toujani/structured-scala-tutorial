package com.lansrod.scala.basics

  println("Welcome to the Scala worksheet")

  //Objects: Objects are single instances of their own definitions. You can think of them as singletons of their own classes.
  //You can define objects with the object keyword.

  object IdFactory {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(306); 
    private var counter = 0;System.out.println("""counter  : Int = """ + $show(counter ));$skip(65); 
    def create(): Int = {
      counter += 1
      counter
    };System.out.println("""create: ()Int""")}
  }

  //You can access an object by referring to its name.
  val newId: Int = IdFactory.create()
  println(newId) // 1
  val newerId: Int = IdFactory.create()
  println(newerId) // 2
