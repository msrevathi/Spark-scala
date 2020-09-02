package Tavant.Learning.scala_concepts.trait_and_abstract

object ClassExtendingTwoTraits extends App {
  println("-------This is mutiple traits----------")
  val y = new MyClass
  y.pet
  y.greetings
  y.pet_color
  y.vehicle
  y.display
}

class MyClass extends Trait1 with Trait2 {
  override def pet: Unit = {
    println("pet1")
  }

  var value: Int = 2

  override def pet_color: Unit = {
    println("black")
  }

  override def vehicle: Unit = {
    println("pep....pep")
  }

  def display = {

    printf("Value:%d", value)
    printf("\nHeight:%d", Height)
    printf("\nWidth:%d", Width)
  }
}