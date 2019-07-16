package com.lansrod.scala.functions

object HigherOrderFunctions extends App {
  /*Higher order functions take other functions as parameters or return a function as a result.
   * This is possible because functions are first-class values in Scala.
   * The terminology can get a bit confusing at this point, and we use the phrase “higher order function” for both methods and functions that take
   * functions as parameters or that return a function.
   */

  //One of the most common examples is the higher-order function "map" which is available for collections in Scala.
  val salaries = Seq(20000, 70000, 40000)
  val doubleSalary = (x: Int) => x * 2
  val newSalaries = salaries.map(doubleSalary) // List(40000, 140000, 80000)
  newSalaries.foreach(println)

  //doubleSalary is a function which takes a single Int, x, and returns x * 2. In general,
  //the tuple on the left of the arrow => is a parameter list and the value of the expression on the right is what gets returned.
  //On line 3, the function doubleSalary gets applied to each element in the list of salaries.
  println()

  //To shrink the code, we could make the function anonymous and pass it directly as an argument to map:
  val newSalariesS = salaries.map( x => x * 2) // List(40000, 140000, 80000)
  newSalariesS.foreach(println)
  println()
  //Notice how x is not declared as an Int in the above example.
  //That’s because the compiler can infer the type based on the type of function map expects.
  //An even more idiomatic way to write the same piece of code would be:
  val newSalariesI= salaries.map(_ * 2)
  newSalariesI.foreach(println)
  
  //Since the Scala compiler already knows the type of the parameters (a single Int), you just need to provide the right side of the function. 
  //The only caveat is that you need to use _ in place of a parameter name (it was x in the previous example).



}