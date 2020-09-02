package Tavant
 // https://www.geeksforgeeks.org/scala-sealed-trait/
sealed trait geeks {
  val article = "not done"
}

class java extends geeks {
  override val article = "java article"
}

class scala extends geeks {
  override val article = "scala article"
}

class csharp extends geeks {
  override val article = "csharp article"
}

object main4 {

  def display(options: geeks): String = options match {
    case x : scala => x.article
    case y: java => y.article
    case z : csharp => z.article // commenting this will give warning
  }

  def main(args: Array[String]): Unit = {
    val x = new java
    val y = new scala
    val z = new csharp
    println(display(x))
    println(display(y))
    println(display(z))
  }


}