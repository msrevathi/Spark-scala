package Tavant.Learning.scala_concepts.constructors

// https://www.journaldev.com/9810/scala-primary-constructor-indepth

// create primary constructor with no Arguments
class Person  // or class Person()
// instantiate primary constructor with no Arguments
/*
val p1 = new Person()
 OR
 var p2 = new Person
 */

// create primary constructor with  Arguments

class Person1(firstName:String, middleName:String, lastName:String){
  // Class body goes here
}
// instantiate primary constructor with  Arguments
//val p1 = new Person("First","","Last")

/* CLASS MEMBERS :
1. Anything we place within the Class Body other than Method definitions, is a part of the Primary Constructor.
2. Any Statements or Loops (like If..else, While,For etc) defined in the Class Body also become part of the Primary Constructor.
3. Not only Statements or Expressions, any method calls defined in the Class Body also become part of the Primary Constructor.
*/

class Person2(firstName:String, middleName:String, lastName:String){
  println("Statement 1")  // is  a part of the Primary Constructor.

  def fullName() = firstName + middleName + lastName // is not a part of the Primary Constructor.

  if (middleName.trim.length ==0)
    println("Middle Name is empty.")  // is  a part of the Primary Constructor.

  println("Statement 2")   // is  a part of the Primary Constructor.

  println(fullName)   // A No-argument Method Call , is  a part of the Primary Constructor.

}

object PrimaryConstructor extends App{
  val x = new Person2("FirstName", "", "LastName")

}