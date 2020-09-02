package Tavant.Learning.examples

object alternatingCharacter extends App {

  def altChar(str: String): Int = {
    var cnt = 0
    for(x <- 0 until str.length-1){
      if(str.charAt(x) == str.charAt(x+1) )
        cnt = cnt+1
    }
    cnt
  }
  println(altChar("AAAA")) // 3
  println(altChar("BBBBB")) //4
  println(altChar("ABABABAB")) //0
  println(altChar("BABABA")) //0
  println(altChar("AAABBB")) // 4
  println(altChar("1222AAA")) //4
  println(altChar("12   AA")) // 3

}
