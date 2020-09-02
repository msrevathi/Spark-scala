/*
package Tavant.Learning.scala_concepts.trait_and_abstract

trait Geeks1
{
  def method1() =
  {
    println("method - 1 Trait 1")
  }
}

trait Geeks2
{
  def method1() =
  {
    println("method - 1 Trait 2 ")
  }
}

class GFG extends Geeks1 with Geeks2 {

//  override  def method1() =
//  {
//    println(" override method - 1 Trait 1");
//  }
/*
Error:(19, 7) class GFG inherits conflicting members:
  method method1 in trait Geeks1 of type ()Unit  and
  method method1 in trait Geeks2 of type ()Unit
(Note: this can be resolved by declaring an override in class GFG.)
class GFG extends Geeks1 with Geeks2 {
 */
   def method2() =
  {
    println("Trait 2");
  }
}
object Main
{
  def main(args: Array[String])
  {
    var obj = new GFG();
    obj.method1();
    obj.method2();
  }
}
*/
