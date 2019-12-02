package Tavant

abstract class AbstClass {

  var name : String = "GeeksforGeeks"
  var variable: String = "Scala"

def portal()
  def tutorial(): Unit ={
    println("scala tutorial1")
  }
}

class GFG extends AbstClass {

  // Abstract class method accessing fields of the abstract class
  override def portal(): Unit = {println(s"This is Portalaa " +name)}

  // override def tutorial(): Unit = super.tutorial()

  // Non-abstract method  &&
  // GFG class method accessing  fields of the abstract class
  def tutdetails (): Unit ={
    println(s"This is Portalaa " +variable)
  }
}

object Main{
  def main(args: Array[String]): Unit = {
    val x = new GFG
    // val x = new AbstClass
    // throws compile time error class AbstClass is abstract; cannot be instantiated
    x.portal()
    x.tutorial()
    x.tutdetails
  }
}
