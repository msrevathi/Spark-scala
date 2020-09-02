package Tavant.Learning.scala_concepts.polymorphism

class ScalaPolymorphism {
  def fun1(x: Int): Unit = {

    println(s"this is first $x")
  }

  def fun1(x: Int, y: Int): Unit = {
    val res = x+y
    println(s"this is second  $res ")
  }

  def fun1(x: Int, y: Int, z:Int): Unit = {
   val res = x+y+z
    println(s"this is third  $res ")
  }

  def fun1(x: String): Unit = {

    println(s"this is strinf  $x ")
  }
}

object main5{
  def main(args: Array[String]): Unit = {
    val x = new ScalaPolymorphism
    x.fun1(1)
    x.fun1(1,2)
    x.fun1(1,2,3)
    x.fun1("hii")
  }
}