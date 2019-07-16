package com.lansrod.scala.functions

object CoercingMethodsIntoFunctions extends App {

  /*It is also possible to pass methods as arguments to higher-order functions because the Scala compiler will coerce the method into a function.
   */
  case class WeeklyWeatherForecast(temperatures: Seq[Double]) {

    private def convertCtoF(temp: Double) = temp * 1.8 + 32

    def forecastInFahrenheit: Seq[Double] = temperatures.map(convertCtoF) // <-- passing the method convertCtoF
  }

  val seq: Seq[Double] = Seq(12.54, 15.00, 26.15)
  val weather = WeeklyWeatherForecast(seq)
  weather.forecastInFahrenheit.foreach(println)
  //println(weather.forecastInFahrenheit)

  //Here the method convertCtoF is passed to forecastInFahrenheit.
  //This is possible because the compiler coerces convertCtoF to the function x => convertCtoF(x)
  //(note: x will be a generated name which is guaranteed to be unique within its scope).

}