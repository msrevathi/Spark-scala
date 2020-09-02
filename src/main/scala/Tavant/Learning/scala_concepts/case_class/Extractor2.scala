package Tavant.Learning.scala_concepts.case_class
object firstName {
  def main(args: Array[String]) {

    println("Apply method : " + apply("Steve", "Smith"));
    println("Unapply method : " + unapply("Steve Smith"));
    println("Unapply method : " + unapply("Rob"));

  }

  def apply(fname: String, lname: String) = {
    fname + " " + lname
  }

  def unapply(s: String): Option[(String, String)] = {
    val pts = s split " "
    if (pts.length == 2) {
      Some(pts(0), pts(1))
    } else {
      None
    }
  }
}