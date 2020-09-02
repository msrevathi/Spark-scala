package Tavant.Learning.scala_concepts.trait_and_abstract

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