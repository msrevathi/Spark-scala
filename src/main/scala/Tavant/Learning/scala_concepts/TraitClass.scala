package Tavant

trait Trait1 {

  // abstracts methods
  def pet

  def pet_color

  // Non-abstract method
  def greetings = {
    println("greeetings")
  }

  // Abstract field
  var value: Int

  // Concrete field
  var Height = 10
  val Width = 30
}

trait Trait2 {
  def vehicle

  def bus = {
    println("juuuuu")
  }
}

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

  override var value: Int = 1
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

    println("-------This is mutiple traits----------")
    val y = new MyClass
    y.pet
    y.greetings
    y.pet_color
    y.vehicle
    y.display
  }
}


class MyClass extends Trait1 with Trait2 {
  override def pet: Unit = {
    println("pet1")
  }

  override var value: Int = 2

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

// Trait can extend trait
trait Trait3 extends Trait2 {

}