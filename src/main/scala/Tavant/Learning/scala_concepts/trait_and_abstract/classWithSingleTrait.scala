package Tavant

import Tavant.Learning.scala_concepts.trait_and_abstract.Trait1


class MyTraitClass extends Trait1 {
  override def pet = {
    println("pet")
  }

  override def pet_color: Unit = {
    println("white pet")
  }

  def classMethod = {
    println("class meth")
  }

  var value: Int = 1
  Height = 40 // override not required for var variables
  override val Width = 10 // override for val variables

  def display = {

    printf("Value:%d", value)
    printf("\nHeight:%d", Height)
    printf("\nWidth:%d", Width)
  }

}
object Main2 {
  def main(args: Array[String]): Unit = {

    val x = new MyTraitClass
    x.pet
    x.pet_color
    x.classMethod
    x.greetings
    x.display
  }
}




