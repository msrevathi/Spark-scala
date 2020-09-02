import scala.collection.mutable

object SubSting extends App{
  def twoStrings(s1: String, s2: String): String = {
    val s1chars: mutable.HashSet[Char] = new mutable.HashSet()
    val s2chars: mutable.HashSet[Char] = new mutable.HashSet()
    for (x <- 0 until  s1.length) {
      s1chars.add(s1.charAt(x))
    }
    for (x <- 0 until  s2.length) {
      s2chars.add(s2.charAt(x))
    }
    val res = s1chars.intersect(s2chars)
    if(res.nonEmpty) "yes" else "No"
  }
  println(twoStrings("hello", "world"))
}