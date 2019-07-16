package com.lansrod.scala.functions

object FunctionsThatAcceptFunctions extends App {

  /*One reason to use higher-order functions is to reduce redundant code.
   *Let’s say you wanted some methods that could raise someone’s salaries by various factors.
   *Without creating a higher-order function, it might look something like this:
   */
  private def promotion(salaries: List[Double], promotionFunction: Double => Double): List[Double] =
    salaries.map(promotionFunction)

  def smallPromotion(salaries: List[Double]): List[Double] =
    promotion(salaries, salary => salary * 1.1)

  def bigPromotion(salaries: List[Double]): List[Double] =
    promotion(salaries, salary => salary * math.log(salary))

  def hugePromotion(salaries: List[Double]): List[Double] =
    promotion(salaries, salary => salary * salary)

  //The method "promotion" takes the salaries plus a function of type Double => Double
  //(i.e. a function that takes a Double and returns a Double) and returns the product.

  val salaries: List[Double] = List(20000, 70000, 40000)
  //promotion(salaries, salaries.foreach(s => bigPromotion(s)))

}