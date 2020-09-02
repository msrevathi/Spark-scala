package Tavant.Learning.scala_concepts.trait_and_abstract

object TraitExtendTrait extends App {
  println("-------traits extends traits----------")
  val z = new TowTraits
  z.mom
  z.vehicle
}

// Trait can extend trait
trait Trait3 extends Trait2 {

  def mom: Unit = {
    println("mom")
  }
}

class TowTraits extends Trait3 {
  override def mom = {
    println("TowTraits mom")
  }

  super.mom

  override def vehicle: Unit = {
    println("TowTraits vehicle")
  }
}