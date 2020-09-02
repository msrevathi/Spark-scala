package Tavant.Learning.scala_concepts.constructors

// https://www.journaldev.com/9821/scala-auxiliary-constructors-in-depth

//  class with one Primary Constructor and Zero-Argument Auxiliary Constructor

class Employee1 (val empId: Int, val empName: String){
  println("From Primary Constructor")
  def this(){
    this(0,null) // Zero-Argument Auxiliary Constructor  call to Primary Constructor
  }
  println("From Zero-Argument Auxiliary Constructor")
}

//  class with one Primary Constructor and Multiple Auxiliary Constructors.

class Employee2 (val empId: Int, val empName: String){
  println("From Primary Constructor")
  def this(){
    this(0,null) // Zero-Argument Auxiliary Constructor  call to Primary Constructor
    println("From Zero-Argument Auxiliary Constructor")
  }
  def this(empid : Int){
    this(empid, null)
    println("From One-Argument Auxiliary Constructor")
  }
}
object Employee1Test1 extends App{
  val emp1 = new Employee1()
  val emp21 = new Employee2(1)
  val emp22 = new Employee2()
  val emp23 = new Employee2(2,"chuba")


}
