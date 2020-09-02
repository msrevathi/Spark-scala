package Tavant.Learning.scala_concepts.trait_and_abstract


trait Openable {
  def open() // { println("Super trait") }
}
trait Window extends Openable {
  override  def open()  = {println("window trait")}
}
trait Door extends Openable {
  override  def open() = {println("Door trait")}
}
class WindowDoor extends  Window with  Door  // takes the method from Door trait


trait Base {
  def op: String
}

trait Foo extends Base {
  override def op = "foo"
}

trait Bar extends Base {
  override def op = "bar"
}

class A extends Foo with Bar // takes the method from Bar trait
class B extends Bar with Foo // takes the method from Foo trait

object MultipleInheritance2 extends App{
  val a = new A
  val b = new B

  println("This "+a.op)
  println("That  "+b.op)


  val windowDoor = new WindowDoor
  windowDoor.open()
}
