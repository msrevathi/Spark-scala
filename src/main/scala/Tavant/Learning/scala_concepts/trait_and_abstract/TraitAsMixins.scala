package Tavant.Learning.scala_concepts.trait_and_abstract

// https://commitlogs.com/2016/10/01/scala-trait-and-abstract-class/

/*
Reason to use abstract class instead of trait
1.You want to create a base class that requires constructor arguments.
2.The code will be called from Java code

But trait can be combined together with abstract class to
take advantage of its constructor parameter.
 */
object TraitAsMixins extends  App {

  val dog: Dog = new Dog("Zeus")
  println(dog.name)
  dog.ownerIsHome
  dog.wagTail
  dog.speak
}

trait Tail{
  def wagTail =println("tail is wagging")
}

abstract class Pet (var name: String) {
  def speak  // abstract
  def ownerIsHome { println("excited") }
}

abstract class Bird(name:String){
  def fly() = println("Bird will fly")
}
class Dog(name: String) extends Pet(name:String)  with Tail{
  override def speak: Unit = println("wooff")
}


/*
 A class can extend multiple trait, but only one abstract class
 */

/*
class Rabbit (name: String) extends Pet(name:String) with Bird with Tail{
  override def speak: Unit = println("wooff")
}
 throws compile error : Bird has to Trait for mixin

*/

