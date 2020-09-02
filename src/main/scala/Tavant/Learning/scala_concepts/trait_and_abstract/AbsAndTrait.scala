package Tavant

import Tavant.Learning.scala_concepts.trait_and_abstract.Trait1

// abstract class can extend trait
abstract class AbsAndTrait extends Trait1 {
  override def pet: Unit = println("peeeet")

  override def pet_color: Unit = println("pe clr grey")
}

class AbsTraitClass extends AbsAndTrait {

  override var value: Int = _

  def test1 = println("abs class extedns train and this class method")

}

object main3 {
  def main(args: Array[String]): Unit = {
    val x = new AbsTraitClass
    x.test1
    x.greetings
    x.pet
    x.pet_color

  }
}