package Tavant.Learning.examples

object FindElementsInArray extends App{


  // Complete the findNumber function below.
  def findNumber(arr: Array[Int], k: Int):String = {

      if (arr.contains(k)) "YES"
      else "NO"

  }

  println(findNumber(Array(1,2,3,4), 0))
}
