package Tavant.Learning.scala_concepts.constructors

// Primary constructor with vars - both getters and setters are available
class Names1(var firstName:String, var middleName:String, var lastName:String)

// Primary constructor with vals - both getters s are available
class Names2(val firstName:String, val middleName:String, val lastName:String)

// Primary constructor with nothing (default) - both getters and setters are not available
class Names3(firstName:String, middleName:String, lastName:String)

object ConstructorWithValAnsVarParameters extends App{

  val p1 = new Names1("first", "middle", "last")
  val pp = p1.firstName = "first first"
  println("Constructor with vars" +pp)

  val p2 = new Names2("first", "middle", "last")
  println("Constructor with vars" )//+p2.firstName = "first first")
  // p2.firstName = "first first"  // compile error -> reassignment to val

  val p3 = new Names3("first", "middle", "last")
  // println("Constructor with vars"+p3.firstName = "first first")
  // p3.firstName = "first first" // firstName is not available

}