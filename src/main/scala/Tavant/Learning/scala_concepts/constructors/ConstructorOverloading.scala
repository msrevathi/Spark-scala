package Tavant.Learning.scala_concepts.constructors

class Employee3(val empId: Int = 0, val empName: String = "") {
  println("From Primary Constructor")
  println("Empid = " + (empId == 0))
  println("Empname = " + empName.isEmpty)
}

object ConstructorOverloading extends App{
  val x = new Employee3()
  val y = new Employee3(100)
  val z = new Employee3(12, "dude")

}
