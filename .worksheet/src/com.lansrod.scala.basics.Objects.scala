package com.lansrod.scala.basics

object Objects {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(94); 
  println("Welcome to the Scala worksheet")

  //Objects: Objects are single instances of their own definitions. You can think of them as singletons of their own classes.
  //You can define objects with the object keyword.

  object IdFactory {
    private var counter = 0
    def create(): Int = {
      counter += 1
      counter
    }
  };$skip(392); 

  //You can access an object by referring to its name.
  val newId: Int = IdFactory.create();System.out.println("""newId  : Int = """ + $show(newId ));$skip(22); 
  println(newId);$skip(40);  // 1
  val newerId: Int = IdFactory.create();System.out.println("""newerId  : Int = """ + $show(newerId ))}
  //println(newerId) // 2

}
