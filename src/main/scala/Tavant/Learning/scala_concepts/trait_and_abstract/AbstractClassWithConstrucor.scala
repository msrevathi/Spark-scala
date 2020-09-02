package Tavant

/*
Reason to use abstract class instead of trait
1.You want to create a base class that requires constructor arguments.
2.The code will be called from Java code
 */
abstract  class AbstractClassWithConstrucor(name: String,
                                            topic: String)  {

  def details()
}

class GFC(name: String, topic : String) extends AbstractClassWithConstrucor(name , topic){
  override def details(): Unit={
    println("Author name: " + name)
    println("Topic name: " + topic)
  }

  // final method , which cannot be overridden
  final  def finalMethod(): Unit={
    println("final method")
  }
}
// Case Class can extend another Class or Abstract Class.
case class Card(name: String, topic: String) extends
  AbstractClassWithConstrucor(name: String, topic: String) {
  override def details():Unit = {
    println("Author name card: " + name)
    println("Topic name card : " + topic)
  }
}

object Main1{
  def main(args: Array[String]): Unit = {
    val x =  new GFC("scala", "AbstractClassWithConstrucor")
    x.details()
    x.finalMethod()
   val y = Card("English", "Grammer")
    println(y.name)
    println(y.topic)
    y.details()
    val copy_y = y.copy()
    if(copy_y == y) println(true) else println(false)
  }

}