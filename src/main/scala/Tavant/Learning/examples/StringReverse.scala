package Tavant.Learning.examples

object StringReverse extends App {

  def revString(x:String):String={
    x.foldLeft("")((x,y)=> y+x)
  }

  println(revString("Qwerty"))
}
