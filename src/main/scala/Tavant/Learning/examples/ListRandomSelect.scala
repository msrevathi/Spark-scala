package Tavant.Learning.examples

object ListRandomSelect extends App {

  def randomSelect(x:Int, list: List[String]):List[String]={

    if(list.nonEmpty)list.take(x) else List.empty
  }
  println(randomSelect(3, List("a", "b", "c", "d", "f", "g", "h")))
}

/**
(**) Extract a given number of randomly selected elements from a list.
Example:
scala> randomSelect(3, List('a, 'b, 'c, 'd, 'f, 'g, 'h))
res0: List[Symbol] = List('e, 'd, 'a)
Hint: Use the solution to problem P20
  **/