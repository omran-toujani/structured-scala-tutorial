package com.lansrod.scala.annotations

/*Annotations associate meta-information with definitions.
 * For example, the annotation @deprecated before a method causes the compiler to print a warning if the method is used.
 */

object AnnotationDeprecated extends App {

  @deprecated("deprecation message", "release # which deprecates method")
  def hello = "hola"

  hello

  //This will compile but the compiler will print a warning: “there was one deprecation warning”.

  //An annotation clause applies to the first definition or declaration following it.
  //More than one annotation clause may precede a definition and declaration.
  //The order in which these clauses are given does not matter.

}

