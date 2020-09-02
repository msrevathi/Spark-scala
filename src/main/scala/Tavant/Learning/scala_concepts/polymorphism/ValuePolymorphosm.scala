package Tavant.Learning.scala_concepts.polymorphism

// https://www.journaldev.com/8495/scala-polymorphic-methods-and-explicitly-typed-references
object ValuePolymorphosm {

  def main(args: Array[String]): Unit = {
    def addStrings(x: String, y: String) = {
      println(x + y)
    }


    def addInts(x: Int, y: Int) = {
      println(x + y)
    }

    addInts(1, 2)
    addStrings("chu  ", "ba")
  }

}
