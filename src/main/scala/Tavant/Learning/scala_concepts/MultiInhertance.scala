package Tavant

trait Trait11{
  def meth1 = println("this is method 1")
}

trait Trait22{
  def meth1 = println("this is method 2")
}

class MultiInhertance extends Trait11 with Trait22{
  override def meth1: Unit = super.meth1
}

object main33{
  def main(args: Array[String]): Unit = {
     val x = new MultiInhertance
x.meth1
  }
}