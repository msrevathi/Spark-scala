package Tavant.Learning.scala_concepts.polymorphism
// https://www.journaldev.com/8495/scala-polymorphic-methods-and-explicitly-typed-references
/*
example of polymorphism in method. We will write a generic method to get the list where we will pass the type, default values and number of items in the list.
 */
object TypePolymorphism {

  def getList[T](x:T,y:Int):List[T]={
    if(y == 0){Nil}
    else  x :: getList(x, y-1)
  }

  def main(args: Array[String]) {
    println(getList[Int](3,2))
    println(getList[String]("Hi", 3))
  }
}
