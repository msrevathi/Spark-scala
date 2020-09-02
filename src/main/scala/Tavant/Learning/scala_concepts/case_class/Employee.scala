package Tavant.Learning.scala_concepts.case_class

import Tavant.{AbstClass, AbstractClassWithConstrucor}
case class Employee(name: String)

// https://www.journaldev.com/9733/scala-caseclass-caseobject-part1
// https://www.journaldev.com/12122/scala-caseclass-caseobject-part2
// case object
case object Employee

// case class without parameters
/**
  * case class Employee()  // allowed
  * case class Employee //  not allowed : case class without parameters is not allowed
  */
// Normal object
object Normalemployee

// Case Object Vs Object(Normal Object)
/**
  *
  * scala> case object Employee
  *
  * defined object Employee
  *
  * scala> Employee.isInstanceOf[Serializable]
  * res3: Boolean = true
  *
  * scala> object Normalemployee
  *
  *
  * defined object Normalemployee
  *
  * scala> Normalemployee.isInstanceOf[Serializable]
  * <console>:13: warning: fruitless type test: a value of type Normalemployee.type cannot also be a Serializable
  *        Normalemployee.isInstanceOf[Serializable]
  * ^
  * res4: Boolean = false
  *
  * scala>
  *
  */

// abstract case class allowed after 2.7
abstract case class Card(id:Int)

// case class inheritance -- not allowed

// case class Foo(override val name: String, term: String) extends Employee(name)

/**
  * Error:(46, 12) case class Foo has case ancestor Tavant.Learning.scala_concepts.case_class.Employee,
  * but case-to-case inheritance is prohibited. To overcome this limitation, use extractors to pattern match on non-leaf nodes.
  * case class Foo(override val name: String, term: String) extends Employee(name)
  */
// Case Class can extend another Class or Abstract Class.
case class SuperCard(name: String, topic: String) extends
  AbstractClassWithConstrucor(name: String, topic: String) {
  override def details():Unit = {
    println("Author name card: " + name)
    println("Topic name card : " + topic)
  }
}

object AbstractCaseMain {
  def main(args: Array[String]): Unit = {
    val y = SuperCard("English", "Grammer")   // create objects of the Case Class without using “new” keyword.
    println(y.name)
    println(y.topic)
    y.details()
    val copy_y = y.copy()
    if (copy_y == y) println(true) else println(false)
    // y.name = "Spanish"
    /**
      * Case class constructor parameters are by default val
      * By Default, Scala Compiler generates only getters for Case
      * Class Parameters. However, if we use “var” to Case Class Parameters,
      * Scala Compiler generates both setters and getters
      */

    // ===============
    val z = SubManager("revathi", "   chuba")
    println(z.subManager)
    println(z.manager)
    z.display()
    //==========
    val p = SubCollege("111")
    println("this p.student "+p.student())
    println(p.heldo)

    // =================

    var book1 = Book("FP In Scala")
    book1.name = "ppppp"
    println(book1.name)

    /**
      * setters possible if the parameters are var
      */
  }
}
  /**
    **********output*************
    * English
    * Grammer
    * Author name card: English
    * Topic name card : Grammer
    * true
    */

  class Manager(manager: String) {
    def display():Unit = {
      println("manager  class" +manager)
    }
  }
  case class SubManager(manager: String, subManager: String) extends Manager(manager){
    override def display():Unit = {
     super.display() // to call the super class method
       println("sub Manager   " +subManager) // to call child class method
    }
  }

  // A Case Class or Case Object can extend a Trait.
 trait College {
    var Height : Int = 10
  def student() : Unit = println("studen height  " +Height)

  }
  case class SubCollege(heldo: String) extends College{
    // override  var Height = 20    // this is not working says cannot below msg
    override def student():Unit=println("sbu studen height" +Height)
  }

/**
  * Error:(125, 19) overriding variable Height in trait College of type Int;
  * variable Height cannot override a mutable variable
  * override  var Height = 20
  */


case object SimpleEvent extends College


// Case Class Parameters with “var”
case class Book(var name:String)
//
//case class Authors(name:String)

