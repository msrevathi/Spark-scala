package Tavant.Learning.examples

import java.util
import java.util.Comparator

case class Player(name: String, score: Int)

class Checker extends Comparator[Player] {
  def compare(p1: Player, p2: Player): Int = {
    /*  // for comparison
       val NameCompare = a.name.compareTo(b.name)
       val scoreCompare = a.score.compareTo(b.score)

       // 2-level comparison using if-else block
       if (NameCompare == 0) {
         if(scoreCompare == 0)  NameCompare else scoreCompare
       } else {
         NameCompare
       }*/

   /* if (p1.score < p2.score) 1
    else if (p1.score > p2.score) -1
    else p1.name.compareTo(p2.name)*/

    if(p1.score == p2.score)  p1.name.compareTo(p2.name) else p2.score - p1.score
  }

}
  object Checker {
    def main(args: Array[String]): Unit = {

      var al = new util.ArrayList[Player]()

      val p1 = Player("Smith", 10)
      val p2 = Player("Johes", 20)

      // val p3 = Player("Johes", 15)
      val cs = new Checker
      println(cs.compare(p1, p2))

    }
  }