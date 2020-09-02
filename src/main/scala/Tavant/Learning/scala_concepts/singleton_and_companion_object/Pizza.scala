package Tavant.Learning.scala_concepts.singleton_and_companion_object

// Pizza class
class Pizza (var crustType: String) {
  override def toString = "Crust type is " + crustType
  println("accessing companion objects private members" +Pizza.objPrivate)

  private val  clsPrivate = "cls private member"
}

// companion object
object Pizza  extends App {
  val CRUST_TYPE_THIN = "thin"
  val CRUST_TYPE_THICK = "thick"
  def getFoo = "Foo"
  private val  objPrivate = "obj private member"
  //  members of the Pizza object can be accessed just as static members of a Java class
  println(Pizza.CRUST_TYPE_THIN)
  println(Pizza.getFoo)
  // can also create a new Pizza instance and use it as usual
  var p = new Pizza(Pizza.CRUST_TYPE_THICK)
  println(p)
  println(p.clsPrivate)


}