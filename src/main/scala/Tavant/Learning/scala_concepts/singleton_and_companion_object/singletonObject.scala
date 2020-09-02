package Tavant.Learning.scala_concepts.singleton_and_companion_object

/*
There is no static keyword in Scala, instead we have singleton objects.
All we need is to use object keyword to create a singleton object.
We can call it’s methods directly, we can’t pass parameters to its primary constructor.
Below is a quick example of singleton objects in Scala.
 */
object singletonObject {
  def say(){
    println("Hi")
  }
}

object SingeltonMain extends App{
  singletonObject.say()
 //  val x = new singletonObject
   /*when an object is defined like this without a corresponding class,
   you can’t create an instance of it.*/
}