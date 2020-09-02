package Tavant.Learning.examples

object addToPreviousElement extends App {

  val ll = List(1, 2, 3) // 1,3,5
  /*
  // val defal = ll(0)
  /*val xx = ll.foldLeft(defal)((x,y) => {
  x+y
  })
  println(xx)
*/
  // val ll: Iterator[Int] = Iterator(1, 2, 3)
//  while (ll.hasNext) {
//
//    for (x <- ll) yield x.toInt+ll.next()
//  }
// for(x <- 0 to ll.size){*/
  /* for(i <- 0 to ll.size) {
    try {
    val res = if (i - 1 < 0) ll(i)
    else if (i - 1 >= 0) ll(i) + ll(i - 1)

    print(res.toString.mkString.toList)
  }
  catch {
    case e: IndexOutOfBoundsException => e.getMessage
  }
  }*/


  def addPre(lk: List[Int]): List[Int] = {
    // val ll = List(1, 2, 3)
    var res = List[Int]()
    for (i <- 0 until lk.length) {
      val x = if (i - 1 < 0) lk(i) else lk(i) + lk(i - 1)
      res = x.toInt :: res
    }
    res.reverse
  }

  println(addPre(ll))
}