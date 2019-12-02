package Tavant.Learning.examples

object FindOddNumbersBetweenGivenRange extends App {

  def isEven(number: Int) = number % 2 == 0
  def isOdd(number: Int) = !isEven(number)

    val tests = List.range(-2, 10)
    for (n <- tests) {
      if (isEven(n)) {
        println(n)
      }
      if (isOdd(n)) {
        println(n)
      }
    }
  }
