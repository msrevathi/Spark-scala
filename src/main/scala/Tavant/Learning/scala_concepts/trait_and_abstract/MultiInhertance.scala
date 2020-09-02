package Tavant.Learning.scala_concepts.trait_and_abstract

trait Trait11{
  def meth1 = println("this is method 1")
}

trait Trait22{
  def meth1 = println("this is method 2")
}

class MultiInhertance extends Trait11 with Trait22{
  override def meth1: Unit = println("yyy")
}

object main33{
  def main(args: Array[String]): Unit = {
     val x = new MultiInhertance
x.meth1
  }
}
// note : miltiple inheritance in  java https://www.tutorialspoint.com/what-is-diamond-problem-in-case-of-multiple-inheritance-in-java#:~:text=According%20to%20our%20assumption%2C%20since,both%20classes%20Super1%20and%20Super2.&text=This%20issue%20is%20known%20as,more%20than%20one%20other%20class.