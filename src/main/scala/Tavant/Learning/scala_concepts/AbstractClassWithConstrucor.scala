package Tavant

/**
 * Hello world!
 *
 */
abstract  class AbstractClassWithConstrucor(name: String,
                                            topic: String)  {

  def details()
}

class GFC(name: String, topic : String) extends AbstractClassWithConstrucor(name , topic){
  override def details()={
    println("Author name: " + name)
    println("Topic name: " + topic)
  }

  // final method , which cannot be overridden
  final  def finalMethod={
    println("final method")
  }
}

object Main1{
  def main(args: Array[String]): Unit = {
    val x =  new GFC("scala", "AbstractClassWithConstrucor")
    x.details()
    x.finalMethod
  }

}