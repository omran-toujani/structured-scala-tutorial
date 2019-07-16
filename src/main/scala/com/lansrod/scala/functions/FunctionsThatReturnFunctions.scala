package com.lansrod.scala.functions

object FunctionsThatReturnFunctions {
  /*Functions that return functions
There are certain cases where you want to generate a function. Here’s an example of a method that returns a function.
*
*/

  def main(args: Array[String]) {

    def urlBuilder(ssl: Boolean, domainName: String): (String, String) => String = {
      val schema = if (ssl) "https://" else "http://"
      (endpoint: String, query: String) => s"$schema$domainName/$endpoint?$query"
    }

    val domainName = "www.example.com"
    def getURL = urlBuilder(ssl = true, domainName)
    val endpoint = "users"
    val query = "id=1"
    val url = getURL(endpoint, query) // "https://www.example.com/users?id=1": String
    println(url)

    //Notice the return type of urlBuilder (String, String) => String.
    //This means that the returned anonymous function takes two Strings and returns a String.
    //In this case, the returned anonymous function is (endpoint: String, query: String) => s"https://www.example.com/$endpoint?$query".

  }
}
